/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.EquipementBis;
import entities.Formation;
import entities.LienFormationCompetence;
import entities.LienFormationEquipement;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.FormationFacadeLocal;
import repositories.LienFormationCompetenceFacadeLocal;
import repositories.LienFormationEquipementFacadeLocal;
import resources.FormationResource;

/**
 *
 * @author 33785
 */
@Stateless
public class GestionFormation implements GestionFormationLocal {

    @EJB
    FormationFacadeLocal ffl;

    @EJB
    LienFormationEquipementFacadeLocal lienFacadeEquipement;

    @EJB
    LienFormationCompetenceFacadeLocal lienFacadeCompetence;

    /*
    @Override
    public void creerFormation(String codeFormation, String libelleFormation, int dureeFormation, List<Integer> equipementsNecessaires, List<Integer> competencesNecessaires, int nbMin, int nbMax, String thematiqueFormation, int niveauFormation) {
        Formation f = new Formation();
        f.setCodeFormation(codeFormation);
        f.setLibelleFormation(libelleFormation);
        f.setDureeFormation(dureeFormation);
        f.setNbMin(nbMin);
        f.setNbMax(nbMax);
        f.setThematiqueFormation(thematiqueFormation);
        f.setNiveauFormation(niveauFormation);
        Formation newF = ffl.create(f);
        //int idFormation = ffl.findByCode(codeFormation);
        //System.out.println("idFormation : " + idFormation);
        // Ajout lien formation - equipementBis
        for (int idEquipement : equipementsNecessaires) {
            System.out.println("id formation : " + newF.getIdFormation() + ", idEquipement : " + idEquipement);
            LienFormationEquipement lienformationEquipement = new LienFormationEquipement(newF.getIdFormation(), idEquipement);
            lienFacadeEquipement.create(lienformationEquipement);
        }
        // Ajout lien formation - competenceBis
        for (int idCompetence : competencesNecessaires) {
            LienFormationCompetence lienFormationCompetence = new LienFormationCompetence(newF.getIdFormation(), idCompetence);
            lienFacadeCompetence.create(lienFormationCompetence);
        }
    }*/
    @Override
    public void creerFormation(FormationResource formation) {
        Formation f = new Formation();
        System.out.println("code : " + formation.getCodeFormation());
        System.out.println("libelle : " + formation.getLibelleFormation());
        System.out.println("duree : " + formation.getDureeFormation());
        System.out.println("nbMin : " + formation.getNbMin());
        System.out.println("nbMax : " + formation.getNbMax());
        System.out.println("thema : " + formation.getThematiqueFormation());
        System.out.println("niveau : " + formation.getNiveauFormation());
        f.setCodeFormation(formation.getCodeFormation());
        f.setLibelleFormation(formation.getLibelleFormation());
        f.setDureeFormation(formation.getDureeFormation());
        f.setNbMin(formation.getNbMin());
        f.setNbMax(formation.getNbMax());
        f.setThematiqueFormation(formation.getThematiqueFormation());
        f.setNiveauFormation(formation.getNiveauFormation());
        Formation newF = ffl.create(f);
        System.out.println("ok");
        // Ajout lien formation - equipementBis
        for (int idEquipement : formation.getEquipementsNecessaires()) {
            System.out.println("id formation : " + newF.getIdFormation() + ", idEquipement : " + idEquipement);
            LienFormationEquipement lienformationEquipement = new LienFormationEquipement(newF.getIdFormation(), idEquipement);
            lienFacadeEquipement.create(lienformationEquipement);
        }
        // Ajout lien formation - competenceBis
        for (int idCompetence : formation.getCompetencesNecessaires()) {
            LienFormationCompetence lienFormationCompetence = new LienFormationCompetence(newF.getIdFormation(), idCompetence);
            lienFacadeCompetence.create(lienFormationCompetence);
        }
    }

    public List<Formation> listerFormations() {
        return this.ffl.findAll();
    }

    @Override
    public void supprimerFormation(int idFormation) {
        Formation formation = this.ffl.find(idFormation);
        this.ffl.remove(formation);
    }

}
