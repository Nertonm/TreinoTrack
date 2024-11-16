// WorkoutRepository.java
package treinotrack.data;

import treinotrack.interfaces.IWorkoutRepository;
import treinotrack.data.models.Workout;
import treinotrack.data.models.exercises.ExerciseAbstract;
import treinotrack.data.models.exercises.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutRepository implements IWorkoutRepository {
    private List<Workout> workouts;
    private static final String DIRECTORY_NAME = "workouts";

    public WorkoutRepository() {
        workouts = new ArrayList<>();
        loadWorkouts();
    }

    @Override
    public void createWorkout(Workout workout) {
        workouts.add(workout);
        saveWorkout(workout);
    }

    @Override
    public List<Workout> getWorkouts() {
        return workouts;
    }

    @Override
    public void updateWorkout(int index, Workout updatedWorkout) {
        if (index >= 0 && index < workouts.size()) {
            workouts.set(index, updatedWorkout);
            saveWorkout(updatedWorkout);
        } else {
            throw new IndexOutOfBoundsException("Invalid index for workout update.");
        }
    }

    @Override
    public void deleteWorkout(int i) {
        if (i >= 0 && i < workouts.size()) {
            Workout workout = workouts.remove(i);
            deleteWorkoutFile(workout);
        }
    }

    @Override
    public void saveWorkout(Workout workout) {
        File directory = new File(DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdir();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DIRECTORY_NAME + "/" + workout.getName() + ".json"))) {
            writer.write("{");
            writer.write("\"name\":\"" + workout.getName() + "\",");
            writer.write("\"description\":\"" + workout.getDescription() + "\",");
            writer.write("\"exercises\":[");
            for (int i = 0; i < workout.getExercises().size(); i++) {
                ExerciseAbstract exercise = workout.getExercises().get(i);
                writer.write("{");
                writer.write("\"type\":\"" + exercise.getClass().getSimpleName() + "\",");
                writer.write("\"name\":\"" + exercise.getName() + "\",");
                writer.write("\"description\":\"" + exercise.getDescription() + "\"");
                if (exercise instanceof Cardio) {
                    Cardio cardio = (Cardio) exercise;
                    writer.write(",\"duration\":\"" + cardio.getDuration() + "\"");
                } else if (exercise instanceof Strength) {
                    Strength strength = (Strength) exercise;
                    writer.write(",\"weight\":\"" + strength.getWeight() + "\",");
                    writer.write("\"reps\":\"" + strength.getReps() + "\"");
                }
                writer.write("}");
                if (i < workout.getExercises().size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
            writer.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteWorkoutFile(Workout workout) {
        File file = new File(DIRECTORY_NAME + "/" + workout.getName() + ".json");
        if (file.exists()) {
            file.delete();
        }
    }

    private void loadWorkouts() {
        File directory = new File(DIRECTORY_NAME);
        if (!directory.exists()) {
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".json"));
        if (files != null) {
            for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    StringBuilder json = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        json.append(line);
                    }
                    String jsonString = json.toString();
                    if (!jsonString.isEmpty()) {
                        String[] fields = jsonString.replace("{", "").replace("}", "").split(",");
                        if (fields.length >= 3) {
                            String name = fields[0].split(":")[1].replace("\"", "");
                            String description = fields[1].split(":")[1].replace("\"", "");
                            Workout workout = new Workout(name, description);
                            String exercisesString = fields[2].split(":")[1];
                            exercisesString = exercisesString.substring(1, exercisesString.length() - 1); // Remove brackets
                            String[] exerciseStrings = exercisesString.split("\\},\\{");
                            for (String exerciseString : exerciseStrings) {
                                exerciseString = exerciseString.replace("{", "").replace("}", "");
                                String[] exerciseFields = exerciseString.split(",");
                                if (exerciseFields.length >= 3) {
                                    String type = exerciseFields[0].split(":")[1].replace("\"", "");
                                    String exerciseName = exerciseFields[1].split(":")[1].replace("\"", "");
                                    String exerciseDescription = exerciseFields[2].split(":")[1].replace("\"", "");
                                    ExerciseAbstract exercise;
                                    switch (type) {
                                        case "Treadmil":
                                            if (exerciseFields.length >= 5) {
                                                double speed = Double.parseDouble(exerciseFields[3].split(":")[1].replace("\"", ""));
                                                double duration = Double.parseDouble(exerciseFields[4].split(":")[1].replace("\"", ""));
                                                exercise = new Treadmil(duration, speed, exerciseName, exerciseDescription);
                                            } else {
                                                throw new IllegalArgumentException("Invalid Treadmil exercise data.");
                                            }
                                            break;
                                        case "Hike":
                                            if (exerciseFields.length >= 4) {
                                                double duration = Double.parseDouble(exerciseFields[3].split(":")[1].replace("\"", ""));
                                                exercise = new Hike(duration, exerciseName, exerciseDescription);
                                            } else {
                                                throw new IllegalArgumentException("Invalid Hike exercise data.");
                                            }
                                            break;
                                        case "Strength":
                                            if (exerciseFields.length >= 6) {
                                                int sets = Integer.parseInt(exerciseFields[3].split(":")[1].replace("\"", ""));
                                                int reps = Integer.parseInt(exerciseFields[4].split(":")[1].replace("\"", ""));
                                                float strengthWeight = Float.parseFloat(exerciseFields[5].split(":")[1].replace("\"", ""));
                                                exercise = new Strength(sets, reps, strengthWeight, exerciseName, exerciseDescription);
                                            } else {
                                                throw new IllegalArgumentException("Invalid Strength exercise data.");
                                            }
                                            break;
                                        default:
                                            throw new IllegalArgumentException("Unknown exercise type: " + type);
                                    }
                                    workout.addExercise(exercise);
                                }
                            }
                            workouts.add(workout);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}