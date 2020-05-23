package model;

import model.User;

import java.io.*;
import java.util.ArrayList;

public class DataManager {
    private static File users;

    public static void initializeFiles() throws IOException {
        if (new File("data").mkdir()) {
            System.out.println("data folder created.");
        } else {
            System.out.println("checking available data folders ...");
        }
        users = new File("data/users");
        if (!users.exists()) {
            updateUsers(new ArrayList<User>());
            System.out.println("users file created.");
        } else {
            System.out.println("users file already exist.");
        }
    }

    public static void updateUsers(ArrayList<User> userArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(users);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(userArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static ArrayList<User> getUsers() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(users);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<User> usersArrayList = (ArrayList<User>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return usersArrayList;
    }

    public static void addUser(User user) throws IOException, ClassNotFoundException {
        ArrayList<User> users = getUsers();
        users.add(user);
        updateUsers(users);
    }
}
