package treinotrack.data;

import treinotrack.models.User;
import java.io.*;
import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users;

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

    public void deleteUser(int i) {
        if(i >= 0 && i <users.size()){
            users.remove(i);
            saveUsers();
        }

    }

    public void saveUsers(){
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.dat"));
            output.writeObject(users);
        } catch (IOException e) {
           System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            users = (ArrayList<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de usuários não encontrado. Criando novo arquivo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }
}
