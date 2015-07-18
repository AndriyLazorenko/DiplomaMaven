package View.Runnable;

import Controller.Service;

import java.io.IOException;

public class MainDiploma {
    public static void main(String[] args) throws IOException {
        Service inter = new Service();
        inter.consoleMenu();
    }
}
