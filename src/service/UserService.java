package treinotrack.service;

import treinotrack.data.UserRepository;
import treinotrack.data.models.User;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserService {
    private UserRepository userRepository;
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public void createUser(String name, byte age, float height, float weight, String sex) {
        User newUser = new User(name, age, height, weight, sex);
        userRepository.addUser(newUser);
    }


    public List<User> readUsers() {
        return userRepository.getUsers();
    }

    public void updateUser(int index, User updatedUser) {
        List<User> users = userRepository.getUsers();
        if (index >= 0 && index < users.size()) {
            users.set(index, updatedUser);
            userRepository.saveUsers(); // Save the updated list of users
            logger.info("User updated successfully at index " + index);
        } else {
            logger.severe("Invalid index for updating user: " + index);
            throw new IndexOutOfBoundsException("Índice inválido para atualização de usuário.");
        }
    }

    public User getUserByIndex(int index) {
        List<User> users = userRepository.getUsers();
        if (index >= 0 && index < users.size()) {
            return users.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid user index");
        }
    }
    public void assignWorkoutToUser(int userIndex, String workoutName) {
        userRepository.assignWorkoutToUser(userIndex, workoutName);
    }

    public void unassignWorkoutFromUser(int userIndex, String workoutName) {
        userRepository.unassignWorkoutFromUser(userIndex, workoutName);
    }
    public void deleteUser(int index) {
        List<User> users = userRepository.getUsers();
        if (index >= 0 && index < users.size()) {
            users.remove(index);
            userRepository.saveUsers();
        } else {
            throw new IndexOutOfBoundsException("Invalid user index");
        }
    }


    public void saveUsers() {
        userRepository.saveUsers();
    }

}
