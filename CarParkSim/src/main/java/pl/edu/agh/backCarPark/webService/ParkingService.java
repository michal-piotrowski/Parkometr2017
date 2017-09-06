package pl.edu.agh.backCarPark.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Michał Piotrowski on 2017-09-03.
 */

@WebService(name = "ParkingService")
public class ParkingService {

    @WebMethod
    public int carArrivedOnSpot() {
        return 10;
    }

}
