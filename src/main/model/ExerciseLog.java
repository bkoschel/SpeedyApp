package model;

import java.util.ArrayList;
import java.util.List;

public class ExerciseLog {
    private List<Exercise> exercises;

    // EFFECTS: creates an ArrayList for exercises to be stored in
    public ExerciseLog() {
        exercises = new ArrayList<>();
    }

    // MODIFIES: this
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    // REQUIRES: there must be at least one exercise in the list of exercises
    // MODIFIES: this
    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }

    // EFFECTS: returns True if an exercise is present in a list of exercises
    public boolean containsExercise(Exercise exercise) {
        return exercises.contains(exercise);
    }

    public Exercise getExercise(int i) {
        return exercises.get(i);
    }

    // !!!!! implement Exercises!
    public String toString() {
        String exerciseLog = ""; // USE STRING BUILDER
        for (int i = 0; i < exercises.size(); i++) {
            exercises.get(i).getTitle();
        }
        return exerciseLog;
    }

    public double sumTotalDistance() {
        double totalDistance = 0.0;
        for (int i = 0; i < exercises.size(); i++) {
            totalDistance += exercises.get(i).getDistance();
        }
        return totalDistance; // stub
    }

    // !! USE STRING/INTEGER PARSING
    public String sumTotalDuration() {
        return ""; // stub
    }

    public double averageTotalPace() {
        double averagePace = 0;
        for (int i = 0; i < exercises.size(); i++) {
            averagePace += exercises.get(i).getPace();
        }
        return averagePace / exercises.size();
    }

    public int sumTotalElevation() {
        int totalElevation = 0;
        for (int i = 0; i < exercises.size(); i++) {
            totalElevation += exercises.get(i).getElevation();
        }
        return totalElevation;
    }


    public double averageBikePace() {
        double bikePace = 0.0;
        int num = 0;
        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getClass() == Bike.class) {
                bikePace += exercises.get(i).getPace();
                num++;
            }
        }
        return bikePace / num;
    }


    public double averageRunPace() {
        double runPace = 0.0;
        int num = 0;
        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getClass() == Run.class) {
                runPace += exercises.get(i).getPace();
                num++;
            }
        }
        return runPace / num;
    }


    public double averageSwimPace() {
        double swimPace = 0.0;
        int num = 0;
        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getClass() == Swim.class) {
                swimPace += exercises.get(i).getPace();
                num++;
            }
        }
        return swimPace / num;
    }

}
