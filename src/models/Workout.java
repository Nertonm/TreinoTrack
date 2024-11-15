package treinotrack.models;

import treinotrack.models.exercises.ExerciseAbstract;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<ExerciseAbstract> exercises;
    private String name;
    private String description;

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
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

    public ArrayList<ExerciseAbstract> getExercises() {
        return exercises;
    }

    public void addExercise(ExerciseAbstract exercise) {
        this.exercises.add(exercise);
    }

    public void removeExercise(ExerciseAbstract exercise) {
        this.exercises.remove(exercise);
    }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", exercises=" + exercises +
                '}';
    }
}