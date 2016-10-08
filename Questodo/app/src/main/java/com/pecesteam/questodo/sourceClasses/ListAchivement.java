package com.pecesteam.questodo.sourceClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;




public class ListAchivement {
	private static final int MAX = 10;
	private static Achivement[] list= new Achivement[MAX];
	private static int done;
	private static String name, description;
	private static Profile p;
	private static int nachivments=0, nach_ant=nachivments;
	
	/**
	 * Initialize list
	 */
	public ListAchivement(){
		list = new Achivement[MAX];
		for(int i = 0; i <= MAX; i++){
			list[i] = null;
		}
	}
	
	public static void readFile() throws IOException{
		try{
		BufferedReader buf = new BufferedReader(new FileReader("prueba.txt"));
		String linea = buf.readLine();
		int x = 0;
		
			while(linea != null){
				
				StringTokenizer st = new StringTokenizer(linea, ",");
				done = Integer.parseInt(st.nextToken());
				name = st.nextToken();
				description = st.nextToken();
				list[x] = new Achivement (done, name, description);
				x++;
				linea = buf.readLine();
			}
		
		buf.close();
		}catch(FileNotFoundException e){
			System.out.println("�Hey, my name is Ralph!");
			
		}
	}
	
	public static void writeFile() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("prueba.txt"));
		for(int i = 0; i<MAX; i++){
			bw.write(list[i].getDone()+","+list[i].getName()+","+list[i].getDescription());
			bw.newLine();
			
		}
		bw.close();
	}
	
	
	public static boolean setAchive(/*nComplete*/) throws IOException{//comrpobar con variable local si se tiene que asignar el logro
		boolean modif = false;
		for (int i=0; i<MAX; i++){
			if(list[i].getName().equals("PutoAmo")/*&& contadorLogro >= min */){ //contador sencillo de trabajos acabados 
				list[i].setDone(1);
				writeFile();
				modif = true;
			}
		}
		return modif;
	}

	public Achivement[] getListArray(){
		Achivement[] copy = new Achivement[MAX];
		for(int i = 0; i < MAX; i++){
			copy[i] = list[i];
		}
		return copy;
	}
	

	private static Motivation a = new Motivation();
	static Scanner read= new Scanner(System.in);
	public static void main(String[]args)throws IOException{
		ArrayList<Project> p1= new ArrayList<Project>();
		int x=0;
		readFile();
		for(int i = 0; i<MAX; i++){
			System.out.println(list[i].toString());
		}
		setAchive();
		for(int i = 0; i<MAX; i++){
			System.out.println(list[i].toString());
		}
		System.out.println(a.motivateME());
		
		p = new Profile();
		p.LoadFile();
		Project proj;
		do{
		System.out.println("\nMenu");
		System.out.println("1-Add new Project");
		System.out.println("2-See my projects");
		System.out.println("3- Get out");
		x=Integer.parseInt(read.nextLine());
		if(x==1){
			proj= new Project();
			proj.StartNewProject();
			p1.add(proj);
		}
		else if(x==2){
			for (int i = 0; i < p1.size(); i++) {
				System.out.println(i + p1.get(i).toString());
			}
			x=Integer.parseInt(read.nextLine());	//Number of the project chosen
			
			proj=p1.get(x);
			
			System.out.println("What do you want to do?");
			System.out.println("1- Add tasks");
			System.out.println("2- Move to Doing");
			System.out.println("3- Move to Done");
			x= Integer.parseInt(read.nextLine());
			if (x==1){
				proj.AddTasks();
			}else if(x==2){
				System.out.println("What task do you want to move?");
				proj.DoingTasks(read.nextLine());
			}else if(x==3){
				System.out.println("What task do you want to move?");
				nachivments=proj.DoneTasks(read.nextLine(), nachivments);
				if(nachivments%5==0 && nachivments>nach_ant)
					p.addLevel();
				nach_ant=nachivments;
			}
			
		}
			
			
		}while(x!=3);
		
		
	}
	
	
	
}

