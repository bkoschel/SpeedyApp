package persistence;

import model.Exercise;
import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    protected void checkExercises(String title, String date, double distance, String duration, double pace,
                                  int elevation, String activity, Exercise exercise) {
        assertEquals(title, exercise.getTitle());
        assertEquals(date, exercise.getDate());
        assertEquals(distance, exercise.getDistance());
        assertEquals(duration, exercise.getDuration());
        assertEquals(pace, exercise.getPace());
        assertEquals(elevation, exercise.getElevation());
        assertEquals(activity, exercise.getActivity());
    }
}
