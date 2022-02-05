package com.openraildata;

import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.*;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfArrayOfCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.CallingPoint;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.frontend.ClientProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.ConfigurationException;
import java.util.List;

/**
 * Open Live Departure Boards Web Service (OpenLDBWS) API Demonstrator
 * Copyright (C)2018-2021 OpenTrainTimes Ltd.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
public class GetDepartureBoardExample {


    public static void main(String[] args) throws ConfigurationException {

        RailInfoAccessor railInfoAccessor = new RailInfoAccessor();

        List<ServiceInfo> services = railInfoAccessor.getNextServices("BMS");

        for(ServiceInfo serviceInfo:services){

            System.out.println(serviceInfo.getDepartureTime() + " to "+ serviceInfo.getDestination() + " - " + serviceInfo.getStatus());
            System.out.println("Calling at: ");
            for(StationStop stationStop:serviceInfo.getStops()){
                System.out.print(stationStop.getStationName() + " " + "("+ stationStop.getExpectedTime()+")" +", ");
            }
            System.out.println("");
            System.out.println("A "+ serviceInfo.getProvider() + " service");
            System.out.println("----");
        }





    }

}
