// WorkoutFacade.java
package treinotrack.facades;

import treinotrack.data.models.Workout;
import treinotrack.data.models.exercises.ExerciseAbstract;
import treinotrack.service.WorkoutService;
import treinotrack.service.UserWorkoutReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkoutFacade {
    private final WorkoutService workoutService;
    private final UserWorkoutReader userWorkoutReader;
    private static final Logger logger = Logger.getLogger(WorkoutFacade.class.getName());
    static {
        logger.setLevel(Level.OFF);
    }
    public WorkoutFacade() {
        this.workoutService = new WorkoutService();
        this.userWorkoutReader = new UserWorkoutReader();
    }

    public List<String> startReading(int userIndex) {
        if (userIndex < 0) {
            System.out.println("Invalid user index.");
            return new ArrayList<>();
        }
        String userFilePath = "users.json";
        List<String> workoutNames = userWorkoutReader.readUserWorkouts(userFilePath, userIndex);
        for (String workoutName : workoutNames) {
            userWorkoutReader.addStringJsonMaluco("Treino: " + workoutName + "\n");
            userWorkoutReader.showWorkoutDetails(workoutName);
        }
        return userWorkoutReader.getExercises();
    }

    public void createWorkout(String name, String description) {
        try {
            workoutService.createWorkout(name, description);
            logger.info("Workout created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating workout: " + e.getMessage());
            logger.severe("Error creating workout: " + e.getMessage());
        }
    }

    public List<Workout> loadWorkouts() {
        try {
            List<Workout> workouts = workoutService.loadWorkouts();
            logger.info("Workouts loaded successfully.");
            return workouts;
        } catch (Exception e) {
            logger.severe("Error loading workouts: " + e.getMessage());
            System.err.println("Error loading workouts: " + e.getMessage());
            //throw e;
            return List.of(); // Return an empty list in case of error
        }
    }

    public void updateWorkout(  int index, int a, String description) {
        try {
            workoutService.updateWorkout( index, description);
            logger.info("Workout updated successfully.");
        } catch (Exception e) {
            logger.severe("Error updating workout: " + e.getMessage());
            System.err.println("Error updating workout: " + e.getMessage());
        }
    }
    public void updateWorkout( int index, String name) {
        try {
            workoutService.updateWorkout(index, name);
            logger.info("Workout updated successfully.");
        } catch (Exception e) {
            logger.severe("Error updating workout: " + e.getMessage());
            System.err.println("Error updating workout: " + e.getMessage());
        }
    }

    public void deleteWorkout(int index) {
        try {
            workoutService.deleteWorkout( index);
            logger.info("Workout deleted successfully.");
        } catch (Exception e) {
            logger.severe("Error deleting workout: " + e.getMessage());
            System.err.println("Error deleting workout: " + e.getMessage());
            throw e;
        }
    }

    public void addExerciseToWorkout( int workoutIndex, ExerciseAbstract exercise) {
        try {
            workoutService.addExerciseToWorkout( workoutIndex, exercise);
            logger.info("Exercise added to workout successfully.");
        } catch (Exception e) {
            logger.severe("Error adding exercise to workout: " + e.getMessage());
        }
    }
    public Workout readWorkoutByIndex(int index) {
        try {
            return workoutService.readWorkoutByIndex(index);
        } catch (Exception e) {
            System.err.println("Error reading workout: " + e.getMessage());
            return null;
        }
    }
}