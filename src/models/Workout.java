package treinotrack.models;

import treinotrack.models.exercises.*;
import java.time.LocalDate;
import java.util.List;

public class Workout {
    private LocalDate data;
    private List<ExerciseAbstract>  workout;

    //Builder
    public Workout(LocalDate data, List<ExerciseAbstract> workout){
        this.data = data;
        this.workout = workout;
    }

    public LocalDate getData() {return data;}
    public void setData(LocalDate data) {this.data = data;}

    public List<ExerciseAbstract> getWorkout() {return workout;}
    public void setWorkout(List<ExerciseAbstract> workout) {this.workout = workout;}

}
