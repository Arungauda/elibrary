package registry;

import iterator.LibraryIterator;
import iterator.UserIterator;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRegistry {

    private static UserRegistry instance;
    private static final List<User> users = new ArrayList<>();

    private UserRegistry() {}

    public static synchronized UserRegistry getInstance() {
        if (instance == null) {
            instance = new UserRegistry();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
    public LibraryIterator<User> createIterator() {
        return new UserIterator(users);
    }
}
