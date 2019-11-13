/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Formation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import resources.FormationResource;
import services.FormationServiceLocal;

/**
 *
 * @author 33785
 */
@Path("formations")
public class FormationRest {
    
    // Accès BackOffice
    FormationServiceLocal fsl;

    @Context
    private UriInfo context;

    // Convertisseur JSON
    private Gson gson;

    /**
     * Constructeur Ressource
     */
    public FormationRest() {
        this.gson = new Gson();
        this.fsl = lookupFormationServiceLocal();
    }

    /**
     * Lister les formations. Pour appeler cette méthode on doit utiliser l'URL :
     * http://localhost:8080/TechnicoCommercial-web/webresources/formations
     *
     * @return liste des équipements
     */
    @GET
    public String getFormations() {
        List<Formation> listeFormations = this.fsl.listerFormations();
        return this.gson.toJson(listeFormations);
    }
    
    /**
     * Créer une nouvelle formation. Pour appeler cette méthode on doit utiliser l'URL :
     * http://localhost:8080/TechnicoCommercial-web/webresources/formations
     * 
     * @param formation
     * @param codeFormation
     * @param libelleFormation
     * @param nbMax
     * @param niveauFormation
     * @param dureeFormation
     * @param equipementsNecessaires
     * @param competencesNecessaires
     * @param nbMin
     * @param thematiqueFormation
     * @return 
     */
    /*
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createFormations(@FormParam("codeFormation") String codeFormation, @FormParam("libelleFormation") String libelleFormation, 
            @FormParam("dureeFormation") int dureeFormation, @FormParam("equipementsNecessaires") String equipementsNecessaires,
            @FormParam("competencesNecessaires") String competencesNecessaires, @FormParam("nbMin") int nbMin, 
            @FormParam("nbMax") int nbMax, @FormParam("thematiqueFormation") String thematiqueFormation, @FormParam("niveauFormation") int niveauFormation) {

        List<Integer> listeEquipementsNecessaires = transformStringToList(equipementsNecessaires);
        List<Integer> listeCompetencesNecessaires = transformStringToList(competencesNecessaires);
        
        //System.out.println("code : " + codeFormation + ", libelle : " + libelleFormation + ", duree : " + dureeFormation + ", equipements : " + listeEquipementsNecessaires +
        //        ", competences : " + listeCompetencesNecessaires + ", nbMin : " + nbMin + ", nbMax : " + nbMax + ", thematiqueFormation : " + thematiqueFormation + ", niveauFormation" + niveauFormation);
        
        this.fsl.creerFormation(codeFormation, libelleFormation, dureeFormation, listeEquipementsNecessaires, listeCompetencesNecessaires, nbMin, nbMax, thematiqueFormation, niveauFormation);

        return Response.status(Status.OK).build();
    }
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFormationBis(String formationString) {
        System.out.println(formationString);
        FormationResource fr = gson.fromJson(formationString, FormationResource.class);
        this.fsl.creerFormation(fr);
        return Response.status(Status.OK).build();
    }
    
    public List<Integer> transformStringToList(String toTransform) {
        List<Integer> list = new ArrayList<Integer>();
        String[] valeurs = toTransform.split(",");
        for(int i = 0; i < valeurs.length; i++){
            list.add(Integer.parseInt(valeurs[i]));
        }
        return list;
    }
    
    /**
     * Supprimer une formation Pour appeler cette méthode on doit utiliser l'URL :
     * http://localhost:8080/TechnicoCommercial-web/webresources/formations
     */
    @DELETE
    public void deleteFormation(@QueryParam("idFormation") int idFormation) {
        this.fsl.supprimerFormation(idFormation);
    }

    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
    private FormationServiceLocal lookupFormationServiceLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (FormationServiceLocal) c.lookup("java:global/TechnicoCommercial-ear/TechnicoCommercial-ejb-1.0-SNAPSHOT/FormationService!services.FormationServiceLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
