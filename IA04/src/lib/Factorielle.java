package lib;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Factorielle extends Agent 
{
	protected class RequestHandler extends CyclicBehaviour 
	{
		 public void action() 
		 {
			 //receive only REQUEST message
			 MessageTemplate msgTemplate = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
			 
			 ACLMessage msg = receive(msgTemplate);
				 
			 if (msg != null) 
			 {
				 if (msg.getPerformative() == ACLMessage.REQUEST)
				{
					ACLMessage forwardMessage = new ACLMessage(ACLMessage.REQUEST);
					
					
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
		
		addBehaviour(new RequestHandler());
	}
}