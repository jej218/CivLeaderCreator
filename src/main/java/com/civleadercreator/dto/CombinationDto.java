package com.civleadercreator.dto;

import com.civleadercreator.entity.Civilization;
import com.civleadercreator.entity.Combination;
import com.civleadercreator.entity.Leader;

public class CombinationDto {
	
	private int id;
	private String outerColorName;
	private String innerColorName;
	private String outerColorHexCode;
	private String innerColorHexCode;
	private Civilization civilization;
	private Leader leader;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private int userId;
	private String civId;
	private String civName;
	private String civDemonym;
	private String civAbilityDescription;
	private String civAbilityName;
	private String civUnitDescription;
	private String civUnitName;
	private String civInfrastructureDescription;
	private String civInfrastructureName;
	private String leaderId;
	private String leaderName;
	private String leaderBonusDescription;
	private String leaderBonusName;
	private String leaderAgendaDescription;
	private String leaderAgendaName;
	private String leaderReligion;
	
	public CombinationDto(Combination combination) {
		this.id = combination.getId();
		this.outerColorName = combination.getOuterColorName();
		this.innerColorName = combination.getInnerColorName();
		this.outerColorHexCode = "#" + combination.getOuterColorHex();
		this.innerColorHexCode = "#" + combination.getInnerColorHex();
		this.civilization = combination.getCivilization();
		this.leader = combination.getLeader();
		this.civName = civilization.getName();
		this.civDemonym = civilization.getDemonym();
		this.civAbilityDescription = civilization.getAbilityDescription();
		this.civAbilityName = civilization.getAbilityName();
		this.civUnitDescription = civilization.getUnitDescription();
		this.civUnitName = civilization.getUnitName();
		this.civInfrastructureDescription = civilization.getInfrastructureDescription();
		this.civInfrastructureName = civilization.getInfrastructureName();
		this.leaderName = leader.getName();
		this.leaderBonusDescription = leader.getBonusDescription();
		this.leaderBonusName = leader.getBonusName();
		this.leaderAgendaDescription = leader.getAgendaDescription();
		this.leaderAgendaName = leader.getAgendaName();
		this.leaderReligion = leader.getReligion();
		this.leaderId = String.valueOf(leader.getId());
		this.civId = String.valueOf(civilization.getId());
		
		if(combination.getUser() != null) {
			this.userFirstName = combination.getUser().getFirstName();
			this.userLastName = combination.getUser().getLastName();
			this.userId = combination.getUser().getId();
			this.userEmail = combination.getUser().getEmail();
		}
	}
	
	public CombinationDto() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOuterColorName() {
		return outerColorName;
	}
	public void setOuterColorName(String outerColorName) {
		this.outerColorName = outerColorName;
	}
	public String getInnerColorName() {
		return innerColorName;
	}
	public void setInnerColorName(String innerColorName) {
		this.innerColorName = innerColorName;
	}
	public String getOuterColorHexCode() {
		return outerColorHexCode;
	}
	public void setOuterColorHexCode(String outerColorHexCode) {
		this.outerColorHexCode = outerColorHexCode;
	}
	public String getInnerColorHexCode() {
		return innerColorHexCode;
	}
	public void setInnerColorHexCode(String innerColorHexCode) {
		this.innerColorHexCode = innerColorHexCode;
	}
	public Civilization getCivilization() {
		return civilization;
	}
	public void setCivilization(Civilization civilization) {
		this.civilization = civilization;
	}
	public Leader getLeader() {
		return leader;
	}
	public void setLeader(Leader leader) {
		this.leader = leader;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCivName() {
		return civName;
	}
	public void setCivName(String civName) {
		this.civName = civName;
	}
	public String getCivDemonym() {
		return civDemonym;
	}
	public void setCivDemonym(String civDemonym) {
		this.civDemonym = civDemonym;
	}
	public String getCivAbilityDescription() {
		return civAbilityDescription;
	}
	public void setCivAbilityDescription(String civAbilityDescription) {
		this.civAbilityDescription = civAbilityDescription;
	}
	public String getCivAbilityName() {
		return civAbilityName;
	}
	public void setCivAbilityName(String civAbilityName) {
		this.civAbilityName = civAbilityName;
	}
	public String getCivUnitDescription() {
		return civUnitDescription;
	}
	public void setCivUnitDescription(String civUnitDescription) {
		this.civUnitDescription = civUnitDescription;
	}
	public String getCivUnitName() {
		return civUnitName;
	}
	public void setCivUnitName(String civUnitName) {
		this.civUnitName = civUnitName;
	}
	public String getCivInfrastructureDescription() {
		return civInfrastructureDescription;
	}
	public void setCivInfrastructureDescription(String civInfrastructureDescription) {
		this.civInfrastructureDescription = civInfrastructureDescription;
	}
	public String getCivInfrastructureName() {
		return civInfrastructureName;
	}
	public void setCivInfrastructureName(String civInfrastructureName) {
		this.civInfrastructureName = civInfrastructureName;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getLeaderBonusDescription() {
		return leaderBonusDescription;
	}
	public void setLeaderBonusDescription(String leaderBonusDescription) {
		this.leaderBonusDescription = leaderBonusDescription;
	}
	public String getLeaderBonusName() {
		return leaderBonusName;
	}
	public void setLeaderBonusName(String leaderBonusName) {
		this.leaderBonusName = leaderBonusName;
	}
	public String getLeaderAgendaDescription() {
		return leaderAgendaDescription;
	}
	public void setLeaderAgendaDescription(String leaderAgendaDescription) {
		this.leaderAgendaDescription = leaderAgendaDescription;
	}
	public String getLeaderAgendaName() {
		return leaderAgendaName;
	}
	public void setLeaderAgendaName(String leaderAgendaName) {
		this.leaderAgendaName = leaderAgendaName;
	}
	public String getLeaderReligion() {
		return leaderReligion;
	}
	public void setLeaderReligion(String leaderReligion) {
		this.leaderReligion = leaderReligion;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCivId() {
		return civId;
	}
	public void setCivId(String civId) {
		this.civId = civId;
	}
	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	@Override
	public String toString() {;
		String combinationString = "Combination ----> Civilization: " + this.civilization.getName() + ", ID=" + this.civilization.getId() + " ----- Leader: " + this.leader.getName() + ", ID=" + this.leader.getId() + " ----- Combination ID: " + this.id + " ----- Outer Color: " + this.outerColorName + " ----- Inner Color: " + this.innerColorName + " ----- User: ";
		if(this.userEmail == null) {
			combinationString += "None (Default Civilization and Leader)";
		} else {
			combinationString += userFirstName + " " + userLastName;
		}
		return combinationString;
	}
}