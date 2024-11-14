package treinotrack.data;

import treinotrack.interfaces.IUserRepository;
import treinotrack.models.User;

import java.io.*;
import java.util.ArrayList;

public class UserRepository implements IUserRepository {
    private ArrayList<User> users;
    private static final String FILE_NAME = "users.json";

    public UserRepository() {
        users = new ArrayList<>();
        loadUsers();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public void updateUser(int index, User updatedUser) {
        if (index >= 0 && index < users.size()) {
            users.set(index, updatedUser);
            saveUsers();
        } else {
            throw new IndexOutOfBoundsException("Índice inválido para atualização de usuário.");
        }
    }

    @Override
    public void deleteUser(int i) {
        if(i >= 0 && i <users.size()){
            users.remove(i);
            saveUsers();
        }
    }

    @Override
    public void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("[");
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                writer.write("{");
                writer.write("\"name\":\"" + user.getName() + "\",");
                writer.write("\"age\":" + user.getAge() + ",");
                writer.write("\"height\":" + user.getHeight() + ",");
                writer.write("\"weight\":" + user.getWeight() + ",");
                writer.write("\"sex\":\"" + user.getSex() + "\"");
                writer.write("}");
                if (i < users.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
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
                    users.add(new User(name, age, height, weight, sex));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de usuários não encontrado. Criando novo arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }
}