package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExercisesTest {
    private Exercise swim;
    private Exercise bike;
    private Exercise run;
    private Exercise bike2;

    private ExerciseLog exerciseLog;

    @BeforeEach
    void setUp() {
        swim = new Swim();
        bike = new Bike();
        run = new Run();
        bike2 = new Bike();

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

    /*
    @Test
    public void testToString() {
        exerciseLog.addExercise(swim);
        exerciseLog.addExercise(bike);
        exerciseLog.addExercise(run);
        assertEquals("swim bike run", exerciseLog.toString());
    }

     */

    @Test
    public void testSumTotalDistance() {
        swim.setDistance(3.0);
        bike.setDistance(2.0);
        run.setDistance(5.0);
        exerciseLog.addExercise(swim);
        exerciseLog.addExercise(bike);
        exerciseLog.addExercise(run);
        assertEquals(10.0, exerciseLog.sumTotalDistance());
    }

    /*
    @Test
    public void testSumTotalDuration() {
        swim.setDuration("01:00:00");
        bike.setDuration("02:00:00");
        run.setDuration("03:00:00");
        exerciseLog.addExercise(swim);
        exerciseLog.addExercise(bike);
        exerciseLog.addExercise(run);
        assertEquals("06:00:00", exerciseLog.sumTotalDuration());
    }
     */

    @Test
    public void testSumTotalElevation() {
        bike2.setElevation(3);
        bike.setElevation(2);
        run.setElevation(5);
        exerciseLog.addExercise(bike2);
        exerciseLog.addExercise(bike);
        exerciseLog.addExercise(run);
        assertEquals(10, exerciseLog.sumTotalElevation());
    }

    @Test
    public void testTotalAveragePace() {
        swim.setPace(5.0);
        bike.setPace(2.0);
        run.setPace(5.0);
        exerciseLog.addExercise(swim);
        exerciseLog.addExercise(bike);
        exerciseLog.addExercise(run);
        assertEquals(4.0, exerciseLog.averageTotalPace());
    }

    @Test
    public void testAverageBikePace() {
        swim.setPace(5.0);
        bike.setPace(5.0);
        run.setPace(5.0);
        bike2.setPace(5.0);
        exerciseLog.addExercise(swim);
        exerciseLog.addExercise(bike);
        exerciseLog.addExercise(run);
        exerciseLog.addExercise(bike2);
        assertEquals(5.0, exerciseLog.averageBikePace());
    }

    @Test
    public void testAverageRunPace() {
        swim.setPace(5.0);
        run.setPace(5.0);
        bike.setPace(2.0);
        run.setPace(5.0);
        exerciseLog.addExercise(run);
        exerciseLog.addExercise(swim);
        exerciseLog.addExercise(bike);
        exerciseLog.addExercise(run);
        assertEquals(5.0, exerciseLog.averageRunPace());
    }

    @Test
    public void testAverageSwimPace() {
        swim.setPace(5.0);
        bike.setPace(2.0);
        run.setPace(5.0);
        exerciseLog.addExercise(swim);
        exerciseLog.addExercise(bike);
        exerciseLog.addExercise(run);
        exerciseLog.addExercise(swim);
        assertEquals(5.0, exerciseLog.averageSwimPace());
    }

}
