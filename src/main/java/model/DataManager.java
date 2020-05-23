package model;

import java.io.*;
import java.util.ArrayList;

public class DataManager {
    private static File usersSer;

    public static void initializeFiles() throws IOException {
        if (new File("data").mkdir()) {
            System.out.println("data folder created.");
        } else {
            System.out.println("checking available data folders ...");
        }
        usersSer = new File("data/users.ser");
        if (!usersSer.exists()) {
            updateUsers(new ArrayList<>());
            System.out.println("users file created.");
        } else {
            System.out.println("users file already exist.");
        }
    }

    public static void updateUsers(ArrayList<User> userArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(usersSer);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(userArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static ArrayList<User> getUsersSer() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(usersSer);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<User> usersArrayList = (ArrayList<User>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return usersArrayList;
    }

    public static void addUser(User user) throws IOException, ClassNotFoundException {
        ArrayList<User> users = getUsersSer();
        users.add(user);
        updateUsers(users);
    }

    public static User getUserByUsername(String username) throws IOException, ClassNotFoundException {
        ArrayList<User> users = getUsersSer();
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
}
