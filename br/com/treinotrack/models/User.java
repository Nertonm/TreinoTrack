package br.com.treinotrack.models;

public class User {
    private String name; //nome
    private byte age; // idade em anos
    private float height; // altura em metros
    private float weight; // peso em kg
    private float imc; // imc

	// Builder
	public User(String name, byte age, float height, float weight){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		setIMC();
	}

	// Getters and Setters
	public float getImc() {return imc;} // pega o imc
	public void setIMC() {this.imc = this.weight / (this.height * this.height);}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public byte getAge() {return age;}// acessa a idade
	public void setAge(byte age) {this.age = age;} // pega a idade

	public float getHeight() {return height;} // acessa a altura
	public void setHeight(float height) {this.height = height;} // pega a altura

	public float getWeight() {return weight;} // acessa o peso
	public void setWeight(float weight) {this.weight = weight;} // pega o peso

}

