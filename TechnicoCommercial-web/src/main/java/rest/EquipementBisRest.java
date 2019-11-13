/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.EquipementBis;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import services.EquipementBisServiceLocal;

/**
 *
 * @author 33785
 */
@Path("equipements")
public class EquipementBisRest {
    
    // Accès BackOffice
    EquipementBisServiceLocal ebsl;

    @Context
    private UriInfo context;

    // Convertisseur JSON
    private Gson gson;

    /**
     * Constructeur Ressource
     */
    public EquipementBisRest() {
        this.gson = new Gson();
        this.ebsl = lookupEquipementBisServiceLocal();
    }

    /**
     * Creation d'un nouveau compte. Le solde est facultatif (défaut = 0.0). Pour appeler cette méthode on doit utiliser l'URL :
     * http://localhost:8080/TechnicoCommercial-web/webresources/equipements
     *
     * @return liste des équipements
     */
    @GET
    public String getEquipements() {
        List<EquipementBis> listeEquipements = this.ebsl.listerEquipements();
        return this.gson.toJson(listeEquipements);
    }

    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
    private EquipementBisServiceLocal lookupEquipementBisServiceLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (EquipementBisServiceLocal) c.lookup("java:global/TechnicoCommercial-ear/TechnicoCommercial-ejb-1.0-SNAPSHOT/EquipementBisService!services.EquipementBisServiceLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
