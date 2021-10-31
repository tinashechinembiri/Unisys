package com.unisys.util;

import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.Unisys.Model.Colours;
import com.Unisys.Model.FairyLightarray;
import com.Unisys.Model.LightStatues;
import com.Unisys.Model.Lights;
import com.Unisys.Util.AlgorithmConfig;

public class AlgorithmConfigTest {

	FairyLightarray fairyLights; 
	AlgorithmConfig config; 
	@Before 
	public void setUp()
	{
		fairyLights = new FairyLightarray(); 
		config = new AlgorithmConfig(); 
		int counter = 0; 
		for (Colours value : Colours.values())
		{
			this.fairyLights.getLights().add(new Lights(value, LightStatues.off,counter)); 
			counter++; 
		}
	}
	
	@Test
	public void mapcolours_test()
	{
		HashMap<Colours, ArrayList<Lights>>  filteredlights = config.Mapcolours(fairyLights); 
		
		for (Colours value : Colours.values())
		{
			assertTrue(filteredlights.containsKey(value)); 			 
		}	
	}
}
