package com.pecesteam.questodo.sourceClasses;

public class Achivement {
	private String name;
	private String description;
	private int done;
	
	public Achivement(int done, String name, String description){
		this.name = name;
		this.description = description;
		this.done = done;
	}

	public String getName() {return name;}
	public String getDescription() {return description;}
	public int getDone(){return done;}
	public void setDone(int done) {this.done = done;}

	public String toString(){
		return ("Achivement: "+name+"\tDescription: "+description+"\tStatus: "+done+"\n");
	}
	
}