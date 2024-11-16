package treinotrack.models.exercises;

public class Treadmil extends Cardio {
    private double speed;

    public Treadmil(double duration, double speed, String name, String description) {
        this.duration = duration;
        this.speed = speed;
        super.setName(name);
        super.setDescription(description);
    }

    /*@Override
    public void performExercise() {
        System.out.println("Running on the treadmill for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }
*/
    public double getSpeed() {
        return speed;
    }

    @Override
    public double getMET() {
        if (speed < 4.0) return 3.3;        // Caminhada leve
        else if (speed < 5.0) return 4.3;   // Caminhada moderada
        else if (speed < 6.0) return 5.0;   // Caminhada rápida
        else if (speed < 8.0) return 8.3;   // Corrida leve
        else if (speed < 9.0) return 9.8;   // Corrida moderada
        else if (speed < 10.0) return 11.0; // Corrida rápida
        else if (speed < 12.0) return 13.0; // Corrida muito rápida
        else if (speed < 13.0) return 14.0; // Corrida intensa
        else return 16.0;                   // Corrida muito intensa
    }
}