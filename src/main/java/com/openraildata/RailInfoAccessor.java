package com.openraildata;

import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.*;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfArrayOfCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.CallingPoint;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class RailInfoAccessor {

    private static final int MAX_RETURN = 4;
    private static final String LDB_TOKEN = "22f9c534-2a6f-44cf-8612-5cf7eb958e6c";


    private AccessToken accessToken;
    private LDBServiceSoap soapService;

    public RailInfoAccessor() throws ConfigurationException {
        this.setUp();
    }

    public void setUp() throws ConfigurationException {
        if (LDB_TOKEN.isEmpty()) {
            throw new ConfigurationException("Please configure your OpenLDBWS token in GetDepartureBoardExample!");
        }

        accessToken = new AccessToken();
        accessToken.setTokenValue(LDB_TOKEN);

        Ldb soap = new Ldb();
        soapService = soap.getLDBServiceSoap12();

    }


    public List<ServiceInfo> getNextServices(String stationCode){

        GetBoardRequestParams params = new GetBoardRequestParams();
        params.setCrs(stationCode);

        StationBoardResponseType departureBoard = soapService.getDepartureBoard(params, accessToken);

        System.out.println("Trains at " + departureBoard.getGetStationBoardResult().getLocationName());
        System.out.println("===============================================================================");

        List<ServiceItem> services = departureBoard.getGetStationBoardResult().getTrainServices().getService();

        return getServicesList(services);

    }

    private List<ServiceInfo> getServicesList(List<ServiceItem> services){

        List<ServiceInfo> listOfServices = new ArrayList<>();

        for(int i=0; i<MAX_RETURN; i++){

            ServiceItem service = services.get(i);

            String destination =  service.getDestination().getLocation().get(0).getLocationName();

            GetServiceDetailsRequestParams serviceParams = new GetServiceDetailsRequestParams();
            String serviceId = service.getServiceID();
            serviceParams.setServiceID(service.getServiceID());

            ServiceDetailsResponseType serviceItem = soapService.getServiceDetails(serviceParams, accessToken);


            ServiceInfo serviceInfo = new ServiceInfo(serviceId, destination, service.getStd(), service.getEtd(), service.getOperator());
            listOfServices.add(setUpServiceInfoItem(serviceInfo, serviceItem));
        }

        return listOfServices;

    }

    private ServiceInfo setUpServiceInfoItem(ServiceInfo serviceInfo, ServiceDetailsResponseType serviceItem){

        ArrayOfArrayOfCallingPoints callingPointsArray = serviceItem.getGetServiceDetailsResult().getSubsequentCallingPoints();

        List<CallingPoint> callingPoints = callingPointsArray.getCallingPointList().get(0).getCallingPoint();
        for(CallingPoint callingPoint:callingPoints){
            String estimated = !callingPoint.getEt().equals("On time") ? callingPoint.getEt() : callingPoint.getSt();
            serviceInfo.addStop(new StationStop(callingPoint.getLocationName(), estimated));
        }

        return serviceInfo;

    }


}
