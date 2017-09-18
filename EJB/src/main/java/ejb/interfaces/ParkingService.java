package ejb.interfaces;

import ejb.ParkingSpot;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Michał Piotrowski on 2017-09-09.
 */
@Local
public interface ParkingService {

//    String JNDI_NAME = "ParkingBean!pl.edu.agh.backMainApp.ejb.interfaces.ParkingService";

    String occupySpot(String AreaId, String SpotId);

    String addSpot(String AreaId, String SpotId);

    String removeSpot(String AreaId, String SpotId);

    String vacateSpot(String AreaId, String SpotId);

    String printSpots();

    List<ParkingSpot> getEntries();


}
