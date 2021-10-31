package com.Unisys.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import com.Unisys.Model.Colours;
import com.Unisys.Model.FairyLightarray;
import com.Unisys.Model.LightStatues;
import com.Unisys.Model.Lights;

public class AlgorithmConfig {
	// create a table of the list of colours and properties with their respectively keys.
	public HashMap<Colours, ArrayList<Lights>> Mapcolours (FairyLightarray lights)
	{
		HashMap<Colours, ArrayList<Lights>>  filteredlights = new HashMap<Colours, ArrayList<Lights>>(); 
		
		lights.getLights().stream()
		.forEach(value -> {
			
			if(filteredlights.containsKey(value.getColours()))// checks if the key values exist and updates the filteredlights 
			{
				filteredlights.get(value.getColours()).add(value); // adds the colour properties on their respectively keys
			}
			else 
			{
				filteredlights.put(value.getColours(), new ArrayList<Lights>());  // if there no current key for colour it gets created in a new hashmap 
			}
		});
		
		return filteredlights;	
	}
	
	public Runnable changeLights (Lights lights , CountDownLatch count, int thread_sleep) // runner function 
	{
		return new Runnable() // create a new runnable every time funtion get called 
		{
			public void run() {
				
				lights.setOn(LightStatues.on);	// turns the light one 
				try {								
					Thread.sleep(thread_sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lights.setOn(LightStatues.off); // turns light off 
				count.countDown();									
			}
	
		}; 
	}

}
