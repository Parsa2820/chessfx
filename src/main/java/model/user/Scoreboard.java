package model.user;

import model.DataManager;

import java.io.IOException;
import java.util.ArrayList;

public class Scoreboard {

    public static ArrayList<User> getSortedScoreBoard() throws IOException, ClassNotFoundException {
        ArrayList<User> users = DataManager.getUsers();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.size()-1; j++) {
                if (users.get(j).getScore() < users.get(j+1).getScore()) {
                    swapArrayListMemberWithRightOne(users, j);
                } else if (users.get(j).getScore() == users.get(j+1).getScore()) {
                    if (users.get(j).getWinSum() < users.get(j+1).getWinSum()) {
                        swapArrayListMemberWithRightOne(users, j);
                    } else if (users.get(j).getWinSum() == users.get(j+1).getWinSum()) {
                        if (users.get(j).getDraw() < users.get(j+1).getDraw()) {
                            swapArrayListMemberWithRightOne(users, j);
                        } else if (users.get(j).getDraw() == users.get(j+1).getDraw()) {
                            if (users.get(j).getLoseSum() > users.get(j+1).getLoseSum()) {
                                swapArrayListMemberWithRightOne(users, j);
                            } else if (users.get(j).getLoseSum() == users.get(j+1).getLoseSum()) {
                                if (users.get(j).getUsername().compareTo(users.get(j+1).getUsername()) > 0) {
                                    swapArrayListMemberWithRightOne(users, j);
                                }
                            }
                        }
                    }
                }
            }
        }
        return users;
    }

    private static void swapArrayListMemberWithRightOne(ArrayList<User> users, int index) {
        User tmpUser = users.get(index);
        users.set(index, users.get(index+1));
        users.set(index+1, tmpUser);
    }
}
