package treinotrack.data;

import treinotrack.interfaces.IWorkoutRepository;
import treinotrack.models.Workout;
import treinotrack.models.exercises.ExerciseAbstract;
import treinotrack.models.exercises.*;
import java.io.*;
import java.util.ArrayList;

public class WorkoutRepository implements IWorkoutRepository {
    private ArrayList<Workout> workouts;
    private static final String FILE_NAME = "workouts.json";

    public WorkoutRepository(String name, String description) {
        workouts = new ArrayList<>();
        loadWorkouts();
    }

    @Override
    public void addWorkout(Workout workout) {
        workouts.add(workout);
        saveWorkouts();
    }

    @Override
    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    @Override
    public void updateWorkout(int index, Workout updatedWorkout) {
        if (index >= 0 && index < workouts.size()) {
            workouts.set(index, updatedWorkout);
            saveWorkouts();
        } else {
            throw new IndexOutOfBoundsException("Invalid index for workout update.");
        }
    }

    @Override
    public void deleteWorkout(int i) {
        if (i >= 0 && i < workouts.size()) {
            workouts.remove(i);
            saveWorkouts();
        }
    }

    public void saveWorkouts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("[");
            for (int i = 0; i < workouts.size(); i++) {
                Workout workout = workouts.get(i);
                writer.write("{");
                writer.write("\"name\":\"" + workout.getName() + "\",");
                writer.write("\"description\":\"" + workout.getDescription() + "\",");
                writer.write("\"exercises\":[");
                for (int j = 0; j < workout.getExercises().size(); j++) {
                    ExerciseAbstract exercise = workout.getExercises().get(j);
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
                    if (j < workout.getExercises().size() - 1) {
                        writer.write(",");
                    }
                }
                writer.write("]");
                writer.write("}");
                if (i < workouts.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWorkouts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            String jsonString = json.toString();
            if (!jsonString.isEmpty()) {
                jsonString = jsonString.substring(1, jsonString.length() - 1); // Remove brackets
                String[] workoutStrings = jsonString.split("\\},\\{");
                for (String workoutString : workoutStrings) {
                    workoutString = workoutString.replace("{", "").replace("}", "");
                    String[] fields = workoutString.split(",");
                    String name = fields[0].split(":")[1].replace("\"", "");
                    String description = fields[1].split(":")[1].replace("\"", "");
                    Workout workout = new Workout(name, description);
                    String exercisesString = fields[2].split(":")[1];
                    exercisesString = exercisesString.substring(1, exercisesString.length() - 1); // Remove brackets
                    String[] exerciseStrings = exercisesString.split("\\},\\{");
                    for (String exerciseString : exerciseStrings) {
                        exerciseString = exerciseString.replace("{", "").replace("}", "");
                        String[] exerciseFields = exerciseString.split(",");
                        String type = exerciseFields[0].split(":")[1].replace("\"", "");
                        String exerciseName = exerciseFields[1].split(":")[1].replace("\"", "");
                        String exerciseDescription = exerciseFields[2].split(":")[1].replace("\"", "");
                        ExerciseAbstract exercise;
                        switch (type) {
                            case "Treadmil":
                                double speed = Double.parseDouble(exerciseFields[3].split(":")[1].replace("\"", ""));
                                double duration = Double.parseDouble(exerciseFields[4].split(":")[1].replace("\"", ""));
                                double weight = Double.parseDouble(exerciseFields[5].split(":")[1].replace("\"", ""));
                                exercise = new Treadmil(duration, weight, speed);
                                break;
                            case "Hike":
                                duration = Double.parseDouble(exerciseFields[3].split(":")[1].replace("\"", ""));
                                weight = Double.parseDouble(exerciseFields[4].split(":")[1].replace("\"", ""));
                                exercise = new Hike(duration, weight);
                                break;
                            case "Race":
                                duration = Double.parseDouble(exerciseFields[3].split(":")[1].replace("\"", ""));
                                weight = Double.parseDouble(exerciseFields[4].split(":")[1].replace("\"", ""));
                                exercise = new Race(duration, weight);
                                break;
                            case "Strength":
                                int sets = Integer.parseInt(exerciseFields[3].split(":")[1].replace("\"", ""));
                                int reps = Integer.parseInt(exerciseFields[4].split(":")[1].replace("\"", ""));
                                weight = Double.parseDouble(exerciseFields[5].split(":")[1].replace("\"", ""));
                                exercise = new Strength(exerciseName, sets, reps, weight) {};
                                break;
                            default:
                                throw new IllegalArgumentException("Unknown exercise type: " + type);
                        }
                        workout.addExercise(exercise);
                    }
                    workouts.add(workout);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Workout file not found. Creating a new file.");
        } catch (IOException e) {
            System.out.println("Error loading workouts: " + e.getMessage());
        }
    }
}