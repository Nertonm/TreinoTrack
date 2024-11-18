package treinotrack.UIconsole;

import treinotrack.facades.WorkoutFacade;
import java.util.List;

public class UIuser {
    private final WorkoutFacade workoutFacade;
    private final int size;
    public UIuser(WorkoutFacade workoutFacade, int size) {
        this.workoutFacade = workoutFacade;
        this.size = size;
    }

    public void showUserWorkouts(int userIndex) {
        try {
            if (userIndex < 0 || userIndex >= size) {
                throw new IndexOutOfBoundsException("Invalid user index");
            }
            List<String> details = workoutFacade.startReading(userIndex);
            System.out.println(details);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("User not found: " + e.getMessage());
        }
    }
}