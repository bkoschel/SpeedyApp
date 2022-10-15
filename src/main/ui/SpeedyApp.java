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

    SpeedyApp() {
        runSpeedy();
    }

    private void runSpeedy() {
        exit = false;
        String command = null;
        
        initiate();
        
        while (!exit) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("x")) {
                exit = true;
            } else {
                processInput(command);
            }
        }
        System.out.println("Thanks for Exercising");
    }

    private void initiate() {
        exerciseLog = new ExerciseLog();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tv -> View Exercise Log");
        System.out.println("\ta -> Add Activity to Exercise Log");
        System.out.println("\tr -> Remove Activity From Exercise Log");
        System.out.println("\te -> Edit Activity");
        System.out.println("\tx -> Exit");
    }

    private void processInput(String command) {
        if (command.equals("v")) {
            displayActivities();
        } else if (command.equals("a")) {
            addActivity();
        } else if (command.equals("r")) {
            removeActivity();
        } else if (command.equals("e")) {
            editActivity();
        } else if (command.equals("b")) {
            goBack();
        } else if (command.equals("x")) {
            exit = true;
        } else {
            System.out.println("Invalid Selection");
        }
    }

    private void displayActivities() {
        exerciseLog.toString();
    }

    private void addActivity() {
        String activity;
        Swim swim;
        Bike bike;
        Run run;
        System.out.println("Was your activity a Swim, Bike Ride or Run?");
        activity = input.next();
        if (activity.equals("Swim")) {
            swim = new Swim();
        } else if (activity.equals("Bike Ride")) {
            bike = new Bike();
        } else if (activity.equals("Run")) {
            run = new Run();
        }
    }

    private void goBack() {
    }

    private void editActivity() {
    }

    private void selectActivity() {
        String selection = "";


    }

    private void removeActivity() {
    }



}
