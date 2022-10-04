package model;

// Represents a Swim entry having a title, date, distance, duration and pace
public class Swim extends Exercise {
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
        return duration;
    }

    public double getPace() {
        return pace;
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

    public double calculatePace() {
        return 0.0;
    }

    public double changeUnits() {
        return 0.0;
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
