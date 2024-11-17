package treinotrack.UIconsole;

import treinotrack.data.ExerciseRepository;
import treinotrack.facades.ExerciseFacade;
import treinotrack.facades.UserFacade;
import treinotrack.facades.WorkoutFacade;
import treinotrack.data.models.User;
import treinotrack.data.models.Workout;
import treinotrack.data.models.exercises.ExerciseAbstract;
import treinotrack.data.models.exercises.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


public class UIuser {
    private final WorkoutFacade workoutFacade;
    private final User user;
    private final Scanner scanner;
    private ExerciseFacade exerciseFacade = new ExerciseFacade();
    private UserFacade userFacade = new UserFacade();
    private static final Logger logger = Logger.getLogger(ExerciseRepository.class.getName());
    private List<ExerciseAbstract> exercises;

    public UIuser( int index) {
        this.workoutFacade = new WorkoutFacade();
        this.user = userFacade.readUserByIndex(index);
        this.scanner = new Scanner(System.in);
        this.exercises = new ArrayList<>();

    }

    public void showUserWorkouts(int userIndex) {
        List<String> workouts = userFacade.getUserWorkouts(userIndex);
        System.out.println("Lista de Treinos Atribuídos ao Usuário: " + userFacade.returnUser(userIndex));
        for (int i = 0; i < workouts.size(); i++) {
            System.out.println("Índice: " + i + " - Nome do Treino: " + workouts.get(i));
        }

        System.out.println("\nDigite o índice do treino para ver os detalhes, ou -1 para sair:");
        int index = scanner.nextInt();
        if (index >= 0 && index < workouts.size()) {
            String workoutName = workouts.get(index);
            List<Workout> workoutList = workoutFacade.loadWorkouts();
            for (Workout workout : workoutList) {
                System.out.println("Workout Name: " + workout.getName());
                showWorkoutDetails(workout.getName());
                for (ExerciseAbstract exercise : exercises) {
                    System.out.println(exercise.toString());
                }
            }

        } else {
            System.out.println("Saindo.");
        }
    }
    private void showWorkoutDetails(String fileName) {
        String workoutFileName = "workouts/" + fileName + ".json";
        try (BufferedReader reader = new BufferedReader(new FileReader(workoutFileName))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            parseWorkoutJson(json.toString());
            logger.info("Workout loaded successfully.");
        } catch (FileNotFoundException e) {
            logger.warning("Workout file not found. Creating new file.");
            try {
                new File(workoutFileName).createNewFile();
            } catch (IOException ioException) {
                logger.severe("Error creating new workout file: " + ioException.getMessage());
            }
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
                ExerciseAbstract exercise = createExercise(type, fields, name, description);
                if (exercise != null) {
                    exercises.add(exercise);
                }
            }
        }
    }

    private ExerciseAbstract createExercise(String type, String[] fields, String name, String description) {
        switch (type) {
            case "Treadmil":
                if (fields.length < 5) {
                    logger.warning("Invalid Treadmil data: " + String.join(",", fields));
                    return null;
                }
                double speed = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                double duration = Double.parseDouble(fields[4].split(":")[1].replace("\"", "").trim());
                return new Treadmil(duration, speed, name, description);
            case "Hike":
                if (fields.length < 4) {
                    logger.warning("Invalid Hike data: " + String.join(",", fields));
                    return null;
                }
                duration = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                return new Hike(duration, name, description);
            case "Race":
                if (fields.length < 4) {
                    logger.warning("Invalid Race data: " + String.join(",", fields));
                    return null;
                }
                duration = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                return new Race(duration, name, description);
            case "Strength":
                if (fields.length < 6) {
                    logger.warning("Invalid Strength data: " + String.join(",", fields));
                    return null;
                }
                int sets = Integer.parseInt(fields[3].split(":")[1].replace("\"", "").trim());
                int reps = Integer.parseInt(fields[4].split(":")[1].replace("\"", "").trim());
                float strengthWeight = Float.parseFloat(fields[5].split(":")[1].replace("\"", "").trim());
                return new Strength(sets, reps, strengthWeight, name, description);
            default:
                logger.warning("Unknown exercise type: " + type);
                return null;
        }
    }
}