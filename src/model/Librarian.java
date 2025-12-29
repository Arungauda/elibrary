package model;

public class Librarian extends  User{


    public Librarian(String id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "LIBRARIAN";
    }
}
