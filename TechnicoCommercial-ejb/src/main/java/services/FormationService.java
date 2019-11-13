/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import business.GestionFormationLocal;
import entities.Formation;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import resources.FormationResource;

/**
 *
 * @author 33785
 */
@Stateless
public class FormationService implements FormationServiceLocal {
    
    @EJB
    GestionFormationLocal gfl;

    
    @Override
    public List<Formation> listerFormations() {
        return this.gfl.listerFormations();
    }
    
    @Override
    public void creerFormation(FormationResource formation) {
        System.out.println("ici c'est bon");
        this.gfl.creerFormation(formation);
    }

    @Override
    public void supprimerFormation(int idFormation) {
        this.gfl.supprimerFormation(idFormation);
    }

}
