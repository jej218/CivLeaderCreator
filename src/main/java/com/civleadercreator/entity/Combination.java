package com.civleadercreator.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Combination")
public class Combination {
	
	public static final Map<String, String> COLORS = createMap();
	
	private static Map<String, String> createMap() {
	    Map<String,String> myMap = new HashMap<String,String>();
	    myMap.put("Pink", "e57574");
	    myMap.put("Red", "ca1415");
	    myMap.put("Dark Red", "780001");
	    myMap.put("Light Orange", "ffb23c");
	    myMap.put("Orange", "ff8112");
	    myMap.put("Brown", "783d02");
	    myMap.put("Light Yellow", "eae19d");
	    myMap.put("Yellow", "f7d801");
	    myMap.put("Olive", "867202");
	    myMap.put("Light Green", "79e077");
	    myMap.put("Green", "61bf22");
	    myMap.put("Dark Green", "156c30");
	    myMap.put("Cyan", "7dece3");
	    myMap.put("Turquoise", "00c09b");
	    myMap.put("Teal", "014f51");
	    myMap.put("Light Blue", "74a3f3");
	    myMap.put("Blue", "004fce");
	    myMap.put("Dark Blue", "012a6c");
	    myMap.put("Light Purple", "b780e6");
	    myMap.put("Purple", "6d00cd");
	    myMap.put("Dark Purple", "370065");
	    myMap.put("Light Magenta", "ff99ff");
	    myMap.put("Magenta", "ff00ff");
	    myMap.put("Dark Magenta", "750073");
	    myMap.put("White", "f9f9f9");
	    myMap.put("Dark Gray", "535353");
	    myMap.put("Gray", "aeaeae");
	    myMap.put("Black", "181818");
	    return myMap;
	}
	
	public static String findKey(String value) {

	    for(Entry<String, String> entry: COLORS.entrySet()) {
	    	if(entry.getValue().equals(value)) {
	            return entry.getKey();
            }
	    }
	    return "";
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="outercolorhex")
	private String outerColorHex;
	@Column(name="innercolorhex")
	private String innerColorHex;
	@Column(name="outercolorname")
	private String outerColorName;
	@Column(name="innercolorname")
	private String innerColorName;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="civilization_id")
	private Civilization civilization;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="leader_id")
	private Leader leader;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Combination() {
	}
	
	public Combination(String outerColorHex, String innerColorHex, String outerColorName, String innerColorName, Civilization civilization, Leader leader) {
		this.outerColorHex = outerColorHex;
		this.innerColorHex = innerColorHex;
		this.outerColorName = outerColorName;
		this.innerColorName = innerColorName;
		this.civilization = civilization;
		this.leader = leader;
	}
	
	public Combination(Civilization civilization, Leader leader) {
		this.civilization = civilization;
		this.leader = leader;
		this.outerColorHex = "696969";
		this.innerColorHex = "D3D3D3";
		this.outerColorName = "DimGray";
		this.innerColorName = "LightGray";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOuterColorHex() {
		return outerColorHex;
	}
	public void setOuterColorHex(String outerColorHex) {
		this.outerColorHex = outerColorHex;
	}
	public String getInnerColorHex() {
		return innerColorHex;
	}
	public void setInnerColorHex(String innerColorHex) {
		this.innerColorHex = innerColorHex;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		String combinationString = "Combination ----> Civilization: " + this.civilization.getName() + ", ID=" + String.valueOf(this.civilization.getId()) + " ----- Leader: " + this.leader.getName() + ", ID=" + String.valueOf(this.leader.getId()) + " ----- Combination ID: " + this.id + " ----- Outer Color: " + this.outerColorName + " ----- Inner Color: " + this.innerColorName + " ----- User: ";
		if(this.user == null) {
			combinationString += "None (Default Civilization and Leader)";
		} else {
			combinationString += user.getFirstName() + user.getLastName();
		}
		return combinationString;
	}
	
	public boolean equals(Combination combination) {
		if(combination.getLeader().getId() == this.leader.getId() && combination.getCivilization().getId() == this.civilization.getId()){
			return true;
		} else {
			return false;
		}
	}
	
}
