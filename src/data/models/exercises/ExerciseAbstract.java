package treinotrack.data.models.exercises;

public abstract class ExerciseAbstract {
    private String name;
    private String description;

    //Getters and Setters
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getName() {return name;}
   // public abstract void performExercise();
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "Name: " + name + ", Description: " + description;
    }
}




