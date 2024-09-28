package br.com.treinotrack.models.exercises;

public abstract class Cardio extends Exercise {
    private double MET; // Valor MET específico do exercício

    public Cardio(int duration) {
        super(duration);
    }

    public void setMET(double MET) {
        this.MET = MET;
    }

    @Override
    public double getCaloriesBurned() {
        // Fórmula: Calorias = MET × Peso (kg) × Tempo (horas)
        return MET * getWeight() * (getDuration() / 60.0); // Dividindo por 60 para converter minutos para horas
    }
}

// Classe Treadmil - Esteira
public class Treadmil extends Cardio {
    public Treadmil(int duration, double weight) {
        super(duration, weight);
        setMET(9.8); // Corrida moderada
    }

    @Override
    public void performExercise() {
        System.out.println("Running on the treadmill for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }
}

// Classe Hike - Caminhada
public class Hike extends Cardio {
    public Hike(int duration, double weight) {
        super(duration, weight);
        setMET(3.8); // Caminhada leve
    }

    @Override
    public void performExercise() {
        System.out.println("Hiking for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }
}

// Classe Race - Corrida
public class Race extends Cardio {
    public Race(int duration, double weight) {
        super(duration, weight);
        setMET(12.5); // Corrida intensa
    }

    @Override
    public void performExercise() {
        System.out.println("Racing for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
    }
}

	

