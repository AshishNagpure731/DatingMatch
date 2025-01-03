package com.mat.now.userentity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "User")
public class Userentity {
	@Id
	private String id;
	private String name;
	private String age;
	private String gender;
	private String intreseted_in;
	private String  location;
	private ArrayList<String> hobbies;
	private ArrayList<String> interests;
	private String occupation;
	private String eductaion_level;
	private ArrayList<String> personality_traits;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIntreseted_in() {
		return intreseted_in;
	}
	public void setIntreseted_in(String intreseted_in) {
		this.intreseted_in = intreseted_in;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	public ArrayList<String> getInterests() {
		return interests;
	}
	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEductaion_level() {
		return eductaion_level;
	}
	public void setEductaion_level(String eductaion_level) {
		this.eductaion_level = eductaion_level;
	}
	public ArrayList<String> getPersonality_traits() {
		return personality_traits;
	}
	public void setPersonality_traits(ArrayList<String> personality_traits) {
		this.personality_traits = personality_traits;
	}
}
