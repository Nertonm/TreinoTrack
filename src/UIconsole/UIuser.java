package treinotrack.UIconsole;

import treinotrack.facades.WorkoutFacade;
import treinotrack.facades.UserFacade;
import java.util.List;

public class UIuser {
    private final WorkoutFacade workoutFacade;
    private final UserFacade userFacade;

    public UIuser(WorkoutFacade workoutFacade, UserFacade userFacade) {
        this.workoutFacade = workoutFacade;
        this.userFacade = userFacade;
    }

    public void showUserWorkouts(int userIndex) {
        try {
            if (userIndex < 0 || userIndex >= userFacade.readUsers().size()) {
                throw new IndexOutOfBoundsException("Invalid user index");
            }
            List<String> details = workoutFacade.startReading(userIndex);
            System.out.println(details);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("User not found: " + e.getMessage());
        }
    }
}