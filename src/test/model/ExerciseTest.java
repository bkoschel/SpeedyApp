package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ExerciseTest {
    private Exercise swim;
    private Exercise bike;
    private Exercise run;

    @BeforeEach
    void setUp() {
        swim = new Swim();
        bike = new Bike();
        run = new Run();
    }

    @Test
    void testSwimConstructor() {
        assertEquals("New Swim", swim.getTitle());
        assertEquals("01/01/2022", swim.getDate());
        assertEquals(0.0, swim.getDistance());
        assertEquals("00:00:00", swim.getDuration());
        assertEquals(0.0, swim.getPace());
        assertEquals(0, swim.getElevation());
    }

    @Test
    void testBikeConstructor() {
        assertEquals("New Bike Ride", bike.getTitle());
        assertEquals("01/01/2022", bike.getDate());
        assertEquals(0.0, bike.getDistance());
        assertEquals("00:00:00", bike.getDuration());
        assertEquals(0.0, bike.getPace());
        assertEquals(0, bike.getElevation());
    }

    @Test
    void testRunConstructor() {
        assertEquals("New Run", run.getTitle());
        assertEquals("01/01/2022", run.getDate());
        assertEquals(0.0, run.getDistance());
        assertEquals("00:00:00", run.getDuration());
        assertEquals(0.0, run.getPace());
        assertEquals(0, run.getElevation());
    }

    // Tests Title Change
    @Test
    void testChangeSwimTitle() {
        assertEquals("New Swim", swim.getTitle());
        swim.setTitle("Fun Swim");
        assertEquals("Fun Swim", swim.getTitle());
    }

    @Test
    void testChangeBikeTitle() {
        assertEquals("New Bike Ride", bike.getTitle());
        bike.setTitle("Fun Bike Ride");
        assertEquals("Fun Bike Ride", bike.getTitle());
    }

    @Test
    void testChangeRunTitle() {
        assertEquals("New Run", run.getTitle());
        run.setTitle("Fun Run");
        assertEquals("Fun Run", run.getTitle());
    }

    // testing date change
    @Test
    void testChangeSwimDate() {
        assertEquals("01/01/2022", swim.getDate());
        swim.setDate("10/04/2022");
        assertEquals("10/04/2022", swim.getDate());
    }

    @Test
    void testChangeBikeDate() {
        assertEquals("01/01/2022", bike.getDate());
        bike.setDate("10/05/2022");
        assertEquals("10/05/2022", bike.getDate());
    }

    @Test
    void testChangeRunDate() {
        assertEquals("01/01/2022", run.getDate());
        run.setDate("10/06/2022");
        assertEquals("10/06/2022", run.getDate());
    }

    // testing distance change
    @Test
    void testChangeSwimDistance() {
        assertEquals(0.0, swim.getDistance());
        swim.setDistance(1.0);
        assertEquals(1.0, swim.getDistance());
    }

    @Test
    void testChangeBikeDistance() {
        assertEquals(0.0, bike.getDistance());
        bike.setDistance(2.0);
        assertEquals(2.0, bike.getDistance());
    }

    @Test
    void testChangeRunDistance() {
        assertEquals(0.0, run.getDistance());
        run.setDistance(3.0);
        assertEquals(3.0, run.getDistance());
    }

    // testing duration change
    @Test
    void testChangeSwimDuration() {
        assertEquals("00:00:00", swim.getDuration());
        swim.setDuration("01:00:00");
        assertEquals("01:00:00", swim.getDuration());
    }

    @Test
    void testChangeBikeDuration() {
        assertEquals("00:00:00", bike.getDuration());
        bike.setDuration("02:00:00");
        assertEquals("02:00:00", bike.getDuration());
    }

    @Test
    void testChangeRunDuration() {
        assertEquals("00:00:00", run.getDuration());
        run.setDuration("03:00:00");
        assertEquals("03:00:00", run.getDuration());
    }

    // test change of pace
    @Test
    void testChangeSwimPace() {
        assertEquals(0.0, swim.getPace());
        swim.setPace(1.0);
        assertEquals(1.0, swim.getPace());
    }

    @Test
    void testChangeBikePace() {
        assertEquals(0.0, bike.getPace());
        bike.setPace(2.0);
        assertEquals(2.0, bike.getPace());
    }

    @Test
    void testChangeRunPace() {
        assertEquals(0.0, run.getPace());
        run.setPace(3.0);
        assertEquals(3.0, run.getPace());
    }

    // testing changing elevation

    @Test
    void testChangeBikeElevation() {
        assertEquals(0, bike.getElevation());
        bike.setElevation(100);
        assertEquals(100, bike.getElevation());
    }

    @Test
    void testChangeRunElevation() {
        assertEquals(0, run.getElevation());
        run.setElevation(300);
        assertEquals(300, run.getElevation());
    }

    @Test
    void testChangeSwimElevation() {
        assertEquals(0, swim.getElevation());
        swim.setElevation(1);
        assertEquals(1, swim.getElevation());
    }


    @Test
    void testToString() {
        assertTrue(run.toString().contains("Title: New Run"
                                        + "\n Date: 01/01/2022"
                                        + "\n Distance: 0.0 km"
                                        + "\n Duration: 00:00:00"
                                        + "\n Pace: 0.0 min/km"
                                        + "\n Elevation: 0 m"));
        assertTrue(bike.toString().contains("Title: New Bike Ride"
                                            + "\n Date: 01/01/2022"
                                            + "\n Distance: 0.0 km"
                                            + "\n Duration: 00:00:00"
                                            + "\n Pace: 0.0 min/km"
                                            + "\n Elevation: 0 m"));
        assertTrue(swim.toString().contains("Title: New Swim"
                                        + "\n Date: 01/01/2022"
                                        + "\n Distance: 0.0 km"
                                        + "\n Duration: 00:00:00"
                                        + "\n Pace: 0.0 min/km"));
    }

}