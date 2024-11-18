package treinotrack.data.models.exercises;

public class Strength extends ExerciseAbstract {
    private int sets;
    private int reps;
    private float weight;

    public Strength(int sets, int reps, float weight, String name, String description) {
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        super.setName(name);
        super.setDescription(description);
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

    @Override
    public String toString() {
        return "Strength{ " +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                '}';
    }
}