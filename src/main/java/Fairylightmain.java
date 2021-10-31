

import java.util.Random;

import com.Unisys.Model.Colours;
import com.Unisys.Model.FairyLightarray;
import com.Unisys.Model.LightStatues;
import com.Unisys.Model.Lights;
import com.Unisys.Util.Constants;
import com.Unisys.view.Algorithmsview;


public class Fairylightmain {
	
	
	public static void main(String[] args) throws InterruptedException 
	{
	
		FairyLightarray fairyLights = new FairyLightarray(); // create a fairy array object 
		Algorithmsview userinterface = new Algorithmsview(createFairylightslist(fairyLights)); // creates an object for the view 
		userinterface.userInteface();	// uses user inputs 	
	}
	// create a list of the lights properties  and the expected size of the list which will be provided by a constant file 
	public static FairyLightarray createFairylightslist (FairyLightarray fairyLights)
	{
		Random random = new Random(); // random object 
		int counter = 0; // counter that will used to give each light numerical value 

		while (counter < Constants.lights_Size) 
		{
			if (counter>= Constants.lights_Size)// breacks the loops when max value reached 
			{
				break; 
			}
			else
			{
				 int lightsize  = counter + 1; // adds the light numerical value ever loop 
				 Colours colours = Colours.values()[random.nextInt(Colours.values().length)];// randomise the colours 
				 fairyLights.getLights().add(new Lights(colours, LightStatues.off, lightsize));// adds the lights in a list array 
				 counter++; // counter increment 	
			}
		}

		return fairyLights; 
	}
}
