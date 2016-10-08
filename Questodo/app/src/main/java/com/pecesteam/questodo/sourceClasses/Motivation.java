package com.pecesteam.questodo.sourceClasses;

import java.util.Random;

public class Motivation {
	private String motivation;
	
	public Motivation(){
		motivation = null;
	}

	public String getMotivation() {return motivation;}
	
	public String needMotivation(int tria){
			
			switch(tria){
			case 1: 
				String a = new String("Be strong man");
				return a;
				
			case 2:
				String b = new String("Never give up");
				return b;
			case 3:
				String c = new String("Face it all");
				return c;
			case 4:
				String d = new String("You are the Storm");
				return d;
			case 5:
				String e = new String("No pain, no gain");
				return e;
			case 6:
				String f = new String("Keep calm, and program hard");
				return f;
			case 7:
				String g = new String("Sleep is for mortals"); //son las 7:01 estoy muerto
				return g;
			case 8:
				String h = new String("JUST DO IT");
				return h;
			case 9:
				String i = new String("May the force with you");
				return i;
			case 10:
				String j = new String("They may take our lives, but they'll never take our freedom!");
				return j;
			case 11:
				String k = new String("Play it, Sam. Play 'As Time Goes By");
				return k;
			case 12:
				String l = new String("If you build it, he will come.");
				return l;
			case 13:
				String m = new String("To infinity and beyond!");
				return m;	
				
				
			
			}
			return motivation;
	}
	private static Motivation a = new Motivation();
	
	public String motivateME(){
		int y = 0;
		String motivate;
		Random rnd = new Random();
		y = (int)(rnd.nextDouble() * 13 + 1);
		motivate = a.needMotivation(y);
		return motivate;
	}
		
	
}
