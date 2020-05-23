import model.DataManager;
import view.GraphicalUserInterface;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        DataManager.initializeFiles();
        GraphicalUserInterface.runGui(args);
    }
}
