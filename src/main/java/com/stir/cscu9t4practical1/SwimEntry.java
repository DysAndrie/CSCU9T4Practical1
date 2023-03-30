
package com.stir.cscu9t4practical1;

import java.util.Calendar;

/**
 * Dysfred Orbiso 
 * BsCS Year II 
 * M.I Checkpoint#3 
 */

public class SwimEntry extends Entry
{
	protected String where; //Declares a new protected instance variable called where of type String, which will store the location where the swim took place.
	
	public SwimEntry()
	{
		//This is a default constructor for the SwimEntry class, it doesn't do anything 
	}
	
	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String wh)
	{
	      name = n;
	      Calendar inst = Calendar.getInstance();
	      inst.set(y,m-1,d,h,min,s);
	      dateAndTime = inst;
	      distance = dist;
	      where = wh;
	}

	public String getWhere()
	{
		return where;
	}
	
	public String getSwimEntry() //This is a specific method for the SwimEntry class
                //that returns a formatted string representing the relevant informtion of the swim entry.
	{
	return getName() + " swam " + getDistance() + "km " + getWhere() 
             + " in " + getHour() +":" + getMin() + ":" + getSec() +
	" on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
	}
}
