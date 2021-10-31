package com.unsys.controller;

import java.util.concurrent.CountDownLatch;

import com.Unisys.Model.Colours;
import com.Unisys.Model.FairyLightarray;
import com.Unisys.Model.LightStatues;
import com.Unisys.Model.Lights;
import com.Unisys.Util.AlgorithmConfig;
import com.Unisys.Util.Constants;

public class SequenceController extends  Controller {
	AlgorithmConfig config;

	public void run (FairyLightarray fairylights)
	{
		this.config = new AlgorithmConfig(); 
		int size = fairylights.getLights().size(); // countdown latch size 
		CountDownLatch count = new CountDownLatch(size);
		
		for (Lights light :fairylights.getLights())
		{
			Thread thread = new Thread (this.config.changeLights(light, count,Constants.sequence_time)); // thread created
			thread.run();// execute the current thread 
		}
		
	}
}
