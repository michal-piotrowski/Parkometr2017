package pl.edu.agh.backMainApp.webService;

/**
 * Created by Michał Piotrowski on 2017-09-05.
 */
public interface NotifyMainModule {

    public String notifyOccupySpot(String AreaId, String SpotId);

    public String notifyaddSpot(String AreaId, String SpotId);

    public String notifyRemoveSpot(String AreaId, String SpotId);

    public String notifyVacateSpot(String AreaId, String SpotId);

    public String notifyPrintSpots();

}
