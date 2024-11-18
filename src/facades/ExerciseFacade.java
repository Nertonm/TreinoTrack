// ExerciseFacade.java
package treinotrack.facades;

import treinotrack.data.models.exercises.ExerciseAbstract;
import treinotrack.service.ExerciseService;

import java.util.List;

public class ExerciseFacade {
    private final ExerciseService exerciseService;

    public ExerciseFacade() {
        this.exerciseService = new ExerciseService();
    }

    public void addExercise(ExerciseAbstract exercise) {
        try {
            exerciseService.addExercise(exercise);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar exercício: " + e.getMessage());
        }
    }

    public void removeExercise(ExerciseAbstract exercise) {
        try {
            exerciseService.removeExercise(exercise);
        } catch (Exception e) {
            System.out.println("Erro ao remover exercício: " + e.getMessage());
        }
    }

    public float getCaloriesBurned(ExerciseAbstract exercise, int weight) {
        try {
            return exerciseService.getCaloriesBurned(exercise, weight);
        } catch (Exception e) {
            System.out.println("Erro ao calcular calorias queimadas: " + e.getMessage());
            return 0;
        }
    }

    public List<ExerciseAbstract> getExercises() {
        try {
            return exerciseService.getExercises();
        } catch (Exception e) {
            System.out.println("Erro ao obter lista de exercícios: " + e.getMessage());
            return List.of();
        }
    }

    public ExerciseAbstract getExerciseByIndex(int index) {
        try {
            List<ExerciseAbstract> exercises = exerciseService.getExercises();
            if (index >= 0 && index < exercises.size()) {
                return exercises.get(index);
            } else {
                throw new IndexOutOfBoundsException("Índice de exercício inválido");
            }
        } catch (Exception e) {
            System.out.println("Erro ao obter exercício por índice: " + e.getMessage());
            return null;
        }
    }

    public void newTreadmil(String name, String description, double duration, double speed) {
        try {
            exerciseService.newTreadmil(name, description, duration, speed);
        } catch (Exception e) {
            System.out.println("Erro ao criar exercício de esteira: " + e.getMessage());
        }
    }

    public void newStrength(String name, String description, int sets, int reps, float weight) {
        try {
            exerciseService.newStrength(name, description, sets, reps, weight);
        } catch (Exception e) {
            System.out.println("Erro ao criar exercício de força: " + e.getMessage());
        }
    }

    public void newHike(String name, String description, double duration) {
        try {
            exerciseService.newHike(name, description, duration);
        } catch (Exception e) {
            System.out.println("Erro ao criar exercício de caminhada: " + e.getMessage());
        }
    }

    public void newRace(String name, String description, double duration) {
        try {
            exerciseService.newRace(name, description, duration);
        } catch (Exception e) {
            System.out.println("Erro ao criar exercício de corrida: " + e.getMessage());
        }
    }
}