// ExerciseFacade.java
package treinotrack.facades;

import treinotrack.models.exercises.ExerciseAbstract;
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
}