package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExercisesTest {
    private Swim swim;
    private Bike bike;
    private Run run;

    private ExerciseLog exerciseLog;

    @BeforeEach
    void setUp() {
        swim = new Swim();
        bike = new Bike();
        run = new Run();

        exerciseLog = new ExerciseLog();
    }

    @Test
    public void testAddExercise() {
        assertFalse(exerciseLog.containsExercise(swim));
        exerciseLog.addExercise(swim);
        assertTrue(exerciseLog.containsExercise(swim));
    }

    @Test
    public void testContainsExercise() {
        assertFalse(exerciseLog.containsExercise(bike));
        assertFalse(exerciseLog.containsExercise(run));
        exerciseLog.addExercise(bike);
        exerciseLog.addExercise(run);
        assertTrue(exerciseLog.containsExercise(bike));
        assertTrue(exerciseLog.containsExercise(run));
        assertFalse(exerciseLog.containsExercise(swim));
    }

    @Test
    public void testRemoveExercise() {
        exerciseLog.addExercise(swim);
        exerciseLog.addExercise(bike);
        assertTrue(exerciseLog.containsExercise(bike));
        assertTrue(exerciseLog.containsExercise(swim));
        exerciseLog.removeExercise(swim);
        assertFalse(exerciseLog.containsExercise(swim));
        exerciseLog.removeExercise(bike);
        assertFalse(exerciseLog.containsExercise(bike));
    }

}
