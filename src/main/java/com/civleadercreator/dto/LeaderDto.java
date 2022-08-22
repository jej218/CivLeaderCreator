package com.civleadercreator.dto;

import com.civleadercreator.entity.Leader;

public class LeaderDto {
	
	private int id;
	private String name;
	private String bonusDescription;
	private String bonusName;
	private String agendaDescription;
	private String agendaName;
	private String religion;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private int userId;
	
	public LeaderDto(Leader leader) {
		this.id = leader.getId();
		this.name = leader.getName();
		this.bonusDescription = leader.getBonusDescription();
		this.bonusName = leader.getBonusName();
		this.agendaDescription = leader.getAgendaDescription();
		this.agendaName = leader.getAgendaName();
		this.religion = leader.getReligion();
		if(leader.getUser() != null) {
			this.userFirstName = leader.getUser().getFirstName();
			this.userLastName = leader.getUser().getLastName();
			this.userEmail = leader.getUser().getEmail();
			this.userId = leader.getUser().getId();
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