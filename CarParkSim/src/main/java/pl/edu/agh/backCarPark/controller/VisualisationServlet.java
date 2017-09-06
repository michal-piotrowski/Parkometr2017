package pl.edu.agh.backCarPark.controller;

import pl.edu.agh.backCarPark.model.Parking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Michał Piotrowski on 2017-08-17.
 */
@WebServlet("/carpark")
public class VisualisationServlet extends HttpServlet{

    private Parking model;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        model = Parking.getInstance();
        for (Map.Entry<String, Boolean> entry: model.getEntries())
            pw.write("<h1> " + entry.getKey() + ": " + (entry.getValue()?"occupied":"vacant") + "</h1>" );
        pw.close();
    }
}
