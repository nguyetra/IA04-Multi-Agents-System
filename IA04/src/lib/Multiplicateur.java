package lib;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.introspection.ACLMessage;
import lib.Factorielle.Receiver;

public class Multiplicateur extends Agent  
{
	public class Receiver extends CyclicBehaviour 
	{
		 public void action() 
		 {
			jade.lang.acl.ACLMessage msg = receive();
				 
			if (msg != null) 
			{
				System.out.println( "Multiplicateur receive: " + msg.getContent());
				
				int command = Integer.parseInt(msg.getContent());
				
				//construct message type INFORM
				jade.lang.acl.ACLMessage result = new jade.lang.acl.ACLMessage(jade.lang.acl.ACLMessage.INFORM);
				
				result.addReceiver(msg.getSender());
				
				int f = factorielle(command);
				
				System.out.println(f);
				
				result.setContent(String.valueOf(f));
					 
				//Return result to Factorielle
				send(result);
			}
		 }
	}
	
	protected void setup() 
	{
		System.out.println("Agent Multiplicateur init!");
		
		addBehaviour(new Receiver());
	}
	
	private int factorielle(int x)
	{
		if (x == 1 || x == 0)
		{
			return 1;
		}
		
		return x * factorielle(x - 1);
	}
}