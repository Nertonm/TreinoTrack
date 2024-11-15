// WorkoutService.java
package treinotrack.service;

import treinotrack.data.WorkoutRepository;
import treinotrack.models.Workout;
import treinotrack.models.User;
import treinotrack.models.exercises.ExerciseAbstract;

import java.util.List;
import java.util.logging.Logger;

public class WorkoutService {
	private WorkoutRepository workoutRepository;
	private static final Logger logger = Logger.getLogger(WorkoutService.class.getName());

	public WorkoutService() {
		this.workoutRepository = new WorkoutRepository();
	}

	public List<Workout> loadWorkouts(User user) {
		return workoutRepository.getWorkouts();
	}

	public void createWorkout(User user, String name, String description) {
		Workout workout = new Workout(name, description);
		workoutRepository.createWorkout(workout);
		logger.info("Workout created successfully.");
	}

	public void updateWorkout(User user, int index, String name, String description) {
		List<Workout> workouts = workoutRepository.getWorkouts();
		if (index >= 0 && index < workouts.size()) {
			Workout workout = workouts.get(index);
			workout.setName(name);
			workout.setDescription(description);
			workoutRepository.updateWorkout(index, workout);
			logger.info("Workout updated successfully.");
		} else {
			logger.severe("Invalid index for workout update.");
		}
	}

	public void deleteWorkout(User user, int index) {
		List<Workout> workouts = workoutRepository.getWorkouts();
		if (index >= 0 && index < workouts.size()) {
			workoutRepository.deleteWorkout(index);
			logger.info("Workout deleted successfully.");
		} else {
			logger.severe("Invalid index for workout deletion.");
		}
	}

	public void assignWorkoutToUser(User user, int workoutIndex) {
		List<Workout> workouts = workoutRepository.getWorkouts();
		if (workoutIndex >= 0 && workoutIndex < workouts.size()) {
			Workout workout = workouts.get(workoutIndex);
			String workoutPath = workout.getName();
			user.addWorkout(workoutPath);
			logger.info("Workout assigned to user successfully.");
		} else {
			logger.severe("Invalid workout index.");
		}
	}

	public void addExerciseToWorkout(User user, int workoutIndex, ExerciseAbstract exercise) {
		List<Workout> workouts = workoutRepository.getWorkouts();
		if (workoutIndex >= 0 && workoutIndex < workouts.size()) {
			Workout workout = workouts.get(workoutIndex);
			workout.addExercise(exercise);
			workoutRepository.updateWorkout(workoutIndex, workout);
			logger.info("Exercise added to workout successfully.");
		} else {
			logger.severe("Invalid workout index.");
		}
	}
}