package br.com.treinotrack.models.exercises;

abstract class Exercise {
    private String name;
    private  int duration;
    private int caloriesBurned;

    //Builders
    public Exercise() {
    	this.name = NULL;
    	this.duration = 0;
    	this.caloriesBurned = 0;
    }
    public Exercise(String name, int duration, int caloriesBurned) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }
    
    //Getters and Setters
}




