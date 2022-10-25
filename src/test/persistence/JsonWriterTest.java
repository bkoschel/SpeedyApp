package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterToInvalidFile() {
        try {
            ExerciseLog exerciseLog = new ExerciseLog();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("Expecting IOException");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWritingToEmptyExerciseLog() {
        try {
            ExerciseLog exerciseLog = new ExerciseLog();
            JsonWriter writer = new JsonWriter("./data/testWritingToEmptyExerciseLog.json");
            writer.open();
            writer.write(exerciseLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWritingToEmptyExerciseLog.json");
            exerciseLog = reader.read();
            assertEquals(0, exerciseLog.getExerciseLogSize());
        } catch (IOException e) {
            fail("IOException should not have be thrown");
        }
    }

    @Test
    void testWriteExerciseLog() {
        try {
            ExerciseLog exerciseLog = new ExerciseLog();
            Exercise swim = new Swim();
            Exercise bike = new Bike();
            Exercise run = new Run();
            exerciseLog.addExercise(swim);
            exerciseLog.addExercise(bike);
            exerciseLog.addExercise(run);
            JsonWriter writer = new JsonWriter("./data/testWriteExerciseLog.json");
            writer.open();
            writer.write(exerciseLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriteExerciseLog.json");
            exerciseLog = reader.read();
            List<Exercise> exerciseList = exerciseLog.getExerciseLog();
            assertEquals(3, exerciseLog.getExerciseLogSize());
            checkExercises("New Swim", "01/01/2022", 0.0, "00:00:00", 0.0,
                    0, "swim", exerciseList.get(0));
            checkExercises("New Bike Ride", "01/01/2022", 0.0, "00:00:00", 0.0,
                    0, "bike", exerciseList.get(1));
            checkExercises("New Run", "01/01/2022", 0.0, "00:00:00", 0.0,
                    0, "run", exerciseList.get(2));
        } catch (IOException e) {
            fail("IOException should not have be thrown");
        }
    }
}
