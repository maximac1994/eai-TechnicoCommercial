/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import MessagesTypes.CodeFormationMessage;
import MessagesTypes.DemandeFormationMessage;
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
 * file verif existance
 * @author 33785
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "FILE_VERIF_EXISTENCE")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FileVerifierExistenceListener implements MessageListener {

    @EJB
    GestionFormationLocal gfl;

    /**
     *
     */
    public FileVerifierExistenceListener() {
    }

    /**
     * pour chaque message : verifie l'existance d'une formation
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        Logger.getLogger(FileVerifierExistenceListener.class.getName()).log(Level.INFO, "[APPLI TECHNICO] FileVerifierExistenceListener - onMessage()");
        if (message instanceof ObjectMessage) {
            try {
                Object pqObj = ((ObjectMessage) message).getObject();
                if (pqObj instanceof DemandeFormationMessage) {
                    DemandeFormationMessage demandeFormation = (DemandeFormationMessage) pqObj;
                    System.out.println("Received: " + demandeFormation.toString());
                    gfl.verifierExistanceFormation(demandeFormation);
                }
            } catch (JMSException ex) {
                Logger.getLogger(FileVerifierExistenceListener.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(FileVerifierExistenceListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (message != null) {
            System.out.println("Received non text message");
        }
    }

}
