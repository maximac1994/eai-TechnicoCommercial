/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import MessagesTypes.CodeFormationMessage;
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
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "FILE_VERIF_EXISTENCE")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FileVerifierExistenceListener implements MessageListener {

    @EJB
    GestionFormationLocal gfl;
    
    public FileVerifierExistenceListener() {
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                Object pqObj = ((ObjectMessage) message).getObject();
                if (pqObj instanceof CodeFormationMessage) {
                    CodeFormationMessage codeFormation = (CodeFormationMessage) pqObj;
                    System.out.println("Received: " + codeFormation.toString());
                    gfl.verifierExistanceFormation(codeFormation.getCodeFormation());
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