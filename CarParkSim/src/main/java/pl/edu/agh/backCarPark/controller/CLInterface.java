package pl.edu.agh.backCarPark.controller;

import pl.edu.agh.backmainapp.webservice.NotifyMainModuleBean;
import pl.edu.agh.backmainapp.webservice.NotifyMainModuleBeanService;

import java.io.IOException;

/**
 * Created by Michał Piotrowski on 2017-08-21.
 */
public class CLInterface {

    private static NotifyMainModuleBeanService service;
    private static NotifyMainModuleBean port;

    static {
        service = new NotifyMainModuleBeanService();
        port = service.getNotifyMainModuleBeanPort();
    }

    public static void main(String[] args) {
        System.out.println("Welcome!");

        try {
            while (true) {
                if ((Action.executeAction(Action.queryForAction(), port)).equals("exit"))
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
