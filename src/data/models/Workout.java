package treinotrack.data.models;


import treinotrack.data.models.exercises.*;

import java.io.IOException;
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
    public void setExercises(String jsonExercises) {
        this.exercises = new ArrayList<>();
        jsonExercises = jsonExercises.trim();
        if (jsonExercises.startsWith("[") && jsonExercises.endsWith("]")) {
            jsonExercises = jsonExercises.substring(1, jsonExercises.length() - 1); // Remove outer brackets
        }
        String[] exerciseArray = jsonExercises.split("\\},\\{");

        for (String exerciseStr : exerciseArray) {
            exerciseStr = exerciseStr.replaceAll("[\\[\\]\\{\\}]", ""); // Remove brackets and braces
            String[] fields = exerciseStr.split(",");
            String type = null, name = null, description = null;
            int sets = 0, reps = 0;
            float weight = 0, speed = 0, duration = 0;

            for (String field : fields) {
                String[] keyValue = field.split(":");
                String key = keyValue[0].trim().replaceAll("\"", "");
                String value = keyValue[1].trim().replaceAll("\"", "");

                switch (key) {
                    case "type":
                        type = value;
                        break;
                    case "name":
                        name = value;
                        break;
                    case "description":
                        description = value;
                        break;
                    case "sets":
                        sets = Integer.parseInt(value);
                        break;
                    case "reps":
                        reps = Integer.parseInt(value);
                        break;
                    case "weight":
                        weight = Float.parseFloat(value);
                        break;
                    case "speed":
                        speed = Float.parseFloat(value);
                        break;
                    case "duration":
                        duration = Float.parseFloat(value);
                        break;
                }
            }

            ExerciseAbstract exercise = null;
            switch (type) {
                case "Strength":
                    exercise = new Strength(sets, reps, weight, name, description);
                    break;
                case "Hike":
                    exercise = new Hike(duration, name, description);
                    break;
                case "Treadmil":
                    exercise = new Treadmil(speed, duration, name, description);
                    break;
                case "Race":
                    exercise = new Race(duration, name, description);
                    break;
            }

            if (exercise != null) {
                this.exercises.add(exercise);
            }
        }
    }

    public void addExercise(ExerciseAbstract exercise) {
        this.exercises.add(exercise);
    }}