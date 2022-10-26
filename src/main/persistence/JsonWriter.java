package persistence;

import model.ExerciseLog;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Some methods used in this class were inspired by methods in JsonSerialization program
// GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// This program allows us to write a JSON representation of an exercise log to a file.
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs a writer to write to a destination file.
    // Inspired by JsonWriter method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot be opened for writing
    // Inspired by open() method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of exercise log to a file
    // Inspired by write() method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public void write(ExerciseLog exerciseLog) {
        JSONObject json = exerciseLog.toJson();
        saveToJsonFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    // Inspired by saveToJsonFile method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void saveToJsonFile(String json) {
        writer.print(json);
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    // Inspired by close() method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public void close() {
        writer.close();
    }
}
