package persistence;

import model.Exercise;
import model.ExerciseLog;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest{

    @Test
    void testJsonReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ExerciseLog exerciseLog = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReadingFromEmptyExerciseLog() {
        JsonReader reader = new JsonReader("./data/testReadingFromEmptyExerciseLog.json");
        try {
            ExerciseLog exerciseLog = reader.read();
            assertEquals(0, exerciseLog.getExerciseLogSize());
        } catch (IOException e){
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReadingFromExerciseLog() {
        JsonReader reader = new JsonReader("./data/testReadingFromExerciseLog.json");
        try {
            ExerciseLog exerciseLog = reader.read();
            List<Exercise> exerciseList = exerciseLog.getExerciseLog();
            assertEquals(3, exerciseList.size());
            checkExercises("Cold Swim", "01/01/2022", 0.0, "01:00:00", 0.0, 0,
                    "swim", exerciseList.get(0));
            checkExercises("Speedy Bike Ride", "02/02/2022", 0.0, "02:00:00", 0.0,
                    0, "bike", exerciseList.get(1));
            checkExercises("Long Run", "03/03/2022", 0.0, "03:00:00", 0.0, 0,
                    "run",exerciseList.get(2));
        } catch (IOException e) {
            fail("Could not read from this file");
        }

    }

}
