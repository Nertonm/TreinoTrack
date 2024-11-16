package treinotrack.models;

import treinotrack.models.exercises.ExerciseAbstract;
import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String name;
    private String description;
    private List<ExerciseAbstract> exercises;

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
        this.exercises = new ArrayList<>(); // Initialize the exercises list
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ExerciseAbstract> getExercises() {
        return exercises;
    }

    public void addExercise(ExerciseAbstract exercise) {
        this.exercises.add(exercise);
    }
}