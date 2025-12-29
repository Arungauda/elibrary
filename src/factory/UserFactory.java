package factory;

import model.Librarian;
import model.Member;
import model.User;

public class UserFactory {

    public static User createUser(String role, String id, String name) {
        if ("MEMBER".equalsIgnoreCase(role)) {
            return new Member(id, name);
        } else if ("LIBRARIAN".equalsIgnoreCase(role)) {
            return new Librarian(id, name);
        }
        throw new IllegalArgumentException("Invalid user role");
    }
}
