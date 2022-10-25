package persistence;

import model.ExerciseLog;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// This program allows us to write a JSON representation of an exercise log to a file.

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    public JsonWriter(String destination) {
        this.destination = destination;
    }

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    public void write(ExerciseLog exerciseLog) {
        JSONObject json = exerciseLog.toJson();
        saveToJsonFile(json.toString(TAB));
    }

    private void saveToJsonFile(String json) {
        writer.print(json);
    }

    public void close() {
        writer.close();
    }
}
