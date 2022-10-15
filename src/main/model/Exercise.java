package model;

import java.time.LocalTime;

public interface Exercise {

    public String getTitle();

    public String getDate();

    public double getDistance();

    public String getDuration();

    public double getPace();

    public int getElevation();

    public void setTitle(String title);

    public void setDate(String date);

    public void setDuration(String duration);

    public void setDistance(double distance);

    public void setPace(double pace);

    public void setElevation(int elevation);


    public void changeDistanceUnitsToMilesFromKm();

    public void changeDistanceUnitsToKmFromMile();

    public void changePaceUnitsToMinPerMile();

    public void changePaceUnitsToMinPerKm();

    public String toString();

}
