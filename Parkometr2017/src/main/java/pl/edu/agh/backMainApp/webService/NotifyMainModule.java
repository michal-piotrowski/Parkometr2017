package pl.edu.agh.backMainApp.webService;

/**
 * Created by Michał Piotrowski on 2017-09-05.
 */
public interface NotifyMainModule {

    public void notifyOccupySpot(String AreaId, String SpotId);

    public void notifyaddSpot(String AreaId, String SpotId);

    public void notifyRemoveSpot(String AreaId, String SpotId);

}
