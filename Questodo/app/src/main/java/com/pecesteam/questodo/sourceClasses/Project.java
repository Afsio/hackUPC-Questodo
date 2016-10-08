package com.pecesteam.questodo.sourceClasses;

import java.util.Scanner;

public class Project {
	
	Scanner read = new Scanner(System.in);
	private String name;
	private Lists l1;
	
	public Project(){
		name=null;
		l1=null;
	}
	
	public void StartNewProject(){
		System.out.println("Insert your project name:");
		name= read.nextLine();
		l1= new Lists();
		
	}
	/*
	 * This task allows us introduce new tasks on our project to do 
	 */
	public void AddTasks(){
		l1.addToDo();
	}
	
	public void DoingTasks(String t1){
		l1.addToDoing(t1);
	}
	
	public int DoneTasks(String s1, int nachivments){
		l1.addToDone(s1);
		if(l1.isDone())
			return nachivments++;
		else
			return nachivments;
	}
	
	public String toString(){
		return("Project: "+name+"\nTo Do:"+l1.InfoToDo()+"\nDoing: "+l1.InfoDoing()+"\nDone:"+l1.InfoDone());
		
	}
	
	

}
