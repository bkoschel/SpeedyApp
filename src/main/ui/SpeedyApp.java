package ui;


import model.*;

import java.util.Scanner;

// the structure and some methods of this class were inspired by
// https://github.students.cs.ubc.ca/CPSC210/TellerApp

// This class represents an exercise logging application
public class SpeedyApp {
    private Scanner input;
    private ExerciseLog exerciseLog;
    private boolean exit;

    // EFFECTS: Runs the Speedy App
    SpeedyApp() {
        runSpeedy();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
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

    // MODIFIES: this
    // EFFECTS: initializes exercise log
    private void initiate() {
        exerciseLog = new ExerciseLog();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: display menu of options to user
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

    // MODIFIES: this
    // EFFECTS: processes user command
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

    // EFFECTS: displays all the exercises in the exercise log by title
    private void displayActivities() {
        System.out.println(exerciseLog.toString());
    }

    // MODIFIES: this
    // REQUIRES: user must correctly spell/enter which part of the activity they wish to edit
    // EFFECTS: adds an Exercise (swim, bike ride, or run) to the exercise log
    private void addActivity() {
        String activity;
        System.out.println("Was your activity a Swim, Bike Ride or Run?");
        activity = input.next().toLowerCase();
        if (activity.equals("swim")) {
            Swim swim = createNewSwim();
            exerciseLog.addExercise(swim);
        } else if (activity.equals("bike ride")) {
            Bike bike = createNewBike();
            exerciseLog.addExercise(bike);
        } else if (activity.equals("run")) {
            Run run = createNewRun();
            exerciseLog.addExercise(run);
        } else {
            System.out.println("Invalid Input");
        }

    }

    // MODIFIES: this
    // REQUIRES: user must format their inputs like the examples given for each part of
    //           an activity;
    // EFFECTS: constructs and returns a new swim
    private Swim createNewSwim() {
        Swim swim = new Swim();
        System.out.println("What is the title of your swim?");
        String title = input.next();
        swim.setTitle(title);
        System.out.println("What date did you complete your swim? Format as DD/MM/YYYY");
        String date = input.next();
        swim.setDate(date);
        System.out.println("How long was your swim? Format as HH:MM:SS");
        String duration = input.next();
        swim.setDuration(duration);
        System.out.println("What distance did you swim? Distance is recorded in kilometers. Format as 00.00");
        double distance = input.nextDouble();
        swim.setDistance(distance);
        System.out.println("What pace did you swim? Pace is recorded as min/km. Format as 00.00 ");
        double pace = input.nextDouble();
        swim.setPace(pace);
        return swim;
    }

    // MODIFIES: this
    // REQUIRES: user must format their inputs like the examples given for each part of
    //           an activity;
    // EFFECTS: constructs and returns a new Bike Ride
    private Bike createNewBike() {
        Bike bike = new Bike();
        System.out.println("What is the title of your bike ride?");
        String title = input.next();
        bike.setTitle(title);
        System.out.println("What date did you complete your bike ride? Format as DD/MM/YYYY");
        String date = input.next();
        bike.setDate(date);
        System.out.println("How long was your bike ride? Format as HH:MM:SS");
        String duration = input.next();
        bike.setDuration(duration);
        System.out.println("What distance did you ride? Distance is recorded in kilometers. Format as 00.00");
        double distance = input.nextDouble();
        bike.setDistance(distance);
        System.out.println("What pace was your bike ride? Pace is recorded in min/km. Format as 00.00");
        double pace = input.nextDouble();
        bike.setPace(pace);
        System.out.println("What elevation was your bike ride in meters? Format as an integer");
        int elevation = input.nextInt();
        bike.setElevation(elevation);
        return bike;
    }

    // MODIFIES: this
    // REQUIRES: user must format their inputs like the examples given for each part of
    //           an activity;
    // EFFECTS: constructs and returns a new Run
    private Run createNewRun() {
        Run run = new Run();
        System.out.println("What is the title of your run?");
        String title = input.next();
        run.setTitle(title);
        System.out.println("What date did you complete your run? Format as DD/MM/YYYY");
        String date = input.next();
        run.setDate(date);
        System.out.println("How long was your run? Format as HH:MM:SS");
        String duration = input.next();
        run.setDuration(duration);
        System.out.println("What distance did you run? Distance is recorded in kilometers. Format as 00.00");
        double distance = input.nextDouble();
        run.setDistance(distance);
        System.out.println("What pace was your run? Pace is recorded as min/km. Format as 00.00");
        double pace = input.nextDouble();
        run.setPace(pace);
        System.out.println("What elevation was your run in meters? Format as an integer");
        int elevation = input.nextInt();
        run.setElevation(elevation);
        return run;
    }


    // MODIFIES: this
    // REQUIRES: exercise log must contain activity (by title) you wish to edit
    //           user must correctly spell/enter which part of the activity they wish to edit
    // EFFECTS: changes the title, date, duration, distance, pace, or elevation of a chosen activity
    private void editActivity() {
        System.out.println(exerciseLog.toString());
        System.out.println("Please enter the title of the activity you would like to edit:");
        String title = input.next();
        Exercise exercise = exerciseLog.getExercise(title);
        System.out.println("Which feature do you wish to edit? (Title, Date, Duration, Distance, Pace, or Elevation)");
        String category = input.next().toLowerCase();
        if (category.equals("title")) {
            updateTitle(exercise);
        } else if (category.equals("date")) {
            updateDate(exercise);
        } else if (category.equals("duration")) {
            updateDuration(exercise);
        } else if (category.equals("distance")) {
            updateDistance(exercise);
        } else if (category.equals("pace")) {
            updatePace(exercise);
        } else if (category.equals("elevation")) {
            updateElevation(exercise);
        } else {
            System.out.println("Not a valid input. Try Again");
        }
        System.out.println("Activity Updated");
    }

    // MODIFIES: this
    // REQUIRES: user must format their inputs like the examples given for each part of
    //           an activity;
    // EFFECTS: changes the title of an activity and displays new title
    private void updateTitle(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Title:");
        String newTitle = input.next();
        exercise.setTitle(newTitle);
        System.out.println("New Title: " + newTitle);
    }

    // MODIFIES: this, exercise
    // REQUIRES: user must format their inputs like the examples given for each part of
    //           an activity;
    // EFFECTS: changes the date of an activity and displays new date
    private void updateDate(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Date: Format as DD/MM/YYYY");
        String newDate = input.next();
        exercise.setDate(newDate);
        System.out.println("New Date: " + newDate);
    }

    // MODIFIES: this, exercise
    // REQUIRES: user must format their inputs like the examples given for each part of
    //           an activity;
    // EFFECTS: changes the duration of an activity and displays new duration
    private void updateDuration(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Duration: Format as HH:MM:SS");
        String newDuration = input.next();
        exercise.setDuration(newDuration);
        System.out.println("New Duration: " + newDuration);
    }

    // MODIFIES: this, exercise
    // REQUIRES: user must format their inputs like the examples given for each part of
    //           an activity;
    // EFFECTS: changes the distance of an activity and displays the new distance
    private void updateDistance(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Distance: Format as 00.00");
        double newDistance = input.nextDouble();
        exercise.setDistance(newDistance);
        System.out.println("New Distance: " + newDistance);
    }

    // MODIFIES: this, exercise
    // REQUIRES: user must format their inputs like the examples given for each part of
    //           an activity;
    // EFFECTS: changes the pace of an activity and displays the new pace
    private void updatePace(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s " + "new Pace: Format as 00.00");
        double newPace = input.nextDouble();
        exercise.setPace(newPace);
        System.out.println("New Pace: " + newPace);
    }

    // MODIFIES: this, exercise
    // REQUIRES: user must format their inputs like the examples given for each part of
    //           an activity;
    // EFFECTS: changes the elevation of an activity and displays the new elevation
    private void updateElevation(Exercise exercise) {
        System.out.println("Input " + exercise.getTitle() + "'s" + "new Elevation: Format as an integer");
        int newElevation = input.nextInt();
        exercise.setElevation(newElevation);
        System.out.println("New Elevation: " + newElevation);
    }

    // REQUIRES: exercise log must contain the activity to be selected
    // EFFECTS: displays the activity chosen by title
    private void selectActivity() {
        System.out.println(exerciseLog.toString());
        System.out.println("Please enter the title of the activity you would like to view:");
        String title = input.next();
        System.out.println(exerciseLog.getExercise(title).toString());
    }

    // MODIFIES: this
    // REQUIRES: exercise log must contain at least one item; exercise log must contain item
    //           that the user wants to remove
    // EFFECTS: prompts the user to enter the title of an exercise to be removed; removes exercise
    private void removeActivity() {
        System.out.println(exerciseLog.toString());
        System.out.println("Please enter the title of the activity you would like to remove:");
        String title = input.next();
        Exercise exercise = exerciseLog.getExercise(title);
        exerciseLog.removeExercise(exercise);
        System.out.println(exerciseLog.toString());
    }

    // EFFECTS: displays total average pace, total distance, and total elevation for all activities
    //          displays average pace for swim, bike, and run activities in the exercise log
    //          displays total distance for swim, bike and run activities in the exercise log
    //          displays total elevation for bike and run for activities in the exercise log
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
