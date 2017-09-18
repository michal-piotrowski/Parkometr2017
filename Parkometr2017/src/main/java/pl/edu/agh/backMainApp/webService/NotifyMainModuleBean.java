package pl.edu.agh.backMainApp.webService;

import ejb.ParkingSpot;
import ejb.interfaces.ParkingService;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Michał Piotrowski on 2017-09-05.
 */
@WebService
@Named
public class NotifyMainModuleBean implements NotifyMainModule {

    @EJB
    private ParkingService parkingService;


    public NotifyMainModuleBean() {}

    @WebMethod
    public String notifyOccupySpot(@WebParam(name = "AreaId") String AreaId, @WebParam(name = "SpotId") String SpotId) {
        return parkingService.occupySpot(AreaId, SpotId);
    }

    @WebMethod
    public String notifyaddSpot(@WebParam(name = "AreaId") String AreaId, @WebParam(name = "SpotId") String SpotId) {
        return parkingService.addSpot(AreaId, SpotId);
    }

    @WebMethod
    public String notifyRemoveSpot(@WebParam(name = "AreaId") String AreaId, @WebParam(name = "SpotId") String SpotId) {
        return parkingService.removeSpot(AreaId, SpotId);
        // lets make a change
    }

    @WebMethod
    public String notifyVacateSpot(@WebParam(name = "AreaId") String AreaId, @WebParam(name = "SpotId") String SpotId) {
        return parkingService.vacateSpot(AreaId, SpotId);
    }

    @WebMethod
    public String notifyPrintSpots() {
        return parkingService.printSpots();
    }

    public List<ParkingSpot> getEntries() {
        return parkingService.getEntries();
    }

    @WebMethod
    public ParkingSpot getEntry(@WebParam String composedSpotID) {
        for (ParkingSpot s : parkingService.getEntries())
            if (s.getComposed().equals(composedSpotID))
                return s;
        return null;
    }
}
