/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.CompetenceBis;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import services.CompetenceBisServiceLocal;

/**
 *
 * @author 33785
 */
@Path("competences")
public class CompetenceBisRest {

    // Accès BackOffice
    CompetenceBisServiceLocal cbsl;

    @Context
    private UriInfo context;

    // Convertisseur JSON
    private Gson gson;

    /**
     * Constructeur Ressource
     */
    public CompetenceBisRest() {
        this.gson = new Gson();
        this.cbsl = lookupCompetenceBisServiceLocal();
    }

    /**
     * Creation d'un nouveau compte. Le solde est facultatif (défaut = 0.0). Pour appeler cette méthode on doit utiliser l'URL :
     * http://localhost:8080/TecgnicoCommercial-web/webresources/competences
     *
     * @return liste des compétences
     */
    @GET
    public String getCompetences() {
        List<CompetenceBis> listeCompetences = this.cbsl.listerCompetences();
        System.out.println(listeCompetences.get(0).getNomCompetence());
        return this.gson.toJson(listeCompetences);
    }

    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
    private CompetenceBisServiceLocal lookupCompetenceBisServiceLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (CompetenceBisServiceLocal) c.lookup("java:global/TechnicoCommercial-ear/TechnicoCommercial-ejb-1.0-SNAPSHOT/CompetenceBisService!services.CompetenceBisServiceLocal");
            
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
