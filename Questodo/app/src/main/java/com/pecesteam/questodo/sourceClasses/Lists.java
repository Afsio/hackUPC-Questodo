package com.pecesteam.questodo.sourceClasses;

import java.util.ArrayList;
import java.util.Scanner;

public class Lists {
	
	private ArrayList<Tasks> ToDo;
	private ArrayList<Tasks> Doing;
	private ArrayList<Tasks> Done;
	Scanner read= new Scanner(System.in);
	
	public Lists(){
		ToDo= new ArrayList<Tasks>();
		Doing=new ArrayList<Tasks>();
		Done=new ArrayList<Tasks>();
	}
	
	public void addToDo(){
		System.out.println("Insert the task name:");
		
		String name=read.nextLine();
		System.out.println("Insert the description of the task: ");
		String desc= read.nextLine();
		
		Tasks miau=new Tasks(name, desc);
		
		ToDo.add(miau);
	}
	
	public void addToDoing(String nameOfTask){
		Tasks guau = new Tasks();
		Profile us;
		for (int i = 0; i < ToDo.size(); i++) {
			if(ToDo.get(i).equals(nameOfTask))
			guau= ToDo.get(i);	
		}
		if(guau.getName()!=null){
			
			us = new Profile();
			System.out.println("Select the user:");
			String nprof= read.nextLine();
			if(us.getFullProfile(nprof)!=null){
			System.out.println(us.getName());
			guau.SetUser(us);				//Add user for doing this task
			Doing.add(guau);				// Add task on Doing list
			ToDo.remove(guau);
			}
			
			else
				System.out.println("User not found");
			//Scanner for selecting the users
			
		}
		System.out.println("Task not found");
		
	}
	
	public void addToDone(String dim){
		Tasks guau= new Tasks();
		for (int i = 0; i < ToDo.size(); i++) {
			if(ToDo.get(i).equals(dim))
			guau= ToDo.get(i);	
		}
		if( !(guau.getName()!=null) ){
		Done.add(guau);
		Doing.remove(guau);
		}else
			System.out.println(dim+" is not found");
	}
	
	public boolean isDone(){
		String resposta;
		if(ToDo.isEmpty() && Doing.isEmpty() && !Done.isEmpty())
		System.out.println(" Has acabat el projecte? ");
		resposta=read.next();
		if(resposta.equalsIgnoreCase("si"))
			return true;
		else
			return false;
	}
	
	public ArrayList<String> InfoToDo(){
		ArrayList<String> Infos= new ArrayList<String>();
		for (int i = 0; i < ToDo.size(); i++) {
			Infos.add(ToDo.get(i).toString());	
		} 
		return Infos;
	}
	
	public ArrayList<String> InfoDoing(){
		ArrayList<String> Info= new ArrayList<String>();
		for (int i = 0; i < Doing.size(); i++) {
			Info.add(Doing.get(i).toString()+" "+Doing.get(i).getUser());
		}
		return Info;
	}
	public ArrayList<String> InfoDone(){
		ArrayList<String> Info= new ArrayList<String>();
		for (int i = 0; i < Doing.size(); i++) {
			Info.add(Done.get(i).toString()+" "+Done.get(i).getUser());
		}
		return Info;
	}
 
}
