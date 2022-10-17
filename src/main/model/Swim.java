package model;


// Represents a Swim entry having a title, date, distance, duration, pace and elevation
public class Swim implements Exercise {
    private String title;
    private String date;
    private double distance;
    private String duration;
    private double pace;
    private int elevation;

    /*
    * REQUIRES: pace and distance must be non-negative numbers with at least one decimal place. Elevation must be an
    * integer.
    * EFFECTS: sets the title of the swimming activity to default 'New Swim'; Sets the date to current
    * date and time; sets the distance to 0.0km; sets the duration to 00(hours):00(minutes):00(seconds);
    * sets the pace to 0:00/km
    */
    public Swim() {
        title = "New Swim";
        date = "01/01/2022";
        distance = 0.0;
        duration = "00:00:00";
        pace = 0.0;
        elevation = 0;
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
        return duration;
    }

    public double getPace() {
        return pace;
    }

    @Override
    public int getElevation() {
        return elevation;
    }

    // setters
    // REQUIRES: title must have unique name
    public void setTitle(String title) {
        this.title = title;
    }

    // REQUIRES: that the date entered is a valid date following this form DD/MM/YYYY (for example 15/03/2022
    //           and not 37/13/0009
    public void setDate(String date) {
        this.date = date;
    }

    // REQUIRES: that the duration entered is a valid date following this form HH:MM:SS
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
        this.elevation = elevation;
    }

    // EFFECTS: returns a string representation of a swim
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
