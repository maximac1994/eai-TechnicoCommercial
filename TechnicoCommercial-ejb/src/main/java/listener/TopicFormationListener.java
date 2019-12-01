/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import MessagesTypes.EvenementFormation;
import MessagesTypes.EvenementFormationProjet1;
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
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "TOPIC_FORMATION_TECH")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "TOPIC_FORMATION")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "TOPIC_FORMATION")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class TopicFormationListener implements MessageListener {

    @EJB
    GestionFormationLocal gfl;

    public TopicFormationListener() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                Object pqObj;
                pqObj = ((ObjectMessage) message).getObject();
                if (pqObj instanceof EvenementFormation) {
                    if ("projet1".equals(message.getJMSType())) {
                        EvenementFormationProjet1 evenementFormation = (EvenementFormationProjet1) pqObj;
                        this.gfl.listerFormateursSallesDisponibles(evenementFormation);
                    }
                }
            } else if (message != null) {
                System.out.println("Received non text message");
            }
        } catch (JMSException ex) {
            Logger.getLogger(TopicFormationListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
