package com.civleadercreator.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



// Entity Class for a Leader, representing an individual that can be a
// leader of one or more of the civilizations
@Entity
@Table(name="Leader")
public class Leader {
	
	// Auto-generated Primary Key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	// The Leader's Name. Must not be blank.
	@Column(name="name")
	@NotBlank(message = "Name is Mandatory")
	private String name;
	// The description of the leader's bonus. Must not be blank.
	@Column(name="bonusdescription")
	@NotBlank(message = "Bonus Description is Mandatory")
	private String bonusDescription;
	// The name of the leader's bonus. Must not be blank.
	@Column(name="bonusname")
	@NotBlank(message = "Bonus Name is Mandatory")
	private String bonusName;
	// The description of the leader's agenda. Must not be blank.
	@Column(name="agendadescription")
	@NotBlank(message = "Agenda Description is Mandatory")
	private String agendaDescription;
	// The name of the leader's agenda. Must not be blank.
	@Column(name="agendaname")
	@NotBlank(message = "Agenda Name is Mandatory")
	private String agendaName;
	// The leader's religion.
	@Column(name="religion")
	@NotBlank(message = "Religion is Mandatory")
	private String religion;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="leader", orphanRemoval=true)
	private List<Combination> combinations = new ArrayList<>();
	// No Argument Constructor
	public Leader() {
	}
	
	// Constructor with all but 2 arguments. Missing id which is auto-generated, 
	// and user which is only generated if the Leader was created by a user.
	public Leader(String name, String bonusDescription, String bonusName, String agendaDescription, String agendaName, String religion) {
		this.name = name;
		this.bonusDescription = bonusDescription;
		this.bonusName = bonusName;
		this.agendaDescription = agendaDescription;
		this.agendaName = agendaName;
		this.religion = religion;
	}
	
	// Constructor with all arguments except for the auto-generated id.
	public Leader(String name, String bonusDescription, String bonusName, String agendaDescription, String agendaName, String religion, User user) {
		this.name = name;
		this.bonusDescription = bonusDescription;
		this.bonusName = bonusName;
		this.agendaDescription = agendaDescription;
		this.agendaName = agendaName;
		this.religion = religion;
		this.user = user;
	}
	
	
	
	
	// Getters and Setters
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBonusDescription() {
		return bonusDescription;
	}
	public void setBonusDescription(String bonusDescription) {
		this.bonusDescription = bonusDescription;
	}
	public String getBonusName() {
		return bonusName;
	}
	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}
	public String getAgendaDescription() {
		return agendaDescription;
	}
	public void setAgendaDescription(String agendaDescription) {
		this.agendaDescription = agendaDescription;
	}
	public String getAgendaName() {
		return agendaName;
	}
	public void setAgendaName(String agendaName) {
		this.agendaName = agendaName;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		String leaderString = "Leader ----> Name: " + this.name + " ----- Id: " + this.id + " ----- Bonus: " + this.bonusName + " ----- Agenda: " + this.agendaName + " ----- Religion: " + this.religion + " ----- User: ";
		if(this.user == null) {
			leaderString += "None (Default Leader)";
		} else {
			leaderString += user.getFirstName() + " " + user.getLastName();
		}
		return leaderString;
	}
	
	public boolean equals(Leader leader) {
		if(leader.getName().equals(this.name)) {
			return true;
		} else {
			return false;
		}
		
	}
}
