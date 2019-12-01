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
 *
 * @author 33785
 */
@Local
public interface GestionFormationLocal {

    public List<Formation> listerFormations();

    public void creerFormation(FormationResource formation);

    public void supprimerFormation(int idFormation) throws UnknownFormationException;

    public void verifierExistanceFormation(DemandeFormationMessage demandeFormation) throws JMSException, InterruptedException;

    public void listerFormateursSallesDisponibles(EvenementFormationProjet1 evenementFormation);

    public void envoyerFormateursDisponibles(ListeFormateursCompatibles formateursCompatibles);

    public void envoyerSallesDisponibles(ListeSallesCompatibles sallesCompatibles);

}
