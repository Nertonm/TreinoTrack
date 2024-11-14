package treinotrack.models;
import java.io.Serializable;

public class User implements Serializable{
	private static final long seraialVersionUID = 1L;
    private String name; //nome
    private byte age; // idade em anos
    private float height; // altura em metros
    private float weight; // peso em kg
    private String sex;

	// Builder
	public User(String name, byte age, float height, float weight, String sex){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
	}

	// Getters and Setters
	public float getImc() {return weight / (height * height);} //

	//nome
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	//idade
	public byte getAge() {return age;}
	public void setAge(byte age) {this.age = age;} 

	//altura
	public float getHeight() {return height;}
	public void setHeight(float height) {this.height = height;}

	//peso
	public float getWeight() {return weight;} 
	public void setWeight(float weight) {this.weight = weight;}

	//sexo
	public void setSex(String sex) {this.sex = sex;}

}

