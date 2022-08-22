package com.civleadercreator.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="User")
public class User implements Serializable {
	
	private static final long serialVersionUID = 2240472780238168725L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="email", unique=true)
	@NotEmpty(message="email cannot be empty")
	@Email(message="please provide a valid email")
	private String email;
	@Column(name="firstname")
	@NotEmpty(message="first name cannot be empty")
	private String firstName;
	@Column(name="lastname")
	@NotEmpty(message="last name cannot be empty")
	private String lastName;
	@Column(name="password")
	@NotEmpty(message="password cannot be empty")
	private String password;
	
	public User() {
	}
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "User ----> Name: " + this.firstName + " " + this.lastName + " ----- ID: " + this.id + " ----- Email: " + this.email + " ----- Password: " + this.password;
	}
}
