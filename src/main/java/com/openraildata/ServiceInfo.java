package com.openraildata;

import java.util.ArrayList;
import java.util.List;

public class ServiceInfo {

    private String serviceId;
    private List<StationStop> stationStops;
    private String departureTime;
    private String status;
    private String destination;
    private String provider;

    public ServiceInfo(String serviceId, String destination, String departureTime, String status, String provider){
        this.serviceId = serviceId;
        this.destination = destination;
        this.departureTime = departureTime;
        this.status = status;
        this.stationStops = new ArrayList<>();
        this.provider = provider;
    }

    public void addStop(StationStop stop){
        this.stationStops.add(stop);
    }

    public List<StationStop> getStops(){
        return this.stationStops;
    }

    public String getStatus(){
        return this.status;
    }

    public String getDepartureTime(){
        return this.departureTime;
    }

    public String getDestination(){
        return this.destination;
    }

    public String getProvider(){
        return this.provider;
    }

}
