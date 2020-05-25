package model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private int win;
    private int draw;
    private int resignLose;
    private int resignWin;
    private int winSum;
    private int loseSum;
    private int score;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        score = win * 3 + resignWin * 2 + draw - resignLose;
        return score;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getResignLose() {
        return resignLose;
    }

    public void setResignLose(int resignLose) {
        this.resignLose = resignLose;
    }

    public int getResignWin() {
        return resignWin;
    }

    public void setResignWin(int resignWin) {
        this.resignWin = resignWin;
    }

    public int getWinSum() {
        return winSum;
    }

    public void setWinSum(int winSum) {
        this.winSum = winSum;
    }

    public int getLoseSum() {
        return loseSum;
    }

    public void setLoseSum(int loseSum) {
        this.loseSum = loseSum;
    }

    public void addWin() {
        ++win;
        ++winSum;
    }

    public void addLose() {
        ++loseSum;
    }

    public void addResignWin() {
        ++resignWin;
        ++winSum;
    }

    public void addResignLose() {
        ++resignLose;
        ++loseSum;
    }

    public void addDraw() {
        ++draw;
    }
}
