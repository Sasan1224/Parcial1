package Controller;

import java.util.LinkedList;

import Model.Dog;
import Model.Logic;
import processing.core.PApplet;

public class ControllerMain {
	public PApplet app;
	Logic logics;
	
	public ControllerMain (PApplet app) {
		logics = new Logic (app);
	}
	
	public LinkedList<Dog> dog () {
		return logics.getDog();
	}
	
	public void sortListController (char i) {
		logics.sortList(i);
	}

}
