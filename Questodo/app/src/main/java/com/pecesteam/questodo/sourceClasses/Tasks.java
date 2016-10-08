package com.pecesteam.questodo.sourceClasses;


public class Tasks {

	private Profile user;
	private String name;
	private String description;
	
	public Tasks(String name, String desc){
		this.name=name;
		description=desc;
	}
	
	public Tasks(){
		name=null;
		description=null;
	}
	public String getName(){return name;}
	public void SetUser(Profile us){user=us;}
	
	public String toString(){
		return("Task: "+name+"\nDescription: "+description);
	}
	
	public Profile getUser(){return user;}
	
	
}
