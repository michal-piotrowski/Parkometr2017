package pl.edu.agh.backMainApp.webService;

import pl.edu.agh.backMainApp.model.Parking;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by Michał Piotrowski on 2017-09-05.
 */
@WebService
public class NotifyMainModuleBean implements NotifyMainModule {

    private Parking parkingState;

    public NotifyMainModuleBean() {
        parkingState = Parking.getInstance();
    }

    @WebMethod
    public String notifyOccupySpot(@WebParam(name = "AreaId") String AreaId, @WebParam(name = "SpotId") String SpotId) {
        return parkingState.occupySpot(AreaId, SpotId);
    }

    @WebMethod
    public String notifyaddSpot(@WebParam(name = "AreaId") String AreaId, @WebParam(name = "SpotId") String SpotId) {
        return parkingState.addSpot(AreaId, SpotId);
    }

    @WebMethod
    public String notifyRemoveSpot(@WebParam(name = "AreaId") String AreaId, @WebParam(name = "SpotId") String SpotId) {
        return parkingState.removeSpot(AreaId, SpotId);
    }

    @WebMethod
    public String notifyVacateSpot(@WebParam(name = "AreaId") String AreaId, @WebParam(name = "SpotId") String SpotId) {
        return parkingState.vacateSpot(AreaId, SpotId);
    }

    @WebMethod
    public String notifyPrintSpots() {
        return parkingState.printSpots();
    }
}
