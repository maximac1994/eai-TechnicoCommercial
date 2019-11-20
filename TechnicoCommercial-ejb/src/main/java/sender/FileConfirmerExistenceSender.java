/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sender;

import MessagesTypes.CodeFormationMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 33785
 */
public class FileConfirmerExistenceSender {
    
    Context context = null;
    ConnectionFactory factory = null;
    Connection connection = null;
    String factoryName = "jms/__defaultConnectionFactory";
    String destName = "FILE_CONFIRM_EXISTENCE";
    Destination dest = null;
    Session session = null;
    MessageProducer sender = null;
    
    public void connect() {
        try {
            // create the JNDI initial context.
            context = new InitialContext();
            // look up the ConnectionFactory
            factory = (ConnectionFactory) context.lookup(factoryName);
            // look up the Destination
            dest = (Destination) context.lookup(destName);
            // create the connection
            connection = factory.createConnection();
            // create the session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // create the sender
            sender = session.createProducer(dest);
            // start the connection, to enable message sends
            connection.start();
        } catch (JMSException exception) {
            exception.printStackTrace();
        } catch (NamingException exception) {
            exception.printStackTrace();
        } finally {
           
        }
    }
        
    public void publish(boolean formationExist) throws JMSException, InterruptedException {
        System.out.println("coucou toi, bolean : " + formationExist);
        if (context == null) {
            this.connect();
        }
        System.out.println("c'est bon");
        ObjectMessage message = session.createObjectMessage(formationExist);
        //message.setJMSType();
        sender.send(message);
    }
    
    public void close() {
        // close the context
        if (context != null) {
            try {
                context.close();
            } catch (NamingException exception) {
                exception.printStackTrace();
            }
        }

        // close the connection
        if (connection != null) {
            try {
                connection.close();
            } catch (JMSException exception) {
                exception.printStackTrace();
            }
        }
    }
   
}
