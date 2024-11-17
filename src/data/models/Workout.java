package treinotrack.data.models;


import treinotrack.data.models.exercises.*;

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

    public void addExercise(ExerciseAbstract exercise) {
        this.exercises.add(exercise);
    }

    public List<ExerciseAbstract> getExercises() {
        return exercises;
    }

    public void setExercises(String jsonExercises) {
        this.exercises = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)
                .append(", Description: ").append(description)
                .append(", Exercises: [");
        for (ExerciseAbstract exercise : exercises) {
            sb.append("\n  ").append(exercise.toString());
        }
        sb.append("\n]");
        return sb.toString();
    }
}