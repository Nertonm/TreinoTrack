package treinotrack.models.exercises;
import treinotrack.models.User;

public abstract class ExerciseAbstract {
    private String name;
    private User user;
    
    //Getters and Setters
    public String getName() {return name;}
    public abstract void performExercise();
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
    public void setName(String name) {
        this.name = name;
    }
}




