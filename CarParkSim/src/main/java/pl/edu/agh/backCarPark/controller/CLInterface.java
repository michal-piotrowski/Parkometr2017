package pl.edu.agh.backCarPark.controller;

import pl.edu.agh.backCarPark.model.Parking;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Michał Piotrowski on 2017-08-21.
 */
public class CLInterface {
    private static Parking parking;

    CLInterface() {
        parking = Parking.getInstance();
    }

    public static void main(String[] args) {
        System.out.println("Welcome!");
        String currentAction;

        try {
            while (true) {
                if ((currentAction = Action.executeAction(Action.queryForAction())).equals("exit"))
                    break;
            }
            System.out.println("Press Enter to continue");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
