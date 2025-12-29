package model;

public class Member extends  User{

    public Member(String id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "MEMBER";
    }
}
