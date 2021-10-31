package com.unsys.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.Unisys.Model.FairyLightarray;

public class AlternateController extends  Controller {
	
	public void run (FairyLightarray lightsize) 
	{

		LocalDateTime then = LocalDateTime.now(); 
		System.out.println("colour controller start");
		while (ChronoUnit.SECONDS.between(then, LocalDateTime.now())<= 30) // loops for 30 seconds 
		{
			ColourSequence coloursequence = new ColourSequence(); 
			coloursequence.run(lightsize);	
		}
		System.out.println("Sequence controller start");
		while (ChronoUnit.SECONDS.between(then, LocalDateTime.now())<= 60) // loops 30 after previous loop 
		{
			SequenceController sequencecontroller = new SequenceController(); 
			sequencecontroller.run(lightsize);
		}	
	}	
}
