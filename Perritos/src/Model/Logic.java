package Model;

import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {
	public PApplet app;
	private String [] datos;
	private String [] datosDos; 
	private String [] textSplit;
	private String [] textSplitTwo;
	private LinkedList <Dog> dog;
	private int id;
	private String name;
	private String age;
	private String breed;
	private String date;
	
	public Logic (PApplet app) {
		this.app = app;
		
		
		
		
		
		datos = app.loadStrings ("../data/datosUno.txt");
		datosDos = app.loadStrings("../data/datosDos.txt");
		dog = new LinkedList <Dog> ();
		createDog();
	}
	
	private void createDog () {
		for (int i = 0; i < datos.length; i++) {
			textSplit = datos[i].split(",");
			for (int j = 0; j <datosDos.length; j++) {
				textSplitTwo = datosDos[j].split(",");
			if (textSplitTwo[0].equals(textSplit[0])) {
			    id = Integer.parseInt (textSplit[0]);
			    name = textSplit[1];
			    age =  textSplit[2];
			    breed = textSplitTwo[1];
			    date = textSplitTwo [2];
			    
			    dog.add(new Dog (name, age, breed, date, id, app));
			}
		}
	}
	}
	
	public LinkedList <Dog> getDog () {
		return dog;
	}
	
	public void setDog (LinkedList<Dog> dog) {
		this.dog = dog;
	}
	
	public void sortList (char i) {
		switch (i) {
		case 'i': 
			Collections.sort(dog);
			break;
		}
	
	}
	
	
	
	

}
