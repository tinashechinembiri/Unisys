package com.Unisys.Model;

public class Lights {
	
	private Colours colours ; 
	private LightStatues on;
	private int number; 
	
	public Lights(Colours colour,LightStatues on, int number )
	{
		this.colours = colour; 
		this.on = on; 
		this.number = number; 
	}

	public Colours getColours() {
		return colours;
	}

	public void setColours(Colours colours) {
		this.colours = colours;
	}

	public LightStatues getOn() {
		return on;
	}

	public void setOn(LightStatues on) {
		this.on = on;
		System.out.println(this+"lights"); 
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Lights [colours=" + colours + ", on=" + this.getOn() + ", number=" + number + "]";
	}
	
	
	
	
	

}
