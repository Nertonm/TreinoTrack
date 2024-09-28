package br.com.treinotrack.models.exercises;
import br.com.treinotrack.models.User;

public abstract class Exercise {
    private String name;
    private  int duration;
    private int caloriesBurned;
    private int MET;
    private User user;

    //Builders
    public Exercise() {
    	this.name = null;
    	this.duration = 0;
    	this.caloriesBurned = 0;
    }
    public Exercise(String name, int duration, User user) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = 0;
    }
    
    //Getters and Setters
    public String getName() {return name;}
    public int getDuration() {return duration;}
    public int getCaloriesBurned() {return caloriesBurned;}

    public abstract void performExercise();
	public int getMET() {return MET;}
	public void setMET(int mET) {MET = mET;}
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
}




