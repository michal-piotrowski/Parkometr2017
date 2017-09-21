package ejb.beans;

import ejb.ParkingSpot;
import ejb.interfaces.ParkingService;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Michał Piotrowski on 2017-08-17.
 */
@Singleton
@Startup
public class ParkingBean implements ParkingService {
    // Map< GlobalSpotId, IsOccupied >
//    private Map<String, Boolean> parkingState;
    private List<ParkingSpot> parkingState;

    public ParkingBean() {
        parkingState = new ArrayList<>();
        parkingState.add(new ParkingSpot("GaleriaKrakowska", "01", false));
        parkingState.add(new ParkingSpot("GaleriaKrakowska", "02", false));
        parkingState.add(new ParkingSpot("GaleriaKrakowska", "03", false));
        parkingState.add(new ParkingSpot("GaleriaKrakowska", "04", false));

        parkingState.add(new ParkingSpot("StanisławaWorcella6", "09", false));
        parkingState.add(new ParkingSpot("StanisławaWorcella6", "10", false));
        parkingState.add(new ParkingSpot("StanisławaWorcella6", "11", false));
        parkingState.add(new ParkingSpot("StanisławaWorcella6", "12", false));
        parkingState.add(new ParkingSpot("StanisławaWorcella6", "13", false));
        parkingState.add(new ParkingSpot("StanisławaWorcella6", "14", false));

        parkingState.add(new ParkingSpot("AutoSave-Parking", "156", false));
        parkingState.add(new ParkingSpot("AutoSave-Parking", "123", false));
        parkingState.add(new ParkingSpot("AutoSave-Parking", "111", false));
        parkingState.add(new ParkingSpot("AutoSave-Parking", "117", false));
        parkingState.add(new ParkingSpot("AutoSave-Parking", "139", false));

    }

    public String printSpots() {
        StringBuilder sb = new StringBuilder();
        String prevAreaId = "%^";
        Collections.sort(parkingState);
        for (ParkingSpot entry : parkingState) {
            if (!(entry.getAreaId().equals(prevAreaId)))
                sb.append("\n");
            prevAreaId = entry.getAreaId();
            sb.append(entry.getAreaId() + " " + entry.getSpotId() + ": " + (entry.getOccupied() ? "occupied\n" : "vacant\n"));
        }

        return sb.toString();
    }

    /**
     * If spot exists, method does nothing. Verification mechanism bases on overriden equals method in ParkingSpot
     */
    public String addSpot(String AreaId, String SpotId) {
        ParkingSpot newSpot = new ParkingSpot(AreaId, SpotId);
        String response;
        if (parkingState.contains(newSpot))
            response = "Spot already exists";
        else {
            response = "Spot " + SpotId + " in area: " + AreaId + " has been successfully created";
            parkingState.add(newSpot);
        }
        return response;
    }

    public String removeSpot(String AreaId, String SpotId) {
        ParkingSpot spotToRemove = new ParkingSpot(AreaId, SpotId);
        String response;
        if (!parkingState.contains(spotToRemove))
            response = "Spot " + spotToRemove + " has not been found";
        else {
            parkingState.remove(spotToRemove);
            response = "removing " + spotToRemove;
        }
        return response;
    }

    public String occupySpot(String AreaId, String SpotId) {
        ParkingSpot spotToOccupy = new ParkingSpot(AreaId, SpotId);
        String response;
        if (!parkingState.contains(spotToOccupy))
            response = "Spot " + spotToOccupy + " has not been found";
        else {
            if (parkingState.get(parkingState.indexOf(spotToOccupy)).getOccupied())
                response = "Spot had already been occupied";
            else {
                parkingState.get(parkingState.indexOf(spotToOccupy)).setOccupied(true);
                response = "Spot has been occupied successfully";
            }
        }
        return response;
    }

    public String vacateSpot(String AreaId, String SpotId) {
        ParkingSpot spotToOccupy = new ParkingSpot(AreaId, SpotId);
        String response;
        if (!parkingState.contains(spotToOccupy))
            response = "Spot " + spotToOccupy + " has not been found";
        else {
            if (!parkingState.get(parkingState.indexOf(spotToOccupy)).getOccupied())
                response = "Spot had not been occupied";
            else {
                parkingState.get(parkingState.indexOf(spotToOccupy)).setOccupied(false);
                response = "Spot has become vacant successfully";
            }
        }
        return response;
    }

    public List<ParkingSpot> getEntries() {
        return parkingState;
    }

    public List<ParkingSpot> getEntriesFor(String areaId) {
        return parkingState.stream().
                filter(e -> e.getAreaId().equals(areaId)).
                collect(Collectors.toList());
    }

    public List<String> getDistinctAreas() {
        Set<String> areas = new HashSet<>();
        for (ParkingSpot entry : parkingState) {
            areas.add(entry.getAreaId());
        }
        return new ArrayList<>(areas);
    }
}

