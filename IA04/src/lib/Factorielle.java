package lib;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.introspection.ACLMessage;

public class Factorielle extends Agent 
{
	public class Receiver extends CyclicBehaviour 
	{
		 public void action() 
		 {
			jade.lang.acl.ACLMessage msg = receive();
				 
			if (msg != null) 
			{
				
				if (msg.getPerformative() == jade.lang.acl.ACLMessage.REQUEST)
				{
					//forward request to multiplicateur
					msg.setSender(new AID("Factorielle", AID.ISLOCALNAME));
					
					msg.clearAllReceiver();
					msg.addReceiver(new AID("Multiplicateur", AID.ISLOCALNAME));
					
					send(msg);
				}
				else if (msg.getPerformative() == jade.lang.acl.ACLMessage.INFORM)
				{
					//show result 
					System.out.println( "Result: " + msg.getContent());
				}
				else
				{
					System.out.println( "Drop massage : " + msg.getContent());
				}
			}
		}
	}
	
	protected void setup() 
	{
		System.out.println("Agent factorielle init!");
		
		addBehaviour(new Receiver());
	}
}