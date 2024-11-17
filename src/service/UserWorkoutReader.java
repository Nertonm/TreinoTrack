package treinotrack.service;

import treinotrack.data.models.exercises.Hike;
import treinotrack.data.models.exercises.Race;
import treinotrack.data.models.exercises.Strength;
import treinotrack.data.models.exercises.Treadmil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserWorkoutReader {
    private static final Logger logger = Logger.getLogger(UserWorkoutReader.class.getName());

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("UserWorkoutReader <userFilePath> <userIndex>");
            return;
        }

        String userFilePath = args[0];
        int userIndex = Integer.parseInt(args[1]);
        List<String> workoutNames = readUserWorkouts(userFilePath, userIndex);
        for (String workoutName : workoutNames) {
            showWorkoutDetails(workoutName);
        }
    }

    public static void start(int userIndex) {
        if (userIndex < 0) {
            System.out.println("Invalid user index.");
            return;
        }
        String userFilePath = "users.json";
        List<String> workoutNames = readUserWorkouts(userFilePath, userIndex);
        for (String workoutName : workoutNames) {
            showWorkoutDetails(workoutName);
        }
    }

    private static List<String> readUserWorkouts(String filePath, int userIndex) {
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
                String usersJson = jsonString.substring(userStartIndex, jsonString.indexOf("]") + 1);
                String[] users = usersJson.split("\\},\\{");
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

    private static void showWorkoutDetails(String workoutName) {
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

    private static void parseWorkoutJson(String jsonString) {
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
    private static void parseExercisesJson(String jsonString) {
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
                System.out.println("Type: " + type);
                System.out.println("Name: " + name);
                System.out.println("Description: " + description);
                System.out.println();
                switch (type) {
                    case "Treadmil":
                        if (fields.length < 5) {
                            logger.warning("Invalid Treadmil data: " + String.join(",", fields));
                            break;
                        }
                        double speed = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                        double duration = Double.parseDouble(fields[4].split(":")[1].replace("\"", "").trim());
                        new Treadmil(duration, speed, name, description);
                        System.out.println("Speed: " + speed);
                        System.out.println("Duration: " + duration);
                        break;
                    case "Hike":
                        if (fields.length < 4) {
                            logger.warning("Invalid Hike data: " + String.join(",", fields));
                            break;
                        }
                        double hikeDuration = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                        new Hike(hikeDuration, name, description);
                        System.out.println("Duration: " + hikeDuration);
                        break;
                    case "Race":
                        if (fields.length < 4) {
                            logger.warning("Invalid Race data: " + String.join(",", fields));
                            break;
                        }
                        double raceDuration = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                        new Race(raceDuration, name, description);
                        System.out.println("Duration: " + raceDuration);
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
                        System.out.println("Sets: " + sets);
                        System.out.println("Reps: " + reps);
                        System.out.println("Weight: " + strengthWeight);
                        break;
                    default:
                        logger.warning("Unknown exercise type: " + type);
                        break;
                }
            }
        }
    }
}