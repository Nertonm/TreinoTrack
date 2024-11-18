package treinotrack.interfaces;

import treinotrack.data.models.Workout;
import java.util.List;

public interface IWorkoutRepository {
    List<Workout> getWorkouts();
    void createWorkout(Workout workout);
    void saveWorkout(Workout workout);
    void updateWorkout(int index, Workout workout, String old);
    void deleteWorkout(int index);
}