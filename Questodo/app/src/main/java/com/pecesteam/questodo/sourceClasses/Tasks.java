package com.pecesteam.questodo.sourceClasses;


public class Tasks {

	private Profile user;
	private String type;
	private String name;
	private String description;
	
	public Tasks(String name, String type, String desc){
		this.name=name;
		description=desc;
		this.type = type;
	}
	
	public Tasks(){
		name=null;
		description=null;
	}
	public String getType(){return type;}
	public String getName(){return name;}
	public String getDescription(){return description;}
	public void SetUser(Profile us){user=us;}
	
	public String toString(){
		return("Task: "+name+"\nDescription: "+description);
	}
	
	public Profile getUser(){return user;}
	
	
}
