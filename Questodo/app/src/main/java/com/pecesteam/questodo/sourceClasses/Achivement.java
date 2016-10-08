package com.pecesteam.questodo.sourceClasses;

public class Achivement {
	private String name;
	private String description;
	private int done;
	private Integer img;
	
	public Achivement(int done, String name, String description){
		this.name = name;
		this.description = description;
		this.done = done;
		this.img = null;
	}

	public String getName() {return name;}
	public String getDescription() {return description;}
	public int getDone(){return done;}
	public void setDone(int done) {this.done = done;}
	public Integer getImg(){ return img; }

	public String toString(){
		return ("Achivement: "+name+"\tDescription: "+description+"\tStatus: "+done+"\n");
	}
	
}