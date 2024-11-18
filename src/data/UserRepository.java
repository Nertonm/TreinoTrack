// UserRepository.java
package treinotrack.data;

import treinotrack.data.models.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserRepository {
    private final ArrayList<User> users;
    private static final String FILE_NAME = "users.json";
    private static final Logger logger = Logger.getLogger(UserRepository.class.getName());

    public UserRepository() {
        users = new ArrayList<>();
        loadUsers();
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void updateUser(int index, User updatedUser) {
        if (index >= 0 && index < users.size()) {
            users.set(index, updatedUser);
            saveUsers();
            logger.info("User updated successfully at index " + index);
        } else {
            logger.severe("Invalid index for updating user: " + index);
            throw new IndexOutOfBoundsException("Índice inválido para atualização de usuário.");
        }
    }

    public void deleteUser(int i) {
        if (i >= 0 && i < users.size()) {
            users.remove(i);
            saveUsers();
        }
    }
    public void assignWorkoutToUser(int userIndex, String workoutName) {
        if (userIndex >= 0 && userIndex < users.size()) {
            User user = users.get(userIndex);
            user.getWorkouts().add(workoutName);
            saveUsers();
            logger.info("Workout assigned successfully to user at index " + userIndex);
        } else {
            logger.severe("Invalid index for assigning workout: " + userIndex);
            throw new IndexOutOfBoundsException("Índice inválido para atribuir treino.");
        }
    }

    public void unassignWorkoutFromUser(int userIndex, String workoutName) {
        if (userIndex >= 0 && userIndex < users.size()) {
            User user = users.get(userIndex);
            if (user.getWorkouts().remove(workoutName)) {
                saveUsers();
                logger.info("Workout unassigned successfully from user at index " + userIndex);
            } else {
                logger.warning("Workout not found for user at index " + userIndex);
            }
        } else {
            logger.severe("Invalid index for unassigning workout: " + userIndex);
            throw new IndexOutOfBoundsException("Índice inválido para desatribuir treino.");
        }
    }

    public void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
            writer.write("[");
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                writer.write("{");
                writer.write("\"name\":\"" + user.getName() + "\",");
                writer.write("\"age\":" + user.getAge() + ",");
                writer.write("\"height\":" + user.getHeight() + ",");
                writer.write("\"weight\":" + user.getWeight() + ",");
                writer.write("\"sex\":\"" + user.getSex() + "\",");
                writer.write("\"workoutsNamePath\":[");
                List<String> workouts = user.getWorkouts();
                for (int j = 0; j < workouts.size(); j++) {
                    writer.write("\"" + workouts.get(j) + "\"");
                    if (j < workouts.size() - 1) {
                        writer.write(",");
                    }
                }
                writer.write("]");
                writer.write("}");
                if (i < users.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
            logger.info("Users saved successfully.");
        } catch (IOException e) {
            logger.severe("Error saving users: " + e.getMessage());
        }
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            String jsonString = json.toString();
            if (!jsonString.isEmpty()) {
                jsonString = jsonString.substring(1, jsonString.length() - 1); // Remove brackets
                String[] userStrings = jsonString.split("\\},\\{");
                for (String userString : userStrings) {
                    userString = userString.replace("{", "").replace("}", "");
                    String[] fields = userString.split(",");
                    String name = fields[0].split(":")[1].replace("\"", "");
                    byte age = Byte.parseByte(fields[1].split(":")[1]);
                    float height = Float.parseFloat(fields[2].split(":")[1]);
                    float weight = Float.parseFloat(fields[3].split(":")[1]);
                    String sex = fields[4].split(":")[1].replace("\"", "");
                    List<String> workoutsNamePath = new ArrayList<>();
                    if (fields.length > 5) {
                        String workoutsString = fields[5].split(":")[1];
                        workoutsString = workoutsString.substring(1, workoutsString.length() - 1); // Remove brackets
                        String[] workouts = workoutsString.split(",");
                        for (String workout : workouts) {
                            workoutsNamePath.add(workout.replace("\"", ""));
                        }
                    }
                    User user = new User(name, age, height, weight, sex);
                    user.setWorkoutsNamePath(workoutsNamePath);
                    users.add(user);
                }
            }
            logger.info("Users loaded successfully.");
        } catch (FileNotFoundException e) {
            logger.warning("User file not found. Creating new file.");
        } catch (IOException e) {
            logger.severe("Error loading users: " + e.getMessage());
        }
    }
}