package treinotrack.service;

import treinotrack.data.UserRepository;
import treinotrack.models.User;
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

    private float getValidFloat(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next();
            }
        }
    }

    /*
    public void readUsers() {
        if (userRepository.getUsers().isEmpty()) {
            System.out.println("Não há usuários.");
            return;
        }
        System.out.println("Lista de Usuários:");
        for (int i = 0; i < userRepository.getUsers().size(); i++) {
            User user = userRepository.getUsers().get(i);
            System.out.println("\nÍndice: " + i
                + "\nNome: " + user.getName()
                + "\nIdade: " + user.getAge()
                + "\nAltura: " + user.getHeight()
                + "\nPeso: " + user.getWeight()
                + "\nIMC: " + user.getImc()
                );
        }
    }
    */
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

    /*
    public void deleteUser(int index) {
        if (userRepository.getUsers().isEmpty()) {
            System.out.println("Não há usuários a serem deletados.");
            return;
        }
        if (index >= 0 && index < userRepository.getUsers().size()) {
            userRepository.getUsers().remove(index);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Índice inválido!");
        }
    }
*/
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
