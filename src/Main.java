package treinotrack;

import treinotrack.UIconsole.UIadmin;
import treinotrack.UIconsole.UIuser;
import treinotrack.data.models.User;
import treinotrack.facades.WorkoutFacade;
import treinotrack.service.WorkoutService;
import treinotrack.service.UserWorkoutReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkoutService workoutService = new WorkoutService();
        WorkoutFacade workoutFacade = new WorkoutFacade(workoutService);

        UserWorkoutReader userWorkoutReader = new UserWorkoutReader();

        System.out.println("Enter your role (admin/user):");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("admin")) {
            System.out.println("Admin access granted.");
            UIadmin console =  new UIadmin();
            console.start();
            console.close();
        } else if (role.equalsIgnoreCase("user")) {
            System.out.println("Enter your Index:");
            int index = scanner.nextInt();
            UIuser console = new UIuser(workoutFacade,index);
            console.showUserWorkouts(index);
        } else {
            System.out.println("Invalid role. Exiting.");
        }

        scanner.close();
    }
}