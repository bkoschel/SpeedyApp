package persistence;

import model.*;
import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Some methods used in this class were inspired by methods in JsonSerialization program
// GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    // Inspired by JsonReader method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads exercise log from file and returns it
    // throws IOException if an error occurs reading data from file
    // Inspired by read() method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public ExerciseLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseExerciseLog(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    // throws IOException if an error occurs reading data from file
    // Inspired by readFile() method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses exercise log from JSONObject and returns it
    // Inspired by parseWorkRoom method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private ExerciseLog parseExerciseLog(JSONObject jsonObject) {
        ExerciseLog exerciseLog = new ExerciseLog();
        addExerciseLog(exerciseLog, jsonObject);
        return exerciseLog;
    }

    // MODIFIES: exerciseLog
    // EFFECTS: parses exercises from JSON object and adds it to the exerciseLog
    // Inspired by addThingies method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void addExerciseLog(ExerciseLog exerciseLog, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExercise(exerciseLog, nextExercise);
        }
    }

    // MODIFIES: exerciseLog
    // REQUIRES: activity must be valid activity type: run, bike, swim
    private void addExercise(ExerciseLog exerciseLog, JSONObject nextExercise) {
        if (nextExercise.get("activity").equals("swim")) {
            addSwim(exerciseLog, nextExercise);
        } else if (nextExercise.get("activity").equals("bike")) {
            addBike(exerciseLog, nextExercise);
        } else {
            addRun(exerciseLog, nextExercise);
        }
    }

    // MODIFIES: exerciseLog
    // EFFECTS: parses swim from JSON object and adds it to the exerciseLog
    // Inspired by addThingy method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void addSwim(ExerciseLog exerciseLog, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String date = jsonObject.getString("date");
        double distance = jsonObject.getDouble("distance");
        String duration = jsonObject.getString("duration");
        double pace = jsonObject.getDouble("pace");
        int elevation = jsonObject.getInt("elevation");
        Exercise exercise = new Swim();
        exercise.setTitle(title);
        exercise.setDate(date);
        exercise.setDistance(distance);
        exercise.setDuration(duration);
        exercise.setPace(pace);
        exercise.setElevation(elevation);
        exerciseLog.addExercise(exercise);
    }

    // MODIFIES: exerciseLog
    // EFFECTS: parses bike ride from JSON object and adds it to the exerciseLog
    // Inspired by addThingy method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void addBike(ExerciseLog exerciseLog, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String date = jsonObject.getString("date");
        double distance = jsonObject.getDouble("distance");
        String duration = jsonObject.getString("duration");
        double pace = jsonObject.getDouble("pace");
        int elevation = jsonObject.getInt("elevation");
        Exercise exercise = new Bike();
        exercise.setTitle(title);
        exercise.setDate(date);
        exercise.setDistance(distance);
        exercise.setDuration(duration);
        exercise.setPace(pace);
        exercise.setElevation(elevation);
        exerciseLog.addExercise(exercise);
    }

    // MODIFIES: exerciseLog
    // EFFECTS: parses run from JSON object and adds it to the exerciseLog
    // Inspired by addThingy method in JsonSerialization
    // GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void addRun(ExerciseLog exerciseLog, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String date = jsonObject.getString("date");
        double distance = jsonObject.getDouble("distance");
        String duration = jsonObject.getString("duration");
        double pace = jsonObject.getDouble("pace");
        int elevation = jsonObject.getInt("elevation");
        Exercise exercise = new Run();
        exercise.setTitle(title);
        exercise.setDate(date);
        exercise.setDistance(distance);
        exercise.setDuration(duration);
        exercise.setPace(pace);
        exercise.setElevation(elevation);
        exerciseLog.addExercise(exercise);
    }

}
