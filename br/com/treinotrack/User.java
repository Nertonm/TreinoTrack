package br.com.treinotrack;
import br.com.treinotrack.Tracker;

public class User {
    private String name; //nome
    private byte age; // idade
    private float height; // altura
    private float weight; // peso
    private float imc; // imc
    Tracker userTracker;
    
    public void getIMC(){
        imc = weight / (height * height);
    } // faz o imc
	public String getName() {
		return name;
	} // acessa o nome
	public void setName(String name) {
		this.name = name;
	} // pega o nome
	public byte getAge() {
		return age;
	}// acessa a idade
	public void setAge(byte age) {
		this.age = age;
	} // pega a idade
	public float getHeight() {
		return height;
	} // acessa a altura
	public void setHeight(float height) {
		this.height = height;
	} // pega a altura
	public float getWeight() {
		return weight;
	} // acessa o peso
	public void setWeight(float weight) {
		this.weight = weight;
	} // pega o peso
	public float getImc() {
		return imc;
	} // pega o imc


}

