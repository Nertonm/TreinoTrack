package treinotrack.interfaces;

import treinotrack.models.Workout;
import java.util.List;

public interface IWorkoutRepository {
    List<Workout> getWorkouts();
    void addWorkout(Workout workout);
    void saveWorkouts();
    void updateWorkout(int index, Workout workout);
    void deleteWorkout(int index);
}