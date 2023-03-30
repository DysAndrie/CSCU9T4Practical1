
package com.stir.cscu9t4practical1;

import java.util.Calendar;


/**
 * Dysfred Orbiso 
 * BsCS Year II 
 * M.I Checkpoint#3 
 */

public class SprintEntry extends Entry
{
	//Declaring new protected instance variables called where of type String, 
       //which will store the recoverytime and repetitions of the sprint.
        protected int recoveryTime;
	protected int repetitions;
	
	public SprintEntry()
	{
            //This is a default constructor for the SprintEntry class, it doesn't do anything 
	}
	
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int recov, int reps)
	{
	      name = n;
	      Calendar inst = Calendar.getInstance();
	      inst.set(y,m-1,d,h,min,s);
	      dateAndTime = inst;
	      distance = dist; //metres
	      recoveryTime = recov;
	      repetitions = reps;
	}
	
        //Getter methods 
	public int getRecovery()
	{
		return recoveryTime;
	}
	
	public int getRepetitions()
	{
		return repetitions;
	}
	
	public String getSprintEntry()  //This is a specific method for the SprintEntry class
                //that returns a formatted string representing the relevant information on the sprint entry.
	{
		return getName() + " sprinted " + getRepetitions() + "x" + (int) getDistance() + "m in " + getHour() +":" + getMin() + ":" + getSec() +
				" with " + getRecovery() + " minute(s) recovery " + "on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
	}
}

