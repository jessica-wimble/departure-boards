package com.openraildata;

public class StationStop {

    private String stationName;
    private String expectedTime;

    public StationStop(String getStationName, String expectedTime){
        this.stationName = getStationName;
        this.expectedTime = expectedTime;
    }

    public String getStationName(){
        return this.stationName;
    }

    public String getExpectedTime(){
        return this.expectedTime;
    }


}
