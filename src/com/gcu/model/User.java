/*
 * Adam Bender
 * CST 323 Activity 2
 * 1/17/2021
 * Visitor Model
 */

package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	@NotNull(message = "Can't be empty")
	@Size(min = 2, max = 30, message = "Must be between 2 and 30 characters")
	private String firstName;

	@NotNull(message = "Can't be empty")
	@Size(min = 2, max = 30, message = "Must be between 2 and 30 characters")
	private String lastName;
	
	private String date;

	public User(String firstName, String lastName, String date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
	}

	public User() {
		firstName = "";
		lastName = "";
		date = "";
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
