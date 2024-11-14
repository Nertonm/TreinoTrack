package treinotrack.models;

import treinotrack.interfaces.IWorkout;

public class Workout implements IWorkout {
    private String name;
    private String description;

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}