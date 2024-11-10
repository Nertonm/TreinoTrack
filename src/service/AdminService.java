package treinotrack.service;

import  treinotrack.data.*;
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<User> users;
    private List<Exercise> exercises;

    public Admin() {
        this.users = new ArrayList<>();
        this.exercises = new ArrayList<>();
    }

    // User management methods
    public void createNewUser(User user) {
        users.add(user);
        System.out.println("User created: " + user.getName());
    }

    public void readUserList() {
        System.out.println("User List:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void updateUser(int userId, User updatedUser) {
        for (User user : users) {
            if (user.getId() == userId) {
                user.setName(updatedUser.getName());
                System.out.println("User updated: " + user.getName());
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void deleteUser(int userId) {
        users.removeIf(user -> user.getId() == userId);
        System.out.println("User deleted.");
    }

    // Exercise management methods
    public void createNewExercise(Exercise exercise) {
        exercises.add(exercise);
        System.out.println("Exercise created: " + exercise.getName());
    }

    public void readExerciseList() {
        System.out.println("Exercise List:");
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
    }

    public void updateExercise(int exerciseId, Exercise updatedExercise) {
        for (Exercise exercise : exercises) {
            if (exercise.getId() == exerciseId) {
                exercise.setName(updatedExercise.getName());
                System.out.println("Exercise updated: " + exercise.getName());
                return;
            }
        }
        System.out.println("Exercise not found.");
    }

    public void deleteExercise(int exerciseId) {
        exercises.removeIf(exercise -> exercise.getId() == exerciseId);
        System.out.println("Exercise deleted.");
    }
}