package treinotrack.models.exercises;

public abstract class Strength extends ExerciseAbstract {
    private int sets;
    private int reps;
    private double weight;

    public Strength() {
        // No-argument constructor
    }

    public Strength(String name, int sets, int reps, double weight) {
        this.setName(name);
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public double getWeight() {
        return weight;
    }
}