package com.Unisys.view;

import java.util.HashMap;
import java.util.Scanner;

import com.Unisys.Model.FairyLightarray;
import com.Unisys.Util.InterfaceConstants;
import com.unsys.controller.AlternateController;
import com.unsys.controller.ColourSequence;
import com.unsys.controller.Controller;
import com.unsys.controller.SequenceController;

public class Algorithmsview {
	private static HashMap<Integer, Controller> controller = new HashMap<Integer, Controller>(); 
	private FairyLightarray fairyLights; 
	public Algorithmsview(FairyLightarray fairyLights)
	{
		this.fairyLights = fairyLights; 
		controller.put(InterfaceConstants.sequence, new SequenceController());  // puts them in selection table 
		controller.put(InterfaceConstants.colour, new ColourSequence()); 
		controller.put(InterfaceConstants.alternate, new AlternateController()); 
		
	}
	public void userInteface()
	{
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select the algorithm you want to run:"); 
		System.out.println("Select 1 to run sequence algorithm"); 
		System.out.println("Select 2 to run colour algorithm"); 
		System.out.println("Select 3 to run Alternate algorithm"); 
		System.out.println("Type any numeric value beside the above to exit");
		
		int userInput = scanner.nextInt(); // get the user input 
	
			
			if (controller.keySet().contains(userInput))// check if algorithm value exist 
			{
				controller.get(userInput).run(this.fairyLights);
				this.userInteface(); // recalls the interface 
			}
			else 
			{
				System.out.println("user exited"); 
				System.exit(0);// exit the algorithm 
				scanner.close();
			}
		
		
		
		
		
		
	}
}
