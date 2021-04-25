package Model;

import processing.core.PApplet;

public class Dog implements Comparable <Dog> {
	private String name, age, breed, date;
	private int id;
	private int posX;
	private int posY;
	private PApplet app;
	
	public Dog (String name, String age, String breed, String date, int id, PApplet app) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.id = id;
		this.date = date;
		this.posX = 50;
		this.app = app;
	}
	
	public void drawDog (int posY, PApplet app) {
		app.fill(255);
		app.text("ID", 50, 45);
		app.text (this.id, posX, posY);
		app.text("NAME", 100, 45);
		app.text (this.name, posX + 50, posY);
		app.text("AGE", 190, 45);
		app.text (this.age, posX+ 150, posY);
		app.text("BREED", 280, 45);
		app.text (this.breed, posX + 220, posY);
		app.text("BIRTH DATE", 460, 45);
		app.text (this.date, posX+ 400, posY);

		
	}
	
	public int compareTo(Dog otherDog) {
		return this.id - otherDog.getId();
		
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	
	

}
