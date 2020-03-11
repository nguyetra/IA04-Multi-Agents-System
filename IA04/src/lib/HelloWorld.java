package lib;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.introspection.ACLMessage;

public class HelloWorld extends Agent 
{
	public class HelloWorldBehaviour extends Behaviour 
	{
		 public void action() 
		 {
			 while (true)
			 {
		      		 
				 jade.lang.acl.ACLMessage msg = receive();
				 
				 if (msg != null) 
				 {
					 // Process the message
					 System.out.println( "Contact from : " + msg.getSender() + "Content: " + msg.getContent());
				 }
			 }
		 }
	}
	
	protected void setup() 
	{
		System.out.println("Hello world!");
		
		addBehaviour(new HelloWorldBehaviour());
	}
}

