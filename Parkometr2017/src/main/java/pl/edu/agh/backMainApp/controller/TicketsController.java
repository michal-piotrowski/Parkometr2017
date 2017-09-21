
package pl.edu.agh.backMainApp.controller;

import ejb.interfaces.ParkingService;
import pl.edu.agh.backMainApp.model.Ticket;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał Piotrowski on 2017-09-20.
 */
@Path("/tickets")
@Produces(value = MediaType.APPLICATION_JSON)
public class TicketsController {
    List<Ticket> availableTickets = new ArrayList<>();

    @EJB
    ParkingService parkingService;

    @GET
    public List<Duration> getAvailableTickets() {
        return Ticket.getAvailableDurations();

    }

    @POST
    @Path("/{id}")
    public void buyTicket(@PathParam("id") String ticketId){
        System.out.println("what");
    }

}