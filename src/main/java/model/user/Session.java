package model.user;

import model.game.Game;

public class Session {
    private static final Session sessionSingleton = new Session();
    private User onlineUser;
    private Game runningGame;

    public static Session getSingletonInstance() {
        return sessionSingleton;
    }

    public User getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(User onlineUser) {
        this.onlineUser = onlineUser;
    }

    public Game getRunningGame() {
        return runningGame;
    }

    public void setRunningGame(Game runningGame) {
        this.runningGame = runningGame;
    }

    private Session() {}
}
