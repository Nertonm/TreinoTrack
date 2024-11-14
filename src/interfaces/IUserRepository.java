package treinotrack.interfaces;

import treinotrack.models.User;
import java.util.List;

public interface IUserRepository {
    List<User> getUsers();
    void addUser(User user);
    void saveUsers();
    void updateUser(int index, User user);
    void deleteUser(int index);
}