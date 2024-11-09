package br.com.treinotrack.models;

import br.com.treinotrack.models.exercises.*;
import java.time.LocalDate;
import java.util.List;

public class Workout {
    private LocalDate data;
    private List<Exercise>  workout;

    //Builder
    public Workout(LocalDate data, List<Exercise> workout){
        this.data = data;
        this.workout = workout;
    }

    public LocalDate getData() {return data;}
    public void setData(LocalDate data) {this.data = data;}

    public List<Exercise> getWorkout() {return workout;}
    public void setWorkout(List<Exercise> workout) {this.workout = workout;}

}
