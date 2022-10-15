package model;

import java.sql.*;
import java.time.LocalTime;
import java.util.Calendar;

// Represents a Run entry having a title, date, distance, duration and pace
public class Run implements Exercise {
    private String title;
    private String date;
    private double distance;
    private String duration;
    private double pace;
    private int elevation;

    /*
     * REQUIRES: pace, distance, duration, and elevation must be non-negative values
     * EFFECTS: sets the title of the swimming activity to default 'New Run'; Sets the date to current
     * date and time; sets the distance to 0.0km; sets the duration to 00(hours):00(minutes):00(seconds);
     * sets the pace to 0:00 min/km; sets the elevation to 0 meters;
     */

    public Run() {
        title = "New Run";
        date = "01/01/2022";
        distance = 0.0;
        duration = "00:00:00";
        pace = 0.0;
        elevation = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public double getDistance() {
        return distance;
    }

    public String getDuration() {
        return duration;
    }

    public double getPace() {
        return pace;
    }

    public int getElevation() {
        return elevation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }


    public void changeDistanceUnitsToMilesFromKm() {
        distance = distance / 1.609;
    }

    public void changeDistanceUnitsToKmFromMile() {
        distance = distance * 1.609;
    }

    public void changePaceUnitsToMinPerMile() {
        pace = pace * 1.609;
    }

    public void changePaceUnitsToMinPerKm() {
        pace = pace / 1.609;
    }

    public String toString() {
        String distanceString = Double.toString(distance);
        String paceString = Double.toString(pace);
        String elevationString = Integer.toString(elevation);
        return    "Title: " + title
                + "\n Date: " + date
                + "\n Distance: " + distanceString + " km"
                + "\n Duration: " + duration
                + "\n Pace: " + paceString + " min/km"
                + "\n Elevation: " + elevationString + " m";
    }

}
