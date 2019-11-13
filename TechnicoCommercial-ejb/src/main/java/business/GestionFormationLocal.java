/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Formation;
import java.util.List;
import javax.ejb.Local;
import resources.FormationResource;

/**
 *
 * @author 33785
 */
@Local
public interface GestionFormationLocal {
    
    public List<Formation> listerFormations();
    
    //public void creerFormation(String codeFormation, String libelleFormation, int dureeFormation, List<Integer> equipementsNecessaires, List<Integer> competencesNecessaires, int nbMin, int nbMax, String thematiqueFormation, int niveauFormation);
    public void creerFormation(FormationResource formation);
    public void supprimerFormation(int idFormation);
    
}