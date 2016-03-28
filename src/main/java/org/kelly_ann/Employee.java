package org.kelly_ann;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// serializable means the class can be transmitted across the network.
//@Entity allows you to create instances of a domain obj and get them into the DB with minimal effort via JPA.
@SuppressWarnings("serial")
@Entity	//required by JPA (part 1 of 3)
public class Employee implements Serializable {
	
	//@Id says that this field is the unique/primary key of the Entity db object.
	@Id		//required by JPA (part 2 of 3)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String jobRole;
	private int salary;
	
	// constructor
	public Employee () {
		//no-arg constructor is required by JPA (part 3 of 3)
	}
	
	public Employee(String firstName, String lastName, String jobRole, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobRole = jobRole;
		this.salary = salary;
	}
	
	// instance methods
	@Override
	public String toString() {
		return "Employee: " + this.firstName + " " + this.lastName + " makes " 
				+ this.salary + " as a " + this.jobRole + ".";
	}
	
	// getters and setters
	public String getFirstName() {
		
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}

	
	public String getLastName() {
		
		return lastName;
	}

	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}

	
	public String getJobRole() {
		
		return jobRole;
	}

	
	public void setJobRole(String jobRole) {
		
		this.jobRole = jobRole;
	}

	
	public int getSalary() {
		
		return salary;
	}

	
	public void setSalary(int salary) {
		
		this.salary = salary;
	}
	
	
	
	
}
