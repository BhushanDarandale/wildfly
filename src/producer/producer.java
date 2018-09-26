package producer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;


public class producer {

	public void sendMessage() {

		try {

			// final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
			final String url = "tcp://localhost:61616";

			// Create a ConnectionFactory
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

			// Create a Connection
			Connection connection = connectionFactory.createQueueConnection("admin", "admin");
			// without username password
			// Connection connection = connectionFactory.createQueueConnection();

			connection.start();

			// connection.setExceptionListener(this);
			// Create a Session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// Create the destination (Topic or Queue)
			Queue destination = session.createQueue("queue/test-queue");
			MessageProducer producer = session.createProducer(destination);

			// Create a MessageConsumer from the Session to the Topic or Queue
			// MessageConsumer consumer = session.createConsumer(destination);

			TextMessage message = session.createTextMessage();
			message.setText("bhushan");
			producer.send(message);
			session.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		producer p = new producer();
		p.sendMessage();
	}

}
