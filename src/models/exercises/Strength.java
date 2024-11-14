package treinotrack.models.exercises;

public abstract class Strength extends ExerciseAbstract {
    private int sets;
    private int reps;

    public Strength(String name, int sets, int reps){
        this.setName(name);
        this.sets = sets;
        this.reps = reps;
    }

    public int getSeries(){
        return sets;
    }
    public int getRepetiçoes(){
        return reps;
    }
    public void performExercise() {
        System.out.println("Performing " + getName() + ": " + sets + " sets of " + reps + " repetitions.");
    }

}
