/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import MessagesTypes.DemandeFormationMessage;
import MessagesTypes.EvenementFormation;
import MessagesTypes.EvenementFormationProjet1;
import MessagesTypes.ListeFormateursCompatibles;
import MessagesTypes.ListeSallesCompatibles;
import entities.Formation;
import exceptions.UnknownFormationException;
import java.util.List;
import javax.ejb.Local;
import javax.jms.JMSException;
import resources.FormationResource;

/**
 * gestion des formations
 * @author 33785
 */
@Local
public interface GestionFormationLocal {

    /**
     * lister les formations disponibles
     * @return
     */
    public List<Formation> listerFormations();

    /** 
     * creer une formation
     * @param formation
     */
    public void creerFormation(FormationResource formation);

    /**
     * supprimer une formation
     * @param idFormation
     * @throws UnknownFormationException
     */
    public void supprimerFormation(int idFormation) throws UnknownFormationException;

    /**
     * verfie si une formation existe et envoie la reponse en JMS
     * @param demandeFormation
     * @throws JMSException
     * @throws InterruptedException
     */
    public void verifierExistanceFormation(DemandeFormationMessage demandeFormation) throws JMSException, InterruptedException;

    /**
     * liste les formateurs et les salles disponibles pour une formation
     * @param evenementFormation
     */
    public void listerFormateursSallesDisponibles(EvenementFormationProjet1 evenementFormation);

    /**
     *
     * @param formateursCompatibles
     */
    public void envoyerFormateursDisponibles(ListeFormateursCompatibles formateursCompatibles);

    /**
     *
     * @param sallesCompatibles
     */
    public void envoyerSallesDisponibles(ListeSallesCompatibles sallesCompatibles);

}
