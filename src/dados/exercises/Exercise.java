package br.com.treinotrack.models.exercises;
import br.com.treinotrack.models.User;

public abstract class Exercise {
    private String name;
    private double caloriesBurned;
    private double MET;
    private User user;
    
    //Getters and Setters
    public String getName() {return name;}
    public double getCaloriesBurned() {return caloriesBurned;}

    public abstract void performExercise();
	public double getMET() {return MET;}
	public void setMET(int MET) {MET = MET;}
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}

    public void setName(String name) {
        this.name = name;
    }
}




