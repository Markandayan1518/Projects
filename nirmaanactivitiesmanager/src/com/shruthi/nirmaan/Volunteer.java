package com.shruthi.nirmaan;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Shruthi
 *
 */
public class Volunteer extends Person implements Serializable{
	
	
	/**Constructor using fields 
	 * @param name Volunteer name
	 * @param number Volunteer number 
	 */
	public Volunteer(String name,String number) {
		this.setName(name);
		this.setContactNumber(number);
	}
	
	
	/**
	 * Adding new Volunteer to List
	 */
	public void addVolunteer() {
		ArrayList<Volunteer> volunteers;
		volunteers = (ArrayList<Volunteer>)Utility.deserialize("volunteers.ser");
		if(volunteers == null) {
			volunteers = new ArrayList<Volunteer>();
		}
		volunteers.add(this);
		Utility.serialize(volunteers, "volunteers.ser");
	}
	
	
	/**
	 * Removing particular Volunteer from the available list
	 */
	public void removeVolunteer() {
		ArrayList<Volunteer> volunteers;
		volunteers = (ArrayList<Volunteer>)Utility.deserialize("volunteers.ser");
		if(volunteers == null) {
			volunteers = new ArrayList<Volunteer>();
		}
		volunteers.remove(this);
		Utility.serialize(volunteers, "volunteers.ser");
	}
	
	/**
	 * Searching the particular Volunteer from the available list
	 */
	public ArrayList<Volunteer> search(String query) {
		ArrayList<Volunteer> volunteers;
		ArrayList<Volunteer> result = new ArrayList<Volunteer>();
		volunteers = (ArrayList<Volunteer>)Utility.deserialize("volunteers.ser");
		for(Volunteer volunteer: volunteers) {
		
			if(volunteer.getName().contains(query) ) {
				
				result.add(volunteer);
				
			}
			
		}
		return result;
	}
}
