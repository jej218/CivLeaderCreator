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

//Entity Class for a Civilization, representing one of the playable "classes"
//in the game with a unique ability, unique unit, and a unique infrastructure
@Entity
@Table(name="Civilization")
public class Civilization {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="demonym")
	private String demonym;
	@Column(name="abilitydescription")
	private String abilityDescription;
	@Column(name="abilityname")
	private String abilityName;
	@Column(name="unitdescription")
	private String unitDescription;
	@Column(name="unitname")
	private String unitName;
	@Column(name="infrastructuredescription")
	private String infrastructureDescription;
	@Column(name="infrastructurename")
	private String infrastructureName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="civilization", orphanRemoval=true)
	private List<Combination> combinations = new ArrayList<>();
	
	public Civilization() {
	}
	
	public Civilization(String name, String demonym, String abilityDescription, String abilityName, String unitDescription, String unitName, String infrastructureDescription, String infrastructureName) {
		this.name = name;
		this.demonym = demonym;
		this.abilityDescription = abilityDescription;
		this.abilityName = abilityName;
		this.unitDescription = unitDescription;
		this.unitName = unitName;
		this.infrastructureDescription = infrastructureDescription;
		this.infrastructureName = infrastructureName;
	}

	public int getId() {
		return id;
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
	public String getDemonym() {
		return demonym;
	}
	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}
	public String getAbilityDescription() {
		return abilityDescription;
	}
	public void setAbilityDescription(String abilityDescription) {
		this.abilityDescription = abilityDescription;
	}
	public String getAbilityName() {
		return abilityName;
	}
	public void setAbilityName(String abilityName) {
		this.abilityName = abilityName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getUnitDescription() {
		return unitDescription;
	}
	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}
	public String getInfrastructureDescription() {
		return infrastructureDescription;
	}
	public void setInfrastructureDescription(String infrastructureDescription) {
		this.infrastructureDescription = infrastructureDescription;
	}
	public String getInfrastructureName() {
		return infrastructureName;
	}
	public void setInfrastructureName(String infrastructureName) {
		this.infrastructureName = infrastructureName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		String civilizationString = "Civilization ----> Name: " + this.name + " ----- Id: " + this.id + " ----- Demonym: " + this.demonym + " ----- Ability: " + this.abilityName + " ----- Unit: " + this.unitName + " ----- Infrastructure: " + this.infrastructureName + " ----- User: ";
		if(this.user == null) {
			civilizationString += "None (Default Civilization)";
		} else {
			civilizationString += user.getFirstName() + " " + user.getLastName();
		}
		return civilizationString;
	}
	
	public boolean equals(Civilization civilization) {
		if(civilization.getName().equals(this.name)) {
			return true;
		} else {
			return false;
		}
		
	}
}
