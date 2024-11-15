package treinotrack.models.exercises;

public class Race extends Cardio {
    public Race(double duration, double weight) {
        this.duration = duration;
        this.weight = weight;
    }

    /*@Override
    public void performExercise() {
        System.out.println("Racing for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }
*/
    @Override
    public double getMET() {
        return 12.5; // Intense running
    }
}