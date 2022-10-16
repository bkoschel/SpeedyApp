package model;

// Represents an Exercise entry having a title, date, distance, duration and pace
public interface Exercise {

    //getters
    String getTitle();

    String getDate();

    double getDistance();

    String getDuration();

    double getPace();

    int getElevation();

    // setters
    void setTitle(String title);

    void setDate(String date);

    void setDuration(String duration);

    void setDistance(double distance);

    void setPace(double pace);

    void setElevation(int elevation);

    // EFFECTS: returns a string representation of an exercise
    String toString();

}
