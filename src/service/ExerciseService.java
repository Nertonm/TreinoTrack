// ExerciseService.java
package treinotrack.service;

import treinotrack.models.exercises.ExerciseAbstract;
import treinotrack.data.ExerciseRepository;

import java.util.List;

public class ExerciseService {
    private ExerciseRepository exerciseRepository;

    public ExerciseService() {
        this.exerciseRepository = new ExerciseRepository();
    }

    public void addExercise(ExerciseAbstract exercise) {
        exerciseRepository.addExercise(exercise);
    }

    public void removeExercise(ExerciseAbstract exercise) {
        exerciseRepository.removeExercise(exercise);
    }

    public List<ExerciseAbstract> getExercises() {
        return exerciseRepository.getExercises();
    }
}