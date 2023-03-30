
package com.stir.cscu9t4practical1;

import java.util.Calendar;

/**
 * Dysfred Orbiso 
 * BsCS Year II 
 * M.I Checkpoint#3 
 */
 public class CycleEntry extends Entry
{
     	//Declaring new protected instance variables called where of type String, 
       //which will store the terain and tempo of the cycling. 
	protected String terrain;
	protected String tempo;
	
	public CycleEntry()
	{
		//This is a default constructor for the CycleEntry class, it doesn't do anything 
	}
	
	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String tem)
	{
	      name = n;
	      Calendar inst = Calendar.getInstance();
	      inst.set(y,m-1,d,h,min,s);
	      dateAndTime = inst;
	      distance = dist; //km
	      terrain = ter;
	      tempo = tem;
	}
	
        //Getter Methods 
	public String getTerrain()
	{
		return terrain;
	}
	
	public String getTempo()
	{
		return tempo;
	}
	
	public String getCycleEntry()//This is a specific method for the CycleEntry class
                //that returns a formatted string representing the relevant information of cycle entry.
	{
		return getName() + " cycled " + getDistance() + "km in " + getHour() +":" + getMin() + ":" + getSec() +
				" on " + getDay() + "/" + getMonth() + "/" + getYear() + " on " + getTerrain() + " at " +
				getTempo() + " tempo\n";
	}
}
