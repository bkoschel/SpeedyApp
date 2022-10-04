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

}
