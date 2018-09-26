package mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.jboss.annotation.ejb.ResourceAdapter;

@MessageDriven(activationConfig = {
@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test-queue"),
@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
@ActivationConfigProperty(propertyName = "userName", propertyValue = "admin"),
		@ActivationConfigProperty(propertyName = "password", propertyValue = "admin") })
@ResourceAdapter("activemq-ra.rar")
public class TestBean implements MessageListener {

	public void onMessage(Message msg) {
		// do something
		System.out.println("Message is received here:::=========>" + msg);
		//FmcMessageParser parser = new FmcMessageParser(); // can change 
		//parser.process(msg);
	}

}

