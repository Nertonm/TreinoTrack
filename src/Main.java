package treinotrack;

import treinotrack.UIconsole.UIadmin;
import treinotrack.UIconsole.UIuser;
import treinotrack.facades.ExerciseFacade;
import treinotrack.facades.UserFacade;
import treinotrack.facades.WorkoutFacade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserFacade userFacade = new UserFacade();
        WorkoutFacade workoutFacade = new WorkoutFacade();
        ExerciseFacade exerciseFacade = new ExerciseFacade();
        System.out.println("Enter your role (admin/user):");
        String role = scanner.nextLine();
        if (role.equalsIgnoreCase("admin")) {
            System.out.println("Admin access granted.");
            UIadmin console = new UIadmin(userFacade, workoutFacade, exerciseFacade);
            console.start();
            console.close();
        } else if (role.equalsIgnoreCase("user")) {
            System.out.println("Enter your Index:");
            int index = scanner.nextInt();
            UIuser console = new UIuser(workoutFacade, userFacade.getUsers().size());
            console.showUserWorkouts(index);
        } else {
            System.out.println("Invalid role. Exiting.");
        }
        scanner.close();
    }
}
