/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import MessagesTypes.ListeFormateursCompatibles;
import MessagesTypes.ListeSallesCompatibles;
import business.GestionFormationLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author 33785
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "FILE_LISTE_RESSOURCES")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FileListeRessourcesListener implements MessageListener {
    
    @EJB
    GestionFormationLocal gfl;
    
    public FileListeRessourcesListener() {
    }
    
    @Override
    public void onMessage(Message message) {
        Logger.getLogger(FileListeRessourcesListener.class.getName()).log(Level.INFO, "[APPLI TECHNICO] FileListeRessourcesListener - onMessage()");
        if (message instanceof ObjectMessage) {
            try {
                Object pqObj = ((ObjectMessage) message).getObject();
                if (pqObj instanceof ListeFormateursCompatibles) {
                    ListeFormateursCompatibles formateursCompatibles = (ListeFormateursCompatibles) pqObj;
                    this.gfl.envoyerFormateursDisponibles(formateursCompatibles);
                } else if (pqObj instanceof ListeSallesCompatibles) {
                    ListeSallesCompatibles sallesCompatibles = (ListeSallesCompatibles) pqObj;
                    this.gfl.envoyerSallesDisponibles(sallesCompatibles);
                }
            } catch (JMSException ex) {
                Logger.getLogger(FileVerifierExistenceListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (message != null) {
            System.out.println("Received non text message");
        }
    }
    
}
