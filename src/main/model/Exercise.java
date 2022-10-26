package model;

import org.json.JSONObject;

// Some methods used in this class were inspired by methods in JsonSerialization program
// GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents an Exercise entry having a title, date, distance, duration and pace
public interface Exercise {

    //getters
    String getTitle();

    String getDate();

    double getDistance();

    String getDuration();

    double getPace();

    int getElevation();

    String getActivity();

    // setters
    // REQUIRES: title must have unique name
    void setTitle(String title);

    // REQUIRES: that the date entered is a valid date following this form DD/MM/YYYY (for example 15/03/2022
    //           and not 37/13/0009
    void setDate(String date);

    // REQUIRES: that the duration entered is a valid date following this form HH:MM:SS
    void setDuration(String duration);

    void setDistance(double distance);

    void setPace(double pace);

    void setElevation(int elevation);

    // EFFECTS: returns a string representation of an exercise
    String toString();

    // EFFECTS: returns a JSONObject representation of an exercise
    JSONObject toJson();

}
