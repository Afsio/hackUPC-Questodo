package com.pecesteam.questodo.sourceClasses;


public class User {
    private String name;
    private String user;
    private int ncomplete;
    private int level;

    public User(String name, String us, int lvl, int ncomplete){
        this.name=name;
        user=us;
        level=lvl;
        this.ncomplete=ncomplete;
    }

    public void SetUser(String user){
    	this.user=user;
    }
    
    public String toString(){
    	return("User: "+name+ "\nUsername: "+user+ "\nLevel: "+level+"\nAchievments:"+ncomplete);
    }




}
