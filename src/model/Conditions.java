package model;


public class Conditions {

    private String townName;
    private String stateName;
    private double elevation;
    private String zipCode;
    private String observationTime;
    private String currentConditions;
    private String temperatureF;
    private double windSpeed;
    private String windDirection;
    private String userURL;


    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public String getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(String currentConditions) {
        this.currentConditions = currentConditions;
    }

    public String getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(String temperatureF) {
        this.temperatureF = temperatureF;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    //testing parsing from XML file for correct information
    public void returnInfo(){

        String yourCity = "Your city is " + getTownName();
        System.out.println(yourCity);
        String yourState = "Your state is " + getStateName();
        System.out.println(yourState);
        String yourElevation = "Your elevation is " + getElevation();
        System.out.println(yourElevation);
        String yourZip = "Your zip is " + getZipCode();
        System.out.println(yourZip);
        String obsTime = "The observed time for the weather was " + getObservationTime();
        System.out.println(obsTime);

        System.out.println("The current conditions are " + getCurrentConditions());
        System.out.println("The temperature is " + getTemperatureF() + " F");
        System.out.println("The wind is from the " + getWindDirection() +
                " at " + getWindSpeed() + " MPH");
    }

    public String currentConditions(){
        String weather = "Currently in " + getTownName() + ", " + getStateName() +
                " it is " + getCurrentConditions() + ". \nThe temperature is " + getTemperatureF() +
                " degrees F and the wind is from the " + getWindDirection() + " at " + getWindSpeed() +
                " MPH.";
        return weather;
    }
}
