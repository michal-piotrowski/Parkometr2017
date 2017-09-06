package pl.edu.agh.backCarPark.model;

import javafx.scene.effect.Light;

import java.awt.geom.Area;
import java.util.*;

/**
 * Created by Michał Piotrowski on 2017-08-17.
 */
public class Parking {
    // Map< GlobalSpotId, IsOccupied >
    private Map<String, Boolean> parkingState;
    private static volatile Parking instance;

    private Parking() {
        parkingState = new TreeMap<>();
        parkingState.put("B01", false);
        parkingState.put("B02", false);
        parkingState.put("B03", false);
        parkingState.put("B04", false);
    }

    public String toString() {
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

    public void addSpot(String AreaId, String SpotId) {
        String newSpot = AreaId.concat(SpotId);
        if (parkingState.containsKey(newSpot))
            System.out.println("Spot already exists");
        else {
            System.out.println("Spot " + SpotId + " in area: " + AreaId + " has been successfully created");
            parkingState.put(newSpot, false);
        }
    }

    public void removeSpot(String AreaId, String SpotId) {
        if (!parkingState.containsKey(AreaId.concat(SpotId)))
            System.out.println("Spot not found therefore not removed");
        else {
            parkingState.remove(AreaId.concat(SpotId));
            System.out.println("removing " + AreaId.concat(SpotId));
        }
    }

    public void occupySpot(String AreaId, String SpotId) {
        if (parkingState.get(AreaId.concat(SpotId).equals(true)))
            System.out.println("Spot had already been occupied");
        else {
            parkingState.put(AreaId.concat(SpotId), true);
            System.out.println("Spot has been occupied successfully");
        }
    }
    // !!!
    public void occupySpot(String AreaId, String SpotId, Long timeInSeconds) {
        if (parkingState.get(AreaId.concat(SpotId)).equals(true))
            System.out.println("Spot had already been occupied");
        else {
            parkingState.put(AreaId.concat(SpotId), true);
            System.out.println("Spot has been occupied successfully");
        }
    }

    public void vacateSpot(String AreaId, String SpotId) {
        if (parkingState.get(AreaId.concat(SpotId).equals(false)))
            System.out.println("Spot had not been occupied");
        else {
            parkingState.put(AreaId.concat(SpotId), false);
            System.out.println("Spot has become vacant successfully");
        }
    }

    public static Parking getInstance() {
        Parking parking = instance;
        if (parking == null) {
            synchronized (Parking.class) {
                if (parking == null)
                    parking = new Parking();
            }
        }
        return parking;
    }

    public Set<Map.Entry<String, Boolean>> getEntries() {
        return parkingState.entrySet();
    }
}
