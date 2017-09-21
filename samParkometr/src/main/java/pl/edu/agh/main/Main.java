package pl.edu.agh.main;

//import pl.edu.agh.backMainApp.model.Ticket;

import pl.edu.agh.backMainApp.model.Ticket;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Michał Piotrowski on 2017-09-20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("You have the following duration options for parking spot purchase: ");
        try {

            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target("http://localhost:8080/Parkometr2017-1.0/rest/tickets/");
            Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
            List<Ticket> list = (List<Ticket>) response.getEntity();
            for (Ticket t: list)
                System.out.println(t.getDuration());
        } catch (Exception e) {

            e.printStackTrace();

        }
//        for (Ticket t: tickets)
//            System.out.println(t.getDuration());
    }
}
