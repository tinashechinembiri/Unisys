package com.unsys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import com.Unisys.Model.Colours;
import com.Unisys.Model.FairyLightarray;
import com.Unisys.Model.Lights;
import com.Unisys.Util.AlgorithmConfig;
import com.Unisys.Util.Constants;

public class ColourSequence extends  Controller{
	
	AlgorithmConfig config; 

	public void run (FairyLightarray lightsize)
	{
		this.config = new AlgorithmConfig(); 
		HashMap<Colours, ArrayList<Lights>> coloursMap  = this.config.Mapcolours(lightsize); 
		for (Colours colours : Colours.values())
		{
			int size = coloursMap.get(colours).size(); // create the size of the countdown latch 
			CountDownLatch count = new CountDownLatch(size);	
			turnonColours(colours, coloursMap, count); 	// call the function every time on a new colour 
		}	
	}
	
	private void turnonColours(Colours colours, HashMap<Colours, ArrayList<Lights>> coloursMap,CountDownLatch count )// used to call the thread function in config 
	{			
		for (Lights lights:coloursMap.get(colours))
		{	
			new Thread(this.config.changeLights(lights, count, Constants.colour_time)).start();		// will run the size of the loop and create a new thread every time 			
		}
		try {
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
	}
}
