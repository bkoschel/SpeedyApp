package model;


public interface Exercise {

    String getTitle();

    String getDate();

    double getDistance();

    String getDuration();

    double getPace();

    int getElevation();

    void setTitle(String title);

    void setDate(String date);

    void setDuration(String duration);

    void setDistance(double distance);

    void setPace(double pace);

    void setElevation(int elevation);

    String toString();

}
