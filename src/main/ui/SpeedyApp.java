package ui;


import model.*;

import java.util.Scanner;

public class SpeedyApp {
    private Scanner input;
    private ExerciseLog exerciseLog;
    private boolean exit;

    SpeedyApp() {
        runSpeedy();
    }

    private void runSpeedy() {
        exit = false;
        String command;
        
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
        System.out.println("\ts -> Select Activity by Name");
        System.out.println("\tt -> View Stats");
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
        } else if (command.equals("s")) {
            selectActivity();
        }  else if (command.equals("t")) {
            viewStats();
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
        double distance = input.nextDouble();
        swim.setDistance(distance);
        System.out.println("What pace did you swim? 00.00 min/km");
        double pace = input.nextDouble();
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


// Assumes that activity exists
    private void editActivity() {
        System.out.println("Please enter the title of the activity you would like to edit:");
        String title = input.next();
        Exercise exercise = exerciseLog.getExercise(title);
        System.out.println("Which feature do you wish to edit? (Title, Date, Duration, Distance, Pace, or Elevation)");
        String category = input.next();
        if (category.equals("Title")) {
            updateTitle(exercise);
        } else if (category.equals("Date")) {
            updateDate(exercise);
        } else if (category.equals("Duration")) {
            updateDuration(exercise);
        } else if (category.equals("Distance")) {
            updateDistance(exercise);
        } else if (category.equals("Pace")) {
            updatePace(exercise);
        } else if (category.equals("Elevation")) {
            updateElevation(exercise);
        }
        System.out.println("Activity Updated");
    }

    private void updateTitle(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Title:");
        String newTitle = input.next();
        exercise.setTitle(newTitle);
        System.out.println("New Title: " + newTitle);
    }

    private void updateDate(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Date: DD/MM/YYYY");
        String newDate = input.next();
        exercise.setDate(newDate);
        System.out.println("New Date: " + newDate);
    }

    private void updateDuration(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Duration: HH:MM:SS");
        String newDuration = input.next();
        exercise.setDuration(newDuration);
        System.out.println("New Duration: " + newDuration);
    }

    private void updateDistance(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Distance: 0.0 km");
        double newDistance = input.nextDouble();
        exercise.setDistance(newDistance);
        System.out.println("New Distance: " + newDistance);
    }

    private void updatePace(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Pace: 0.0 min/km");
        double newPace = input.nextDouble();
        exercise.setPace(newPace);
        System.out.println("New Pace: " + newPace);
    }

    private void updateElevation(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s" + "new Elevation: meters");
        int newElevation = input.nextInt();
        exercise.setElevation(newElevation);
        System.out.println("New Elevation: " + newElevation);
    }

    private void selectActivity() {
        System.out.println(exerciseLog.toString());
        System.out.println("Please enter the title of the activity you would like to view:");
        String title = input.next();
        System.out.println(exerciseLog.getExercise(title).toString());
    }

    private void removeActivity() {
        System.out.println(exerciseLog.toString());
        System.out.println("Please enter the title of the activity you would like to remove:");
        String title = input.next();
        Exercise exercise = exerciseLog.getExercise(title);
        exerciseLog.removeExercise(exercise);
        System.out.println(exerciseLog.toString());
    }

    private void viewStats() {
        System.out.println("Total Average Pace For All Activities: " + exerciseLog.averageTotalPace());
        System.out.println("Total Distance Covered For All Activities: " + exerciseLog.sumTotalDistance());
        System.out.println("Total Elevation For All Activities: " + exerciseLog.sumTotalElevation());
        System.out.println("Average Swimming Pace: " + exerciseLog.averageSwimPace());
        System.out.println("Total Swimming Distance: " + exerciseLog.totalSwimDistance());
        System.out.println("Average Biking Pace: " + exerciseLog.averageBikePace());
        System.out.println("Total Biking Distance: " + exerciseLog.totalBikeDistance());
        System.out.println("Total Biking Elevation: " + exerciseLog.totalBikeElevation());
        System.out.println("Average Running Pace: " + exerciseLog.averageRunPace());
        System.out.println("Total Running Distance: " + exerciseLog.totalRunDistance());
        System.out.println("Total Running Elevation: " + exerciseLog.totalRunElevation());
    }

}
