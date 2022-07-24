package controller;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class JmsLogic {
    @Resource
    private ConnectionFactory connectionFactory;

    @Resource
    private Queue queue;

    public String sendMessage(String message) throws JMSException {
        Connection connection = null;
        Session session = null;
        try{
            connection = (Connection) connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer =  session.createProducer(queue);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            TextMessage textMessage = session.createTextMessage(message);
            producer.send(textMessage);

        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null ) {
                connection.close();
            }
        }
        return "successfully sent";
    }

    public String getMessage() throws JMSException {
        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;
        try {
            connection = (Connection) connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            consumer = session.createConsumer(queue);

            TextMessage jmsMessage  = (TextMessage) consumer.receive(1000);
            if (jmsMessage == null) {
                return "jmsMessage is null";
            }

            TextMessage message = (TextMessage) jmsMessage;
            return message.getText();

        } finally {
            if (consumer != null) {
                consumer.close();
            }
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    List<String> sendList = new ArrayList<String>();

    public String sendMessageSecondTopic(String message) throws JMSException {
        Connection connection = null;
        Session session = null;
        try{
            connection = (Connection) connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer =  session.createProducer(queue);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            TextMessage textMessage = session.createTextMessage(message);
            producer.send(textMessage);

            sendList.add(message);

        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null ) {
                connection.close();
            }
        }
        return "successfully sent";
    }

    List<String> getList = new ArrayList<String>();

    public String getMessageSecondTopic() throws JMSException {
        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;
        try {
            connection = (Connection) connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            consumer = session.createConsumer(queue);

            TextMessage jmsMessage = (TextMessage) consumer.receive(1000);
            if (jmsMessage == null) {
                return "jmsMessage is null";
            }

            TextMessage message = (TextMessage) jmsMessage;
            getList.add(message.getText());
            return String.valueOf(getList);

        } finally {
            if (consumer != null) {
                consumer.close();
            }
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
