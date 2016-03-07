package com.shruthi.nirmaan;

import java.util.ArrayList;

/**
 * @author Shruthi
 *
 */
public class Student extends Person {
	
	private String idNum;
	private Member teacher;
	
	
	/**Constructor using Fields
	 * @param name Student's name
	 * @param idNum Student ID number
	 * @param teacher Teacher name
	 * @param contact Student contact number
	 */
	public Student(String name, String idNum, Member teacher,String contact) {
		this.setName(name);
		this.setContactNumber(contact);
		this.idNum = idNum;
		this.teacher = teacher;
	}
	
	
	/**
	 * To register the new Student to the available List 
	 */
	public void register() {
		ArrayList<Student> students;
		students = (ArrayList<Student>)Utility.deserialize("students.ser");
		if(students == null) {
			students = new ArrayList<Student>();
		}
		students.add(this);
		Utility.serialize(students, "students.ser");
	}
	
	
	/**
	 * @return all Students details in the available List
	 */
	public static ArrayList<Student> getAll() {
		ArrayList<Student> students;
		students = (ArrayList<Student>)Utility.deserialize("students.ser");
		return students;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Name" + this.getName() + "   ID: " + this.idNum + "   Teacher" + teacher.getName();
	}
	
	
	/** Searching the particular Student details
	 * @param query Student's name
	 * @return particular Student detail
	 */
	public static ArrayList<Student> search(String query) {
		ArrayList<Student> students;
		ArrayList<Student> result = new ArrayList<Student>();
		students = (ArrayList<Student>)Utility.deserialize("students.ser");
		
		for(Student student: students) {
			if(student.getName().contains(query) || student.teacher.getName().contains(query)) {
				result.add(student);
			}
		}
		
		return result;
	}
}
