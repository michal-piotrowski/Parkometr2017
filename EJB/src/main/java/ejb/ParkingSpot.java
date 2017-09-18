package ejb;

/**
 * Created by Michał Piotrowski on 2017-09-09.
 */
public class ParkingSpot {
    private String areaId;
    private String spotId;
    private String composed;
    private Boolean occupied;

    public String getComposed() {
        return composed;
    }

    public void setComposed(String composed) {
        this.composed = composed;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }


    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }


    public ParkingSpot() {
        areaId="";
        spotId="";
    }

    public ParkingSpot(String composedId) {
        areaId = composedId.split("\\d")[0];
        spotId = composedId.split("[a-zA-Z]")[0];
        occupied=false;
    }

    public ParkingSpot(String areaId, String spotId, Boolean occupied) {
        this.areaId = areaId;
        this.spotId = spotId;
        this.occupied = occupied;
        this.composed=areaId.concat(spotId);
    }

    public ParkingSpot(String composed, Boolean occupied) {
        this.composed=composed;
        this.occupied=occupied;
    }
}
