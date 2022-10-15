package model;

import java.sql.Time;
import java.time.LocalTime;

// Represents a Swim entry having a title, date, distance, duration and pace
public class Swim implements Exercise {
    private String title;
    private String date;
    private double distance;
    private String duration;
    private double pace;

    /*
    * REQUIRES: pace, distance and duration must be non-negative values
    * EFFECTS: sets the title of the swimming activity to default 'New Swim'; Sets the date to current
    * date and time; sets the distance to 0.0km; sets the duration to 00(hours):00(minutes):00(seconds);
    * sets the pace to 0:00/km
    */
    public Swim() {
        title = "New Swim";
        date = "";
        distance = 0.0;
        duration = "00:00:00";
        pace = 0.0;
    }

    // getters
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
        return duration.toString();
    }

    public double getPace() {
        return pace;
    }

    @Override
    public int getElevation() {
        return 0;
    }

    // setters
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

    @Override
    public void setElevation(int elevation) {

    }

    @Override
    public void changeDistanceUnitsToMilesFromKm() {

    }

    @Override
    public void changeDistanceUnitsToKmFromMile() {

    }

    @Override
    public void changePaceUnitsToMinPerMile() {

    }

    @Override
    public void changePaceUnitsToMinPerKm() {

    }


    public String toString() {
        String distanceString = Double.toString(distance);
        String paceString = Double.toString(pace);
        return    "Title: " + title
                + "\n Date: " + date
                + "\n Distance: " + distanceString + " km"
                + "\n Duration: " + duration
                + "\n Pace: " + paceString + " min/km";
    }
}
