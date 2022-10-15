package ui;


import model.*;

import java.util.Scanner;

public class SpeedyApp {
    private Scanner input;
    private ExerciseLog exerciseLog;
    private Exercise user;
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
        System.out.println(exerciseLog.toString());
    }

    private void addActivity() {
        String activity;
        System.out.println("Was your activity a Swim, Bike Ride or Run?");
        activity = input.next();
        if (activity.equals("Swim")) {
            Swim swim = createNewSwim();
            exerciseLog.addExercise(swim);
        } else if (activity.equals("Bike Ride")) {
            Bike bike = createNewBike();
            exerciseLog.addExercise(bike);
        } else if (activity.equals("Run")) {
            Run run = createNewRun();
            exerciseLog.addExercise(run);
        }

    }


    private Swim createNewSwim() {
        Swim swim = new Swim();
        System.out.println("What is the title of your swim?");
        String title = input.next();
        swim.setTitle(title);
        System.out.println("What date did you complete your swim? DD/MM/YYYY");
        String date = input.next();
        swim.setDate(date);
        System.out.println("How long was your swim? HH:MM:SS");
        String duration = input.next();
        swim.setDuration(duration);
        System.out.println("What distance did you swim? 00.00 km");
        Double distance = input.nextDouble();
        swim.setDistance(distance);
        System.out.println("What pace did you swim? 00.00 min/km");
        Double pace = input.nextDouble();
        swim.setPace(pace);
        return swim;
    }

    private Bike createNewBike() {
        Bike bike = new Bike();
        System.out.println("What is the title of your bike ride?");
        String title = input.next();
        bike.setTitle(title);
        System.out.println("What date did you complete your bike ride? DD/MM/YYYY");
        String date = input.next();
        bike.setDate(date);
        System.out.println("How long was your bike ride? HH:MM:SS");
        String duration = input.next();
        bike.setDuration(duration);
        System.out.println("What distance did you ride? 00.00 km");
        double distance = input.nextDouble();
        bike.setDistance(distance);
        System.out.println("What pace was your bike ride? 00.00 min/km");
        double pace = input.nextDouble();
        bike.setPace(pace);
        System.out.println("What elevation was your bike ride in meters? ");
        int elevation = input.nextInt();
        bike.setElevation(elevation);
        return bike;
    }

    private Run createNewRun() {
        Run run = new Run();
        System.out.println("What is the title of your run?");
        String title = input.next();
        run.setTitle(title);
        System.out.println("What date did you complete your run? DD/MM/YYYY");
        String date = input.next();
        run.setDate(date);
        System.out.println("How long was your run? HH:MM:SS");
        String duration = input.next();
        run.setDuration(duration);
        System.out.println("What distance did you run? 00.00 km");
        double distance = input.nextDouble();
        run.setDistance(distance);
        System.out.println("What pace was your run? 00.00 min/km");
        double pace = input.nextDouble();
        run.setPace(pace);
        System.out.println("What elevation was your run in meters?");
        int elevation = input.nextInt();
        run.setElevation(elevation);
        return run;
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
