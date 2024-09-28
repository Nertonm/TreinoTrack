package br.com.treinotrack.models.exercises;

public abstract class Exercise {
    private String name;
    private  int duration;
    private int caloriesBurned;
    private int MET;

    //Builders
    public Exercise() {
    	this.name = null;
    	this.duration = 0;
    	this.caloriesBurned = 0;
    }
    public Exercise(String name, int duration, int caloriesBurned) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }
    
    //Getters and Setters
    public String getName() {return name;}
    public int getDuration() {return duration;}
    public int getCaloriesBurned() {return caloriesBurned;}

    public abstract void performExercise();
}




