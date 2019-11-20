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
import exceptions.UnknownFormationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import repositories.FormationFacadeLocal;
import repositories.LienFormationCompetenceFacadeLocal;
import repositories.LienFormationEquipementFacadeLocal;
import resources.FormationResource;
import sender.FileConfirmerExistenceSender;

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
    
    FileConfirmerExistenceSender senderConfirmerExistence;

    public GestionFormation() {
        this.senderConfirmerExistence = new FileConfirmerExistenceSender();
    }

    @Override
    public void creerFormation(FormationResource formation) {
        Formation f = new Formation();
        f.setCodeFormation(formation.getCodeFormation());
        f.setLibelleFormation(formation.getLibelleFormation());
        f.setDureeFormation(formation.getDureeFormation());
        f.setNbMin(formation.getNbMin());
        f.setNbMax(formation.getNbMax());
        f.setThematiqueFormation(formation.getThematiqueFormation());
        f.setNiveauFormation(formation.getNiveauFormation());
        Formation newF = ffl.create(f);
        // Ajout lien formation - equipementBis
        for (int idEquipement : formation.getEquipementsNecessaires()) {
            LienFormationEquipement lienformationEquipement = new LienFormationEquipement(newF.getIdFormation(), idEquipement);
            lienFacadeEquipement.create(lienformationEquipement);
        }
        // Ajout lien formation - competenceBis
        for (int idCompetence : formation.getCompetencesNecessaires()) {
            LienFormationCompetence lienFormationCompetence = new LienFormationCompetence(newF.getIdFormation(), idCompetence);
            lienFacadeCompetence.create(lienFormationCompetence);
        }
    }

    @Override
    public List<Formation> listerFormations() {
        return this.ffl.findAll();
    }

    @Override
    public void supprimerFormation(int idFormation) throws UnknownFormationException {
        Formation formation = this.ffl.find(idFormation);
        if (formation == null) {
            throw new UnknownFormationException();
        }
        this.ffl.remove(formation);
    }

    @Override
    public void verifierExistanceFormation(String codeFormation) throws JMSException, InterruptedException {
        if (this.ffl.findByCode(codeFormation).size() != 0) {
            System.out.println("OUI!!!");
            this.senderConfirmerExistence.publish(true);
        } else {
            System.out.println("NON!!!!");
            this.senderConfirmerExistence.publish(false);
        }
    }

}
