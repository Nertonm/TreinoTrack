package treinotrack.service;

import treinotrack.models.Workout;
import treinotrack.models.User;
import java.util.ArrayList;
import java.util.List;

public class WorkoutService {
	private List<Workout> workouts;
	private UserService userService;

	public WorkoutService(UserService userService) {
		this.workouts = new ArrayList<>();
		this.userService = userService;
	}

	public void readWorkouts() {
		if (workouts.isEmpty()) {
			System.out.println("No workouts available.");
			return;
		}
		System.out.println("List of Workouts:");
		for (int i = 0; i < workouts.size(); i++) {
			Workout workout = workouts.get(i);
			System.out.println("\nIndex: " + i
					+ "\nName: " + workout.getName()
					+ "\nDescription: " + workout.getDescription());
		}
	}

	public void updateWorkout(int index, String name, String description) {
		if (index >= 0 && index < workouts.size()) {
			Workout workout = workouts.get(index);
			workout.setName(name);
			workout.setDescription(description);
			System.out.println("Workout updated successfully.");
		} else {
			System.out.println("Invalid index!");
		}
	}

	public void deleteWorkout(int index) {
		if (index >= 0 && index < workouts.size()) {
			workouts.remove(index);
			System.out.println("Workout deleted successfully.");
		} else {
			System.out.println("Invalid index!");
		}
	}

	public void assignWorkoutToUser(int workoutIndex, int userIndex) {
		if (workoutIndex >= 0 && workoutIndex < workouts.size() && userIndex >= 0 && userIndex < userService.getUsers().size()) {
			Workout workout = workouts.get(workoutIndex);
			User user = userService.getUsers().get(userIndex);
			user.addWorkout(workout);
			System.out.println("Workout assigned to user successfully.");
		} else {
			System.out.println("Invalid workout or user index!");
		}
	}
}