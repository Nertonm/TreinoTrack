package br.com.treinotrack.models.exercises;
import br.com.treinotrack.models.User;

public abstract class Cardio extends Exercise {
    double duration;
    double weight;
    
	protected double getWeight() {return this.getUser().getWeight();}
	public abstract double getMET();
	public double getDuration() {return this.duration;}
	public void setDuration(double duration) {this.duration = duration;}

}

// Classe Treadmil - Esteira
abstract class Treadmil extends Cardio {
	private double speed;
	
    public Treadmil(double duration, double weight, double speed) {
        this.duration = duration;
        this.weight = weight;
        this.speed = speed;
    }

    @Override
    public void performExercise() {
        System.out.println("Running on the treadmill for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }
    
    public double getMET(double speed) {
        if (speed < 4.0) return 3.3; 		// Caminhada leve
        else if (speed < 5.0) return 4.3; 	// Caminhada moderada
        else if (speed < 6.0) return 5.0; 	// Caminhada rápida
        else if (speed < 8.0) return 8.3; 	// Corrida leve
        else if (speed < 9.0) return 9.8; 	// Corrida moderada
        else if (speed < 10.0) return 11.0; // Corrida rápida
        else if (speed < 12.0) return 13.0; // Corrida muito rápida
        else if (speed < 13.0) return 14.0; // Corrida intensa
        else return 16.0; 					// Corrida muito intensa
    }
}

// Classe Hike - Caminhada
class Hike extends Cardio {
    public Hike(double duration, double weight) {
        this.duration = duration;
        this.weight = weight;
    }

    @Override
    public void performExercise() {
        System.out.println("Hiking for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }

    @Override
    public double getMET() {
        return 3.8; // Caminhada leve
    }
}

// Classe Race - Corrida
class Race extends Cardio {
    public Race(int duration, double weight) {
        this.duration = duration;
        this.weight = weight;
    }

    @Override
    public void performExercise() {
        System.out.println("Racing for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }
    
    @Override
    public double getMET() {
        return 12.5; // Corrida intensa
    }
}

	

