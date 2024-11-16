package treinotrack.models.exercises;

// Classe Hike - Caminhada
public class Hike extends Cardio {
    public Hike(double duration, String name, String description) {
        this.duration = duration;
        super.setName(name);
        super.setDescription(description);
    }

   /* @Override
    public void performExercise() {
        System.out.println("Hiking for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }
*/
    @Override
    public double getMET() {
        return 3.8; // Caminhada leve
    }
}
