package pl.edu.agh.backMainApp.webService;

import pl.edu.agh.backMainApp.model.Parking;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.awt.geom.Area;

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
    public void notifyOccupySpot(String AreaId, String SpotId) {
        parkingState.occupySpot(AreaId, SpotId);
    }

    @WebMethod
    public void notifyaddSpot(String AreaId, String SpotId) {
        parkingState.addSpot(AreaId, SpotId);
    }

    @WebMethod
    public void notifyRemoveSpot(String AreaId, String SpotId) {
        parkingState.removeSpot(AreaId, SpotId);
    }
}
