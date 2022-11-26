package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.JsonWriter;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// tha can be used to perform operations on a list of exercises such as addExercise and removeExercise
// Some methods used in this class were inspired by methods in JsonSerialization program
// GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Exercise log represents a list of exercises (biking, running, and swimming) and the methods
public class ExerciseLog implements Writable {
    private final List<Exercise> exercises;

    // EFFECTS: creates an ArrayList for exercises to be stored in
    public ExerciseLog() {
        exercises = new ArrayList<>();
    }

    // MODIFIES: this
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        EventLog.getInstance().logEvent(new Event(exercise.getTitle() + " was added to the exercise log."));
    }

    // REQUIRES: there must be at least one exercise in the list of exercises
    // MODIFIES: this
    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
        EventLog.getInstance().logEvent(new Event(exercise.getTitle() + " was removed to the exercise log."));

    }

    // EFFECTS: returns True if an exercise is present in a list of exercises
    public boolean containsExercise(Exercise exercise) {
        return exercises.contains(exercise);
    }

    // REQUIRES: assumes all the exercises have different names, and that the list contains the exercise
    // EFFECTS: finds the exercise of a given String title and returns the Exercise Object
    public Exercise getExercise(String title) {
        Exercise e = null;
        for (Exercise exercise : exercises) {
            if (exercise.getTitle().equals(title)) {
                e = exercise;
            }
        }
        return e;
    }

    // EFFECTS: returns a string version of all the exercises in the exercise log
    //          if the list is empty it just prints out "My Activities"
    public String toString() {
        StringBuilder exerciseLog =  new StringBuilder("My Activities: \n");
        for (Exercise exercise : exercises) {
            exerciseLog.append(exercise.getTitle()).append("\n");
        }
        return exerciseLog.toString();
    }

    // EFFECTS: returns the sum of all the exercise distances in an exercise log
    public double sumTotalDistance() {
        double totalDistance = 0.0;
        for (Exercise exercise : exercises) {
            totalDistance += exercise.getDistance();
        }
        return totalDistance;
    }

    // EFFECTS: returns the average of all the exercise Paces in an exercise log
    public double averageTotalPace() {
        double averagePace = 0;
        for (Exercise exercise : exercises) {
            averagePace += exercise.getPace();
        }
        return averagePace / exercises.size();
    }

    // EFFECTS: returns the sum of all the elevation data in an exercise log
    public int sumTotalElevation() {
        int totalElevation = 0;
        for (Exercise exercise : exercises) {
            totalElevation += exercise.getElevation();
        }
        return totalElevation;
    }

    // EFFECTS: returns the average pace for all bike rides in an exercise log
    public double averageBikePace() {
        double bikePace = 0.0;
        int num = 0;
        for (Exercise exercise : exercises) {
            if (exercise.getClass() == Bike.class) {
                bikePace += exercise.getPace();
                num++;
            }
        }
        return bikePace / num;
    }

    // EFFECTS: returns the average run pace for all runs in an exercise log
    public double averageRunPace() {
        double runPace = 0.0;
        int num = 0;
        for (Exercise exercise : exercises) {
            if (exercise.getClass() == Run.class) {
                runPace += exercise.getPace();
                num++;
            }
        }
        return runPace / num;
    }

    // EFFECTS: returns the average pace for all swims in an exercise log
    public double averageSwimPace() {
        double swimPace = 0.0;
        int num = 0;
        for (Exercise exercise : exercises) {
            if (exercise.getClass() == Swim.class) {
                swimPace += exercise.getPace();
                num++;
            }
        }
        return swimPace / num;
    }

    // EFFECTS: returns the total distance for all bike rides in an exercise log
    public double totalBikeDistance() {
        double totalBikeDistance = 0.0;
        for (Exercise exercise : exercises) {
            if (exercise.getClass() == Bike.class) {
                totalBikeDistance += exercise.getDistance();

            }
        }
        return totalBikeDistance;
    }

    // EFFECTS: returns the total distance for all swims in an exercise log
    public double totalSwimDistance() {
        double totalSwimDistance = 0.0;
        for (Exercise exercise : exercises) {
            if (exercise.getClass() == Swim.class) {
                totalSwimDistance += exercise.getDistance();

            }
        }
        return totalSwimDistance;
    }

    // EFFECTS: returns the total distance for all runs in an exercise log
    public double totalRunDistance() {
        double totalRunDistance = 0.0;
        for (Exercise exercise : exercises) {
            if (exercise.getClass() == Run.class) {
                totalRunDistance += exercise.getDistance();

            }
        }
        return totalRunDistance;
    }

    // EFFECTS: returns the total elevation gained for all runs in an exercise log
    public double totalRunElevation() {
        double totalRunElevation = 0.0;
        for (Exercise exercise : exercises) {
            if (exercise.getClass() == Run.class) {
                totalRunElevation += exercise.getElevation();

            }
        }
        return totalRunElevation;
    }

    // EFFECTS: returns the total elevation gained for all bike rides in an exercise log
    public double totalBikeElevation() {
        double totalBikeElevation = 0.0;
        for (Exercise exercise : exercises) {
            if (exercise.getClass() == Bike.class) {
                totalBikeElevation += exercise.getElevation();

            }
        }
        return totalBikeElevation;
    }

    // EFFECTS: returns the size of the exercise log
    public int getExerciseLogSize() {
        return exercises.size();
    }

    // EFFECTS: returns a list of exercises;
    public List<Exercise> getExerciseLog() {
        return exercises;
    }

    // EFFECTS: returns a JSONObject representing the exercise log
    // toJson was inspired by the toJson method from JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exercises", exercisesToJson());
        return jsonObject;
    }

    // EFFECTS: returns a JSONArray of exercises in the exercise log
    // toJson was inspired by the thingiesToJson method from JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Exercise e : exercises) {
            jsonArray.put(e.toJson());
        }
        return jsonArray;
    }

}
