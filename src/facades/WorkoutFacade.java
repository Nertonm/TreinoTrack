// WorkoutFacade.java
package treinotrack.facades;

import treinotrack.models.Workout;
import treinotrack.models.User;
import treinotrack.models.exercises.ExerciseAbstract;
import treinotrack.service.WorkoutService;

import java.util.List;
import java.util.logging.Logger;

public class WorkoutFacade {
    private final WorkoutService workoutService;
    private static final Logger logger = Logger.getLogger(WorkoutFacade.class.getName());

    public WorkoutFacade(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    public void createWorkout(User user, String name, String description) {
        try {
            workoutService.createWorkout(user, name, description);
            logger.info("Workout created successfully.");
        } catch (Exception e) {
            logger.severe("Error creating workout: " + e.getMessage());
        }
    }

    public List<Workout> loadWorkouts(User user) {
        try {
            List<Workout> workouts = workoutService.loadWorkouts(user);
            logger.info("Workouts loaded successfully.");
            return workouts;
        } catch (Exception e) {
            logger.severe("Error loading workouts: " + e.getMessage());
            throw e;
        }
    }

    public void updateWorkout(User user, int index, String name, String description) {
        try {
            workoutService.updateWorkout(user, index, name, description);
            logger.info("Workout updated successfully.");
        } catch (Exception e) {
            logger.severe("Error updating workout: " + e.getMessage());
        }
    }

    public void deleteWorkout(User user, int index) {
        try {
            workoutService.deleteWorkout(user, index);
            logger.info("Workout deleted successfully.");
        } catch (Exception e) {
            logger.severe("Error deleting workout: " + e.getMessage());
            throw e;
        }
    }

    public void assignWorkoutToUser(User user, int workoutIndex) {
        try {
            workoutService.assignWorkoutToUser(user, workoutIndex);
            logger.info("Workout assigned to user successfully.");
        } catch (Exception e) {
            logger.severe("Error assigning workout to user: " + e.getMessage());
        }
    }

    public void addExerciseToWorkout(User user, int workoutIndex, ExerciseAbstract exercise) {
        try {
            workoutService.addExerciseToWorkout(user, workoutIndex, exercise);
            logger.info("Exercise added to workout successfully.");
        } catch (Exception e) {
            logger.severe("Error adding exercise to workout: " + e.getMessage());
        }
    }
}