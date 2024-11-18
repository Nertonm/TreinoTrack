package treinotrack.service;

import treinotrack.data.models.exercises.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserWorkoutReader {
    private static final Logger logger = Logger.getLogger(UserWorkoutReader.class.getName());
    static {
        logger.setLevel(Level.OFF);
    }
    private final List<String> exercicios = new ArrayList<>();
    private final UserService userService = new UserService();
    private final ExerciseService exerciseService = new ExerciseService();
    private int userIndex;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: UserWorkoutReader <userFilePath> <userIndex>");
            return;
        }
        String userFilePath = args[0];
        int userIndex = Integer.parseInt(args[1]);
        UserWorkoutReader reader = new UserWorkoutReader();
        List<String> workoutNames = reader.readUserWorkouts(userFilePath, userIndex);
        for (String workoutName : workoutNames) {
            reader.showWorkoutDetails(workoutName);
        }
    }
    public List<String> getExercises() {
        return this.exercicios;
    }

    public void addStringJsonMaluco(String i) {
       this.exercicios.add(i);
    }

    public List<String> readUserWorkouts(String filePath, int userIndex) {
        this.userIndex = userIndex;
        List<String> workoutsNamePath = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            String jsonString = json.toString();
            logger.info("User file content: " + jsonString);

            int userStartIndex = jsonString.indexOf("[{");
            if (userStartIndex != -1) {
                String usersJson = jsonString.substring(userStartIndex, jsonString.lastIndexOf("]") + 1);
                String[] users = usersJson.split("\\},\\s*\\{");
                if (userIndex < users.length) {
                    String userJson = users[userIndex].replace("[{", "").replace("}]", "").replace("{", "").replace("}", "");
                    logger.info("User JSON: " + userJson);
                    int workoutsStartIndex = userJson.indexOf("\"workoutsNamePath\":");
                    if (workoutsStartIndex != -1) {
                        String workoutsJson = userJson.substring(workoutsStartIndex + 19, userJson.indexOf("]", workoutsStartIndex) + 1);
                        workoutsJson = workoutsJson.replace("[", "").replace("]", "").replace("\"", "").trim();
                        String[] workouts = workoutsJson.split(",");
                        for (String workout : workouts) {
                            workoutsNamePath.add(workout.trim());
                        }
                    }
                } else {
                    logger.warning("User index out of bounds.");
                }
            }
        } catch (IOException e) {
            logger.severe("Error reading user file: " + e.getMessage());
        }
        return workoutsNamePath;
    }

    public void showWorkoutDetails(String workoutName) {
        String workoutFileName = "workouts/" + workoutName + ".json";
        try (BufferedReader reader = new BufferedReader(new FileReader(workoutFileName))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            logger.info("Workout file content: " + json.toString());
            parseWorkoutJson(json.toString());
            logger.info("Workout loaded successfully.");
        } catch (IOException e) {
            logger.severe("Error loading workout: " + e.getMessage());
        }
    }

    private void parseWorkoutJson(String jsonString) {
        if (!jsonString.isEmpty()) {
            int exercisesStartIndex = jsonString.indexOf("\"exercises\":");
            if (exercisesStartIndex != -1) {
                String exercisesJson = jsonString.substring(exercisesStartIndex + 12, jsonString.length() - 1);
                parseExercisesJson(exercisesJson);
            } else {
                logger.warning("No exercises found in workout JSON.");
            }
        }
    }

    private void parseExercisesJson(String jsonString) {
        if (!jsonString.isEmpty()) {
            jsonString = jsonString.substring(1, jsonString.length() - 1); // Remove brackets
            String[] exerciseStrings = jsonString.split("\\},\\{");
            for (String exerciseString : exerciseStrings) {
                exerciseString = exerciseString.replace("{", "").replace("}", "");
                String[] fields = exerciseString.split("\",\"");
                if (fields.length < 3) {
                    logger.warning("Invalid exercise data: " + exerciseString);
                    continue;
                }
                String type = fields[0].split(":")[1].replace("\"", "").trim();
                String name = fields[1].split(":")[1].replace("\"", "").trim();
                String description = fields[2].split(":")[1].replace("\"", "").trim().replace("\\n", "\n");
               addStringJsonMaluco("    Name: " + name + "\n");
               addStringJsonMaluco("    Type: " + type + "\n");
               addStringJsonMaluco("    Description: " + description + "\n");
                switch (type) {
                    case "Treadmil":
                        if (fields.length < 5) {
                            logger.warning("Invalid Treadmil data: " + String.join(",", fields));
                            break;
                        }
                        double speed = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                        double duration = Double.parseDouble(fields[4].split(":")[1].replace("\"", "").trim());
                       addStringJsonMaluco("    Speed: " + speed + "\n");
                       addStringJsonMaluco("    Duration: " + duration + "\n");
                       addStringJsonMaluco("    +/- Calories Burned: " + exerciseService.getCaloriesBurned(new Treadmil(duration, speed, name, description),
                               (userService.getUserByIndex(this.userIndex).getWeight())) + "\n" + "\n");
                        break;
                    case "Hike":
                        if (fields.length < 4) {
                            logger.warning("Invalid Hike data: " + String.join(",", fields));
                            break;
                        }
                        double hikeDuration = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                        addStringJsonMaluco("    Duration: " + hikeDuration + "\n");
                        addStringJsonMaluco("    +/- Calories Burned: " + exerciseService.getCaloriesBurned(new Hike(hikeDuration, name, description),
                                (userService.getUserByIndex(this.userIndex).getWeight())) + "\n" + "\n");
                        break;
                    case "Race":
                        if (fields.length < 4) {
                            logger.warning("Invalid Race data: " + String.join(",", fields));
                            break;
                        }
                        double raceDuration = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                        addStringJsonMaluco("    Duration: " + raceDuration + "\n");
                        addStringJsonMaluco("    +- Calories Burned: " + exerciseService.getCaloriesBurned(new Race(raceDuration, name, description),
                                (userService.getUserByIndex(this.userIndex).getWeight())) + "\n" + "\n");
                        break;
                    case "Strength":
                        if (fields.length < 6) { // Adjusted to check for 6 fields
                            logger.warning("Invalid Strength data: " + String.join(",", fields));
                            break;
                        }
                        int sets = Integer.parseInt(fields[3].split(":")[1].replace("\"", "").trim());
                        int reps = Integer.parseInt(fields[4].split(":")[1].replace("\"", "").trim());
                        float strengthWeight = Float.parseFloat(fields[5].split(":")[1].replace("\"", "").trim());
                        new Strength(sets, reps, strengthWeight, name, description);
                       addStringJsonMaluco("    Sets: " + sets + "\n");
                       addStringJsonMaluco("    Reps: " + reps + "\n");
                       addStringJsonMaluco("    Weight: " + strengthWeight + "\n" + "\n");
                        break;
                    default:
                        logger.warning("Unknown exercise type: " + type);
                        break;
                }
            }
        }
    }
}