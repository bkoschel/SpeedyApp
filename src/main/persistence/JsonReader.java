package persistence;

import model.*;
import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    public JsonReader(String source) {
        this.source = source;
    }

    public ExerciseLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseExerciseLog(jsonObject);
    }

    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    private ExerciseLog parseExerciseLog(JSONObject jsonObject) {
        ExerciseLog exerciseLog = new ExerciseLog();
        addExerciseLog(exerciseLog, jsonObject);
        return exerciseLog;
    }

    private void addExerciseLog(ExerciseLog exerciseLog, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExercise(exerciseLog, nextExercise);
        }
    }

    private void addExercise(ExerciseLog exerciseLog, JSONObject nextExercise) {
        if (nextExercise.get("activity").equals("swim")) {
            addSwim(exerciseLog, nextExercise);
        } else if (nextExercise.get("activity").equals("bike")) {
            addBike(exerciseLog, nextExercise);
        } else if (nextExercise.get("activity").equals("run")) {
            addRun(exerciseLog, nextExercise);
        }
    }

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
