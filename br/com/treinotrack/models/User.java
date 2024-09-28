package br.com.treinotrack.models;

public class User {
    private String name; //nome
    private byte age; // idade em anos
    private float height; // altura em metros
    private float weight; // peso em kg
    private String sex;
    private float imc; // imc

	// Builder
	public User(String name, byte age, float height, float weight, String sex){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		setIMC();
	}
	public User(){
		this.name = "Bob";
		this.age = 18;
		this.height = 1.70f;
		this.weight = 65.00f;
		this.sex = "male";
		setIMC();
	}
	public User(){
		this.name = "Bob";
		this.age = 18;
		this.height = 1.70f;
		this.weight = 65.00f;
		setIMC();
	}

	// Getters and Setters
	public float getImc() {return imc;} // 
	public void setIMC() {this.imc = this.weight / (this.height * this.height);}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public byte getAge() {return age;}
	public void setAge(byte age) {this.age = age;} 

	public float getHeight() {return height;}
	public void setHeight(float height) {this.height = height;}

	public float getWeight() {return weight;} 
	public void setWeight(float weight) {this.weight = weight;}
	public String getSex() {return sex;}
	public void setSex(String sex) {this.sex = sex;}

}

