package treinotrack.UIconsole;

import treinotrack.facades.WorkoutFacade;
import treinotrack.facades.UserFacade;
import java.util.List;

public class UIuser {
    private final WorkoutFacade workoutFacade;
    private final UserFacade userFacade;

    public UIuser() {
        this.workoutFacade = new WorkoutFacade();
        this.userFacade = new UserFacade();
    }

    public void showUserWorkouts(int userIndex) {
        if (userIndex < 0 || userIndex > userFacade.readUsers().size()) {
            throw new IndexOutOfBoundsException("Invalid user index");
        }
        List<String> details =  workoutFacade.startReading(userIndex);
        System.out.println(details);
    }
}