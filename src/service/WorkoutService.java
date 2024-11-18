// WorkoutService.java
package treinotrack.service;

import treinotrack.data.WorkoutRepository;
import treinotrack.data.models.Workout;
import treinotrack.data.models.User;
import treinotrack.data.models.exercises.ExerciseAbstract;

import java.util.List;
import java.util.logging.Logger;

public class WorkoutService {
	private final WorkoutRepository workoutRepository;
	private static final Logger logger = Logger.getLogger(WorkoutService.class.getName());

	public WorkoutService() {
		this.workoutRepository = new WorkoutRepository();
	}

	public List<Workout> loadWorkouts() {
		return workoutRepository.getWorkouts();
	}

	public void createWorkout(String name, String description) {
		Workout workout = new Workout(name, description);
		workoutRepository.createWorkout(workout);
		logger.info("Workout created successfully.");
	}

	public void updateWorkout(int index, String name) {
		List<Workout> workouts = workoutRepository.getWorkouts();
		if (index >= 0 && index < workouts.size()) {
			Workout workout = workouts.get(index);
			workout.setName(name);
			workoutRepository.updateWorkout(index, workout);
			logger.info("Workout updated successfully.");
		} else {
			logger.severe("Invalid index for workout update.");
		}
	}

	public void deleteWorkout(int index) {
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


	public Workout readWorkoutByIndex(int workoutIndex) {
		List<Workout> workouts = workoutRepository.getWorkouts();
		if (workoutIndex >= 0 && workoutIndex < workouts.size()) {
			return workouts.get(workoutIndex);
		} else {
			logger.severe("Invalid workout index: " + workoutIndex);
			throw new IndexOutOfBoundsException("Invalid workout index: " + workoutIndex);
		}
	}

	public void addExerciseToWorkout(int workoutIndex, ExerciseAbstract exercise) {
		List<Workout> workouts = workoutRepository.getWorkouts();
		if (workoutIndex >= 0 && workoutIndex < workouts.size()) {
			Workout workout = workouts.get(workoutIndex);
			workout.addExercise(exercise);
			workoutRepository.saveWorkout(workout);
			//workoutRepository.updateWorkout(workoutIndex, workout);
			logger.info("Exercise added to workout successfully.");
		} else {
			logger.severe("Invalid workout index.");
			throw new IndexOutOfBoundsException("Invalid workout index");
		}
	}
}