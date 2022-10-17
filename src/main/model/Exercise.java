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

}
