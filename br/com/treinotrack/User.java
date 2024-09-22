package br.com.treinotrack;
import br.com.treinotrack.Tracker;

public class User {
    private String name;
    private byte age;
    private float height;
    private float weight;
    private float imc;
    Tracker userTracker;
    
    public void getIMC(){
        imc = weight / (height * height);
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getImc() {
		return imc;
	}
}

