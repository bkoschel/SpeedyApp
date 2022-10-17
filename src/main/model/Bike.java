package model;



// Represents a Bike entry having a title, date, distance, duration and pace
public class Bike implements Exercise {
    private String title;
    private String date;
    private double distance;
    private String duration;
    private double pace;
    private int elevation;

    /*
     * REQUIRES: pace, distance, duration, and elevation must be non-negative values
     * EFFECTS: sets the title of the swimming activity to default 'New Bike'; Sets the date to current
     * date and time; sets the distance to 0.0km; sets the duration to 00(hours):00(minutes):00(seconds);
     * sets the pace to 0:00 min/km; sets the elevation to 0 meters;
     */
    public Bike() {
        title = "New Bike Ride";
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

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    // EFFECTS: returns a string representation of a bike
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
