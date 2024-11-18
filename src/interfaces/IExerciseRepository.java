package treinotrack.interfaces;

import treinotrack.data.models.exercises.ExerciseAbstract;

public interface IExerciseRepository {
    void addExercise(ExerciseAbstract exercise);
    void removeExercise(ExerciseAbstract exercise);
}
