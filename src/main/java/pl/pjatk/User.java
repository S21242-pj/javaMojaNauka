package pl.pjatk;

public class User {

    private String userFirstName;
    private String userLastName;
    private int userId;


    public User(String userFirstName, String userLastName, int userId) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userId = userId;
    }


    public String getUserFirstName() {
        return userFirstName;
    }


    public String getUserLastName() {
        return userLastName;
    }


    public int getUserId() {
        return userId;
    }


    @Override
    public String toString() {
        return "User{" +
                "userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
