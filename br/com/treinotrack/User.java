package br.com.treinotrack;

public class User {
    private String name;
    private int age;
    private float height;
    private float weight;
    private float imc;

    public void IMC(){
        imc = weight / (height * height);
    }
}

