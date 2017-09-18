package ejb.beans;

import ejb.ParkingSpot;
import ejb.interfaces.ParkingService;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;

/**
 * Created by Michał Piotrowski on 2017-08-17.
 */
@Singleton
@Startup
public class ParkingBean implements ParkingService {
    // Map< GlobalSpotId, IsOccupied >
    private Map<String, Boolean> parkingState;

    public ParkingBean() {
        parkingState = new TreeMap<>();
        parkingState.put("B01", false);
        parkingState.put("B02", false);
        parkingState.put("B03", false);
        parkingState.put("B04", false);

        parkingState.put("W09", false);
        parkingState.put("W10", false);
        parkingState.put("W11", false);
        parkingState.put("W12", false);

    }

    public String printSpots() {
        StringBuilder sb = new StringBuilder();
        char prevFirstLetter = '~';
        for (Map.Entry<String, Boolean> entry : parkingState.entrySet()) {
            if (!(entry.getKey().charAt(0) == prevFirstLetter))
                sb.append("\n");
            prevFirstLetter = entry.getKey().charAt(0);
            sb.append(entry.getKey() + ": " + (entry.getValue() ? "occupied\n" : "vacant\n"));
        }

        return sb.toString();
    }

    public String addSpot(String AreaId, String SpotId) {
        String newSpot = AreaId.concat(SpotId);
        String response;
        if (parkingState.containsKey(newSpot))
            response = "Spot already exists";
        else {
            response = "Spot " + SpotId + " in area: " + AreaId + " has been successfully created";
            parkingState.put(newSpot, false);
        }
        return response;
    }

    public String removeSpot(String AreaId, String SpotId) {
        String spotToRemove = AreaId.concat(SpotId);
        String response;
        if (!parkingState.containsKey(spotToRemove))
            response = "Spot " + spotToRemove + " has not been found";
        else {
            parkingState.remove(spotToRemove);
            response = "removing " + spotToRemove;
        }
        return response;
    }

    public String occupySpot(String AreaId, String SpotId) {
        String spotToOccupy = AreaId.concat(SpotId);
        String response;
        if (!parkingState.containsKey(spotToOccupy))
            response = "Spot " + spotToOccupy + " has not been found";
        else{
            if (parkingState.get(spotToOccupy).equals(true))
                response = "Spot had already been occupied";
            else {
                parkingState.put(spotToOccupy, true);
                response = "Spot has been occupied successfully";
            }
        }
        return response;
    }

    public String vacateSpot(String AreaId, String SpotId) {
        String spotToOccupy = AreaId.concat(SpotId);
        String response;
        if (!parkingState.containsKey(spotToOccupy))
            response = "Spot " + spotToOccupy + " has not been found";
        else {
            if (parkingState.get(AreaId.concat(SpotId)).equals(false))
                response = "Spot had not been occupied";
            else {
                parkingState.put(AreaId.concat(SpotId), false);
                response = "Spot has become vacant successfully";
            }
        }
        return response;
    }

//    public static ParkingBean getInstance() {
//        ParkingBean parkingBean = instance;
//        if (parkingBean == null) {
//            synchronized (ParkingBean.class) {
//                if (parkingBean == null)
//                    parkingBean = new ParkingBean();
//            }
//        }
//        return parkingBean;
//    }

    public List<ParkingSpot> getEntries() {
        List<ParkingSpot> spots = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry: parkingState.entrySet())
            spots.add(new ParkingSpot(entry.getKey()));
        return spots;
    }
}
