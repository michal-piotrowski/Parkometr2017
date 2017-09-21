package pl.edu.agh.backMainApp.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Michał Piotrowski on 2017-09-20.
 */
public class Ticket {


    private static List<Duration> availableDurations = new ArrayList<>(Arrays.asList(
            Duration.ofMinutes(15),
            Duration.ofMinutes(30),
            Duration.ofHours(1),
            Duration.ofHours(1)));

    private Duration duration;
    private String spotId;
    private String areaId;
    private int price;
    private LocalDateTime purchaseTime;

    public Ticket(Duration duration, String spotId, String areaId, int price, LocalDateTime purchaseTime) {
        this.duration = duration;
        this.spotId = spotId;
        this.areaId = areaId;
        this.price = price;
        this.purchaseTime = purchaseTime;
    }

    public Ticket(Duration duration, String spotId, String areaId, int price) {
        this.duration = duration;
        this.spotId = spotId;
        this.areaId = areaId;
        this.price = price;

    }

    public Ticket(Duration duration) {
        this(duration, null, null, 0);

    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }


    public static List<Duration> getAvailableDurations() {
        return availableDurations;
    }

    public static void setAvailableDurations(List<Duration> availableDurations) {
        Ticket.availableDurations = availableDurations;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
