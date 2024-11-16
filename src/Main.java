package treinotrack;

import treinotrack.IUconsole.IU;
import treinotrack.IUconsole.IUuser;
import treinotrack.facades.WorkoutFacade;
import treinotrack.models.User;
import treinotrack.models.Workout;
import treinotrack.service.WorkoutService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkoutService workoutService = new WorkoutService();
        WorkoutFacade workoutFacade = new WorkoutFacade(workoutService);

        System.out.println("Enter your role (admin/user):");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("admin")) {
            System.out.println("Admin access granted.");
            IU console =  new IU();
            console.start();
            console.close();
        } else if (role.equalsIgnoreCase("user")) {
            System.out.println("Enter your Index:");
            int index = scanner.nextInt();
            IUuser console = new IUuser(workoutFacade,index);
            console.showUserWorkouts();
        } else {
            System.out.println("Invalid role. Exiting.");
        }

        scanner.close();
    }
}