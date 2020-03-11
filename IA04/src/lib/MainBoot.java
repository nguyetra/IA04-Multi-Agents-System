package lib;

//Imports Jade 
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.core.Profile;

public class MainBoot {

	public static void main(String[] args) 
	{
		Runtime rt = Runtime.instance();
		Profile p = null;
		try
		{
			p = new ProfileImpl(MAIN_PROPERTIES_FILE);
			AgentContainer mc = rt.createMainContainer(p);

			// ContainerController cc = rt.createAgentContainer(p);

			AgentController agent = mc.createNewAgent("HelloWorld", "lib.HelloWorld", null);

			agent.start();
		}
		catch(Exception ex) 
		{
			System.out.println("Error" + ex);
		}
	}



	public static String MAIN_PROPERTIES_FILE = "main_prop.txt";


}
