// ExerciseFacade.java
package treinotrack.facades;

import treinotrack.data.models.exercises.ExerciseAbstract;
import treinotrack.service.ExerciseService;

import java.util.List;

public class ExerciseFacade {
    private final ExerciseService exerciseService;

    public ExerciseFacade(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    public void addExercise(ExerciseAbstract exercise) {
        exerciseService.addExercise(exercise);
    }

    public void removeExercise(ExerciseAbstract exercise) {
        exerciseService.removeExercise(exercise);
    }

    public List<ExerciseAbstract> getExercises() {
        return exerciseService.getExercises();
    }
    public ExerciseAbstract getExerciseByIndex(int index) {
        List<ExerciseAbstract> exercises = exerciseService.getExercises();
        if (index >= 0 && index < exercises.size()) {
            return exercises.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid exercise index");
        }
    }
    public void newTreadmil(String name, String description, double duration, double speed) {
        exerciseService.newTreadmil(name,description, duration, speed);
    }
    public void newStrength(String name,String description, int sets, int reps, float weight) {
        exerciseService.newStrength(name,description, sets, reps, weight);
    }
    public void newHike(String name,String description,  double duration) {
        exerciseService.newHike(name,description, duration);
    }
    public void newRace(String name,String description, double duration) {
        exerciseService.newRace(name,description, duration);
    }
}