package View;

import Controller.ControllerMain;
import processing.core.PApplet;

public class Main extends PApplet {
	
	ControllerMain createMain;
	ControllerMain sortListMain;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("View.Main");

	}
	
	public void settings () {
		size ( 700, 600);
	}
	
	public void  setup () {
		createMain = new ControllerMain (this);
		sortListMain = new ControllerMain (this);
		
	}
	
	public void draw () {
		background (100, 200, 200);
		
		for (int i = 0; i <createMain.dog().size(); i++) {
			createMain.dog().get(i).drawDog((i*(50))+ 80, this);
		}
		
	}
	
	public void keyPressed () {
		sortListMain.sortListController(key);
	}
	

}
