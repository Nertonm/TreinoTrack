// IUuser.java
package treinotrack.IUconsole;

import treinotrack.facades.UserFacade;
import treinotrack.facades.WorkoutFacade;
import treinotrack.models.User;
import treinotrack.models.Workout;
import treinotrack.models.exercises.ExerciseAbstract;
import treinotrack.service.UserService;

import java.util.List;
import java.util.Scanner;

public class IUuser {
    private final WorkoutFacade workoutFacade;
    private final User user;
    private final Scanner scanner;
    private UserService userService = new UserService();
    private UserFacade userFacade = new UserFacade(userService);

    public IUuser(WorkoutFacade workoutFacade, int index) {
        this.workoutFacade = workoutFacade;
        this.user = userFacade.readUserByIndex(index);
        this.scanner = new Scanner(System.in);
    }

    public void showUserWorkouts() {
        List<Workout> workouts = workoutFacade.loadWorkouts(user);
        if (workouts.isEmpty()) {
            System.out.println("No workouts found.");
            return;
        }

        for (int i = 0; i < workouts.size(); i++) {
            Workout workout = workouts.get(i);
            System.out.println("\nIndex: " + i
                    + "\nName: " + workout.getName()
                    + "\nDescription: " + workout.getDescription());
        }

        System.out.println("\nEnter the index of the workout to view details, or -1 to exit:");
        int index = scanner.nextInt();
        if (index >= 0 && index < workouts.size()) {
            showWorkoutDetails(workouts.get(index));
        } else {
            System.out.println("Exiting.");
        }
    }

    private void showWorkoutDetails(Workout workout) {
        System.out.println("\nWorkout Name: " + workout.getName());
        System.out.println("Description: " + workout.getDescription());
        List<ExerciseAbstract> exercises = workout.getExercises();
        for (int i = 0; i < exercises.size(); i++) {
            ExerciseAbstract exercise = exercises.get(i);
            System.out.println("\nIndex: " + i
                    + "\nType: " + exercise.getClass().getSimpleName()
                    + "\nName: " + exercise.getName()
                    + "\nDescription: " + exercise.getDescription());
        }
    }
}