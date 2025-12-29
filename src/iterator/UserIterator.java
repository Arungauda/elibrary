package iterator;

import model.User;

import java.util.List;

public class UserIterator implements  LibraryIterator<User>{

    private final List<User> users;
    private int position = 0;

    public UserIterator(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean hasNext() {
        return position < users.size();
    }

    @Override
    public User next() {
        return users.get(position++);
    }
}
