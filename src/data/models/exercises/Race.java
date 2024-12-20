package treinotrack.data.models.exercises;

public class Race extends Cardio {
    public Race(double duration, String name, String description) {
        this.duration = duration;
        super.setName(name);
        super.setDescription(description);
    }

    /*@Override
    public void performExercise() {
        System.out.println("Racing for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }
*/
    @Override
    public double getMET() {
        return 12.5;
    }

    @Override
    public String toString() {
        return "Race{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", duration=" + duration +
                '}';
    }
}