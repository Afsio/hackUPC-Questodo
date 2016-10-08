package com.pecesteam.questodo.sourceClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * Created by carlos on 8/10/16.
 */

public class Profile {

	Scanner read= new Scanner(System.in);
	private int ncomplete;	// number of complete works
    private String alias;
    private String name;      //User alias
    private int level;
	
    public Profile(){
    	this.name = null;
    	this.level = 0;
    	this.ncomplete = 0;
    }
    
    public Profile(String name, String alias, int level,int ncomplete){
    	this.name = name;
    	this.level = level;
    	this.ncomplete = ncomplete;
    	
    }
    public int getNcomplete() {return ncomplete;}
	public String getName() {return name;}
	public int getLevel() {return level;}
	private Profile p1;



		public void LoadFile() throws IOException{
            try{
                BufferedReader bf = new BufferedReader(new FileReader("user_logs.txt"));
                String line = bf.readLine();
                    StringTokenizer st = new StringTokenizer(line, ",");
                    name=st.nextToken();
                    alias=st.nextToken();
                    level= Integer.parseInt(st.nextToken());
                    ncomplete=Integer.parseInt(st.nextToken());                  
                    p1 = new Profile(name, alias, level, ncomplete);
                    bf.close();
                   System.out.println(p1);
                    
            }catch(FileNotFoundException e){    //If it's not found, ask for a new user.
            	 
        		System.out.println("Insert your name:");
                name=read.nextLine();
                System.out.println("Insert your Username:");
                alias = read.nextLine();
                BufferedWriter bw = new BufferedWriter(new FileWriter("user_logs.txt"));
                bw.write(name+","+alias+","+level+","+ncomplete);
                bw.close();
        		}
        		
            }
		public void addLevel(){
			level++;
		}
		public Profile getFullProfile( String name){
			if(p1.getName().equals(name)) {
				return p1;
			}else return null;
		}
			public String toString(){
				return("User: "+alias+"\tName: "+name+"\tlevel: "+level+"\tncomplete: "+ncomplete);
			}
        }
        
        
        
  


