package ui;


import model.Bike;
import model.ExerciseLog;
import model.Run;
import model.Swim;

import java.util.Scanner;

public class SpeedyApp {
    private Scanner input;
    private ExerciseLog exerciseLog;
    private Bike bike;
    private Swim swim;
    private Run run;
    private boolean exit;
    String command;

    SpeedyApp() {
        runSpeedy();
    }

    private void runSpeedy() {
        exit = false;
        
        initiate();
        
        while (!exit) {
            displayMenu();
            command = input.next();
            processInput(command);
        }
        System.out.println("Thanks for Exercising");
    }

    private void processInput(String command) {
    }

    private void displayMenu() {
    }

    private void initiate() {
        exerciseLog = new ExerciseLog();
    }
}
