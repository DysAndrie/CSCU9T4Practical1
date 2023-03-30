// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

//Dysfred Orbiso 
//BsCS Year II 
//M.I Checkpoint#3 

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    
    private JTextField terrain = new JTextField(6);
    private JTextField tempo = new JTextField(6);
    private JTextField repetitions = new JTextField(3);
    private JTextField recovery = new JTextField(2);
    private JTextField where = new JTextField(5);
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    
    private JLabel labterrain = new JLabel(" Terrain:");
    private JLabel labtempo = new JLabel(" Tempo:");
    private JLabel labrepetitons = new JLabel(" Rounds:");
    private JLabel labrecoveryTime = new JLabel(" Recovery Time:");
    private JLabel labwhere = new JLabel(" Swimming Location:");
    
    private JButton addR = new JButton("Add Entry");
    private JButton removeEntry = new JButton("Remove Entry");
    private JButton lookUpByDate = new JButton("Look Up Entry");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JButton findAllByName = new JButton("Find All By Name");
    private JButton weeklyDistance = new JButton("Weekly Distance");
    
    //Code in partial thanks to: https://www.geeksforgeeks.org/java-swing-jcombobox-examples/
    //For inspiration and clarification on ComboBox function 
    private String[] activity = {"Select Activity: ", "Cycle", "Sprint", "Swim"};
    private JComboBox menu = new JComboBox<String>(activity);
    
    private String[] tempoState = {"Select Tempo: ", "slow", "moderate", "fast"}; //this is passed into the tempo combo box
    private JComboBox tempostate = new JComboBox<String>(tempoState);
     
    private String[] whereSwimLocation = {"Select Swim Location: ", "outdoor", "indoor pool"}; //this is passed into the where swim combo box
    private JComboBox whereToSwim = new JComboBox<String>(whereSwimLocation);
    
    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);
    
    private boolean checkForDuplicates = false;

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
     super("Training Record");
     setLayout(new FlowLayout());
        add(menu);
        menu.addActionListener(this);
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labterrain);
        add(terrain);
        terrain.setEditable(true);
        labterrain.setVisible(true);
        terrain.setVisible(true);
        add(labtempo);
        add(tempo);
        tempo.setEditable(true);
        labtempo.setVisible(false);
        tempo.setVisible(false);
        add(labrepetitons);
        add(repetitions);
        repetitions.setEditable(true);
        labrepetitons.setVisible(true);
        repetitions.setVisible(false);
        add(labrecoveryTime);
        add(recovery);
        recovery.setEditable(true);
        labrecoveryTime.setVisible(true);
        repetitions.setVisible(true);
        add(labwhere);
        add(where);
        labwhere.setVisible(false);
        where.setVisible(false);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(removeEntry);
        removeEntry.addActionListener(this);
        removeEntry.setEnabled(false);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        findAllByDate.setEnabled(false);
        add(findAllByName);
        findAllByName.addActionListener(this);
        findAllByName.setEnabled(false);
        add(weeklyDistance);
        weeklyDistance.addActionListener(this);
        weeklyDistance.setEnabled(false);
        add(outputArea);
        outputArea.setEditable(false);
        add(labtempo);
        add(tempostate);
        tempostate.enable(false);
        add(labwhere);
        add(whereToSwim);
        whereToSwim.enable(false);
        setSize(1100, 200); //Edited the size of the GUI window to accomodate new button additions 
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        
        if (event.getSource() == addR) {
            message = addEntry();
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if(event.getSource() == removeEntry) {
            message = removeEntry();
        }
        if (event.getSource() == findAllByName)
        {
            
        }
        if(event.getSource() == findAllByDate)
        {
        	
        }
        
      String selectedActivity = (String)menu.getSelectedItem(); //Selects the activity from the menu combo box
    
    if (selectedActivity.equals("Cycle")) //if cycle is selected   
    {       
        recovery.setEditable(false);
        repetitions.setEditable(false);
        terrain.setEditable(true);
        tempostate.setEnabled(true);
        whereToSwim.setEnabled(false);
        } 
    else if(selectedActivity.equals("Sprint")) //if sprint is selected
    {
        recovery.setEditable(true);
        repetitions.setEditable(true);
        terrain.setEditable(true);
        tempostate.setEnabled(true);
        whereToSwim.setEnabled(false);
    }
    else if(selectedActivity.equals("Swim")) //if swim is selected
    {
        recovery.setEditable(false);
        repetitions.setEditable(false);
        terrain.setEditable(false);
        tempostate.setEnabled(true);
        whereToSwim.setEnabled(true);
    }
     //Shows the correct field of certain activity chosen
        if (event.getSource() == menu) {
            //checks that an activity type is selected
            if (!selectActivity()) {
                message = "Please Select an Activity";
            }
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed
 
     //Prompts the user to select an activity first 
    private Boolean selectActivity() {
        if (menu.getSelectedItem().equals("Select Activity: ")) {
            return false;
        }
        return true;
    }

  
 public String addEntry()
    {
        String selectedActivity = (String)menu.getSelectedItem(); //To initiate the chosen activity in the combobox 
        String message = "Entry added to Record\n";
        System.out.println("Adding " + selectedActivity + " entry to the records");
        
    	if(name.getText().trim().equals("")) //if there is no name input
    	{
    		return "Please enter a valid name";
    	}
    	
        String n = name.getText().trim();
        
        try
        {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            
            //Checks for the selected acitivty chosen in the menu combobox 
            if(selectedActivity.equals("Cycle"))
            {
            	String ter = terrain.getText();
            	String tem = tempostate.getSelectedItem().toString();
            	
            	if(myAthletes.DuplicateEntry(n, d, m, y, h, mm, s, km, ter, tem)) //if there are no other run entries with the exact same details
            	{
                    CycleEntry eCycle = new CycleEntry(n, d, m, y, h, mm, s, km, ter, tem);
                    myAthletes.addCycleEntry(eCycle); 
                    blankDisplay();
                    removeEntry.setEnabled(true);
                    findAllByName.setEnabled(true);
                    findAllByDate.setEnabled(true);
                    return message;
            	}
            	else
            		return "WARNING: The same Entry details have already been inputted";
            }
            else if(selectedActivity.equals("Sprint"))
            {
            	int recov = Integer.parseInt(recovery.getText());
            	int reps = Integer.parseInt(repetitions.getText());
            	
            	if(myAthletes.DuplicateEntry(n, d, m, y, h, mm, s, km, recov, reps)) //if there are no other run entries with the exact same details
            	{
                    SprintEntry eSprint = new SprintEntry(n, d, m, y, h, mm, s, km, recov, reps);
                    myAthletes.addSprintEntry(eSprint); 
                    blankDisplay();
                    removeEntry.setEnabled(true);
                    findAllByName.setEnabled(true);
                    findAllByDate.setEnabled(true);
                    return message;
            	}
            	else
            		return "WARNING: The same Entry details have already been inputted";
            }
            else 
            {
            	String wh = whereToSwim.getSelectedItem().toString();
            	
            	if(myAthletes.DuplicateEntry(n, d, m, y, h, mm, s, km, wh)) //if there are no other run entries with the exact same details
            	{
                    SwimEntry eSwim = new SwimEntry(n, d, m, y, h, mm, s, km, wh);
                    myAthletes.addSwimEntry(eSwim); //add the new entry
                    blankDisplay();
                    removeEntry.setEnabled(true);
                    findAllByName.setEnabled(true);
                    findAllByDate.setEnabled(true);
                    return message;
            	}
            	else
            		return "WARNING: The same Entry details have already been inputted";
            }
        }
        catch(Exception e) //catches if invalid details are entered or not all text boxes have data in them
        {
        	return "Please input valid date detail format";
        }
    }

           
    public String lookupEntry() {
      {
    	try
    	{
            String selectedActivity = (String)menu.getSelectedItem();
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up Entry record");
            String message = myAthletes.lookupAllEntriesForSelectedActivity(d, m, y, selectedActivity); //passes in the date as well as the selected sport
            return message;
    	}
    	catch(Exception e) //catches if invalid details are entered or not all text boxes have data in them
    	{
    		return "Please input valid date detail format";
    	}
   
    }  
 }
    
    public String removeEntry() //Removes an entry method 
    {
        String selectedActivity = (String)menu.getSelectedItem();
        String message = "Entry removed from Record\n";
        System.out.println("Removing Entry from the Records");
        
    	if(name.getText().trim().equals("")) //if there is no name inputted in the console 
    	{
    		return "Please enter a valid name";
    	}
    	
    	String n = name.getText().trim();
    	
    	try
    	{
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            
          
            if(selectedActivity.equals("Cycle"))
            {
            	return myAthletes.removeCycleEntry(n, d, m, y);
            }
            else if (selectedActivity.equals("Sprint"))
            {
            	return myAthletes.removeSprintEntry(n, d, m, y);
            }
            else
            {
            	return myAthletes.removeSwimEntry(n, d, m, y);
            }
        }
        catch(Exception e) //catches if invalid details are entered or not all text boxes have data in them
    	{
        	return "Please input valid date detail format"; 
    	}
    }
        

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

