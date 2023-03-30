// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

//Dysfred Orbiso 
//BsCS Year II 
//M.I Checkpoint#3 

import java.util.*;


public class TrainingRecord {
    
    //Creation of a Global Hashmap to keep track of all the entries 
    private List<Entry> EntryRecord;
    private List<CycleEntry> CycleRecord;
    private List<SprintEntry> SprintRecord;
    private List<SwimEntry> SwimRecord;
    
    public TrainingRecord()
    {
        EntryRecord = new ArrayList<Entry>();
        CycleRecord = new ArrayList<CycleEntry>();
        SprintRecord = new ArrayList<SprintEntry>();
        SwimRecord = new ArrayList<SwimEntry>();
    } //constructor
    
    public void addCycleEntry(CycleEntry e)
   {
	   EntryRecord.add(e);
       CycleRecord.add(e);    
   } // addClass
   
   public void addSprintEntry(SprintEntry e)
   {
	   EntryRecord.add(e);
       SprintRecord.add(e);    
   } // addClass
   
   
   public void addSwimEntry(SwimEntry e)
   {
	   EntryRecord.add(e);
       SwimRecord.add(e);
   } // addClass
   
   
   public String removeCycleEntry(String n, int d, int m, int y)
   {
	   String result = "Entry does not match any existing record";
	   ListIterator<CycleEntry> cycleIter = CycleRecord.listIterator();
	   
	   while(cycleIter.hasNext())
	   {
		   CycleEntry current = cycleIter.next();
		   if(current.getName().toLowerCase().equals(n.toLowerCase()) && current.getDay() == d
				   && current.getMonth() == m && current.getYear() == y)
		   {
			   EntryRecord.remove(current);
			   CycleRecord.remove(current);
			   return "Record on Cycle Entry has been removed.";
		   }
	   }
	   
	   return result;
   }
   
   public String removeSprintEntry(String n, int d, int m, int y)
   {
	   String result = "Entry does not match any existing record";
	   ListIterator<SprintEntry> sprintIter = SprintRecord.listIterator();
	   
	   while(sprintIter.hasNext())
	   {
		   SprintEntry current = sprintIter.next();
		   if(current.getName().toLowerCase().equals(n.toLowerCase()) && current.getDay() == d
				   && current.getMonth() == m && current.getYear() == y)
		   {
			   EntryRecord.remove(current);
			   SprintRecord.remove(current);
			   return "Record on Sprint Entry has been removed.";
		   }
	   }
	   
	   return result;
   }
   
  
   public String removeSwimEntry(String n, int d, int m, int y)
   {
	   String result = "Entry does not match any existing record";
	   ListIterator<SwimEntry> swimIter = SwimRecord.listIterator();
	   
	   while(swimIter.hasNext())
	   {
		   SwimEntry current = swimIter.next();
		   if(current.getName().toLowerCase().equals(n.toLowerCase()) && current.getDay() == d
				   && current.getMonth() == m && current.getYear() == y)
		   {
			   EntryRecord.remove(current);
			   SwimRecord.remove(current);
			   return "Record on Swim Entry has been removed.";
		   }
	   }
	   
	   return result;
   }
   
   //returns a list of all entries of the selected sport on a given date
   public String lookupAllEntriesForSelectedActivity(int d, int m, int y, String SelectedActivity)
   {   
       String result = "No entries found";
       int counter = 0;
     
      if(SelectedActivity.equals("Cycle"))
       {
    	   ListIterator<CycleEntry> cycleIter = CycleRecord.listIterator();
    	   
           while (cycleIter.hasNext())
           {
              CycleEntry current = cycleIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) //if this is the first entry that matches the given date
            	  {
            		  result = current.getCycleEntry(); //assign getEntry to result
            	  }
            	  else //if there is already at least one entry assigned to result
            	  {
            		  result = result.concat(current.getCycleEntry()); //add the current entry to the end of result
            	  }
              }
           }
       }
             else if(SelectedActivity.equals("Sprint"))
       {
    	   ListIterator<SprintEntry> sprintIter = SprintRecord.listIterator();
    	   
           while (sprintIter.hasNext())
           {
              SprintEntry current = sprintIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) //if this is the first entry that matches the given date
            	  {
            		  result = current.getSprintEntry(); //assign getEntry to result
            	  }
            	  else //if there is already at least one entry assigned to result
            	  {
            		  result = result.concat(current.getSprintEntry()); //add the current entry to the end of result
            	  }
              }
           }
       }
       
       else if(SelectedActivity.equals("Swim"))
       {
    	   ListIterator<SwimEntry> swimIter = SwimRecord.listIterator();
    	   
           while (swimIter.hasNext())
           {
              SwimEntry current = swimIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) //if this is the first entry that matches the given date
            	  {
            		  result = current.getSwimEntry(); //assign getEntry to result
            	  }
            	  else //if there is already at least one entry assigned to result
            	  {
            		  result = result.concat(current.getSwimEntry()); //add the current entry to the end of result
            	  }
              }
           }
       }

       return result;
   }
    //checks if there are any other cycle entries with the exact same details
   public boolean DuplicateEntry(String n, int d, int m, int y, int h, int mm, int s, float dist, String ter, String tem)
   {
       ListIterator<CycleEntry> iter = CycleRecord.listIterator();
       
       while(iter.hasNext())
       {
    	   CycleEntry current = iter.next();
    	   if(current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y
    			   && current.getHour() == h && current.getMin() == mm && current.getSec() == s
    			   && current.getDistance() == dist && current.getTerrain().equals(ter) && current.getTempo().equals(tem))
    		   return false;
       }
	   return true;
   }
  
   //checks if there are any other sprint entries with the exact same details
   public boolean DuplicateEntry(String n, int d, int m, int y, int h, int mm, int s, float dist, int recov, int reps)
   {
       ListIterator<SprintEntry> iter = SprintRecord.listIterator();
       
       while(iter.hasNext())
       {
    	   SprintEntry current = iter.next();
    	   if(current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y
    			   && current.getHour() == h && current.getMin() == mm && current.getSec() == s
    			   && current.getDistance() == dist && current.getRecovery() == recov && current.getRepetitions() == reps)
    		   return false;
       }
	   return true;
   }
   
 //checks if there are any other swim entries with the exact same details
   public boolean DuplicateEntry(String n, int d, int m, int y, int h, int mm, int s, float dist, String wh)
   {
       ListIterator<SwimEntry> iter = SwimRecord.listIterator();
       
       while(iter.hasNext())
       {
    	   SwimEntry current = iter.next();
    	   if(current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y
    			   && current.getHour() == h && current.getMin() == mm && current.getSec() == s
    			   && current.getDistance() == dist && current.getWhere().equals(wh))
    		   return false;
       }
	   return true;
   }
   
   // Count the number of entries
   public int getNumberOfEntries()
   {
       return EntryRecord.size();
   }
   // Clear all entries
   public void clearAllEntries()
   {
       EntryRecord.clear();
   }
   
} // TrainingRecord