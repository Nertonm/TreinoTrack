package br.com.treinotrack;
import br.com.treinotrack.Tracker;

public class User {
    private String name;
    private int age;
    private float height;
    private float weight;
    private float imc;
    Tracker userTracker;
    public void IMC(){
        imc = weight / (height * height);
    }
}

