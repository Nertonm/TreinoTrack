package treinotrack.facades;

import treinotrack.models.User;
import treinotrack.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.logging.Logger;

public class UserFacade {
    private final UserService userService;
    private static final Logger logger = Logger.getLogger(UserFacade.class.getName());

    public UserFacade(UserService userService) {
        this.userService = userService;
    }

    public User readUserByIndex(int index) {
        try {
            User user = userService.getUserByIndex(index);
            logger.info("User read successfully.");
            return user;
        } catch (Exception e) {
            logger.severe("Error reading user: " + e.getMessage());
            throw e;
        }
    }

    public void createUser(String name, byte age, float height, float weight, String sex) {
        try {
            userService.createUser(name, age, height, weight, sex);
            logger.info("User created successfully.");
        } catch (Exception e) {
            logger.severe("Error creating user: " + e.getMessage());
        }
    }

    public List<User> readUsers() {
        try {
            List<User> users = userService.readUsers();
            logger.info("Users read successfully.");
            return users;
        } catch (Exception e) {
            logger.severe("Error reading users: " + e.getMessage());
            throw e;
        }
    }

    public void updateUser(int index, String name, byte age, float height, float weight, String sex) {
        try {
            userService.updateUser(index, name, age, height, weight, sex);
            logger.info("User updated successfully.");
        } catch (Exception e) {
            logger.severe("Error updating user: " + e.getMessage());
        }
    }

    public void deleteUser(int index) {
        try {
            userService.deleteUser(index);
            logger.info("User deleted successfully.");
        } catch (Exception e) {
            logger.severe("Error deleting user: " + e.getMessage());
            throw e;
        }
    }

    public List<User> getUsers() {
        try {
            List<User> users = userService.getUsers();
            logger.info("Users retrieved successfully.");
            return users;
        } catch (Exception e) {
            logger.severe("Error retrieving users: " + e.getMessage());
            throw e;
        }
    }

    public void saveUsers() {
        try {
            userService.saveUsers();
            logger.info("Users saved successfully.");
        } catch (Exception e) {
            logger.severe("Error saving users: " + e.getMessage());
        }
    }
}