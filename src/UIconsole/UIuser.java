package treinotrack.UIconsole;

import treinotrack.facades.WorkoutFacade;
import java.util.List;

public class UIuser {
    private final WorkoutFacade workoutFacade;

    public UIuser( int index) {
        this.workoutFacade = new WorkoutFacade();
    }

    public void showUserWorkouts(int userIndex) {
        List<String> details =  workoutFacade.startReading(userIndex);
        System.out.println(details);
    }
}