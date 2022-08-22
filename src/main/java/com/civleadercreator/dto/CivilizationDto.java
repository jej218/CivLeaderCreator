package com.civleadercreator.dto;

import com.civleadercreator.entity.Civilization;

public class CivilizationDto {

	private int id;
	private String name;
	private String demonym;
	private String abilityDescription;
	private String abilityName;
	private String unitDescription;
	private String unitName;
	private String infrastructureDescription;
	private String infrastructureName;
	private String userFirstName;
	private String userLastName;
	private int userId;
	private String userEmail;
	
	public CivilizationDto() {
	}
	
	public CivilizationDto(Civilization civilization) {
		this.id = civilization.getId();
		this.name = civilization.getName();
		this.demonym = civilization.getDemonym();
		this.abilityDescription = civilization.getAbilityDescription();
		this.abilityName = civilization.getAbilityName();
		this.unitDescription = civilization.getUnitDescription();
		this.unitName = civilization.getUnitName();
		this.infrastructureDescription = civilization.getInfrastructureDescription();
		this.infrastructureName = civilization.getInfrastructureName();
		if(civilization.getUser() != null) {
			this.userFirstName = civilization.getUser().getFirstName();
			this.userLastName = civilization.getUser().getLastName();
			this.userId = civilization.getUser().getId();
			this.userEmail = civilization.getUser().getEmail();
		}
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
	public String getUnitDescription() {
		return unitDescription;
	}
	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
