// ExerciseRepository.java
package treinotrack.data;

import treinotrack.models.exercises.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ExerciseRepository {
    private List<ExerciseAbstract> exercises;
    private static final String FILE_NAME = "exercises.json";
    private static final Logger logger = Logger.getLogger(ExerciseRepository.class.getName());

    public ExerciseRepository() {
        exercises = new ArrayList<>();
        loadExercises();
    }

    public void addExercise(ExerciseAbstract exercise) {
        exercises.add(exercise);
        saveExercises();
    }

    public List<ExerciseAbstract> getExercises() {
        return exercises;
    }

    public void removeExercise(ExerciseAbstract exercise) {
        exercises.remove(exercise);
        saveExercises();
    }

    private void saveExercises() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
            writer.write("[");
            for (int i = 0; i < exercises.size(); i++) {
                ExerciseAbstract exercise = exercises.get(i);
                writer.write("{");
                writer.write("\"type\":\"" + exercise.getClass().getSimpleName() + "\",");
                writer.write("\"name\":\"" + exercise.getName() + "\",");
                writer.write("\"description\":\"" + exercise.getDescription().replace("\n", "\\n") + "\"");
                if (exercise instanceof Treadmil) {
                    Treadmil treadmil = (Treadmil) exercise;
                    writer.write(",\"speed\":\"" + treadmil.getSpeed() + "\",");
                    writer.write("\"duration\":\"" + treadmil.getDuration() + "\"");
                } else if (exercise instanceof Hike) {
                    Hike hike = (Hike) exercise;
                    writer.write(",\"duration\":\"" + hike.getDuration() + "\"");
                } else if (exercise instanceof Race) {
                    Race race = (Race) exercise;
                    writer.write(",\"duration\":\"" + race.getDuration() + "\"");
                } else if (exercise instanceof Strength) {
                    Strength strength = (Strength) exercise;
                    writer.write(",\"sets\":\"" + strength.getSets() + "\",");
                    writer.write("\"reps\":\"" + strength.getReps() + "\",");
                    writer.write("\"weight\":\"" + strength.getWeight() + "\"");
                }
                writer.write("}");
                if (i < exercises.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
            logger.info("Exercises saved successfully.");
        } catch (IOException e) {
            logger.severe("Error saving exercises: " + e.getMessage());
        }
    }

    private void loadExercises() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            String jsonString = json.toString();
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
                    ExerciseAbstract exercise;
                    switch (type) {
                        case "Treadmil":
                            if (fields.length < 5) {
                                logger.warning("Invalid Treadmil data: " + exerciseString);
                                continue;
                            }
                            double speed = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                            double duration = Double.parseDouble(fields[4].split(":")[1].replace("\"", "").trim());
                            exercise = new Treadmil(duration, speed, name, description);
                            break;
                        case "Hike":
                            if (fields.length < 4) {
                                logger.warning("Invalid Hike data: " + exerciseString);
                                continue;
                            }
                            duration = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                            exercise = new Hike(duration, name, description);
                            break;
                        case "Race":
                            if (fields.length < 4) {
                                logger.warning("Invalid Race data: " + exerciseString);
                                continue;
                            }
                            duration = Double.parseDouble(fields[3].split(":")[1].replace("\"", "").trim());
                            exercise = new Race(duration, name, description);
                            break;
                        case "Strength":
                            if (fields.length < 6) {
                                logger.warning("Invalid Strength data: " + exerciseString);
                                continue;
                            }
                            int sets = Integer.parseInt(fields[3].split(":")[1].replace("\"", "").trim());
                            int reps = Integer.parseInt(fields[4].split(":")[1].replace("\"", "").trim());
                            float strengthWeight = Float.parseFloat(fields[5].split(":")[1].replace("\"", "").trim());
                            exercise = new Strength(sets, reps, strengthWeight, name, description);
                            break;
                        default:
                            logger.warning("Unknown exercise type: " + type);
                            continue;
                    }
                    exercises.add(exercise);
                }
            }
            logger.info("Exercises loaded successfully.");
        } catch (FileNotFoundException e) {
            logger.warning("Exercise file not found. Creating new file.");
        } catch (IOException e) {
            logger.severe("Error loading exercises: " + e.getMessage());
        }
    }
}