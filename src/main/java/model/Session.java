package model;

public class Session {
    private static Session sessionSingleton = new Session();
    private User onlineUser;

    private Session() {}

    public static Session getSingletonInstance() {
        return sessionSingleton;
    }

    public User getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(User onlineUser) {
        this.onlineUser = onlineUser;
    }
}
