package pl.edu.agh.backCarPark.controller;

import pl.edu.agh.backmainapp.webservice.NotifyMainModuleBean;
import pl.edu.agh.backmainapp.webservice.NotifyMainModuleBeanService;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Base64;

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

    public static void main(String[] args) throws Exception {
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
//        String password = "asd";
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        byte[] passwordBytes = password.getBytes();
//        byte[] hash = md.digest(passwordBytes);
//        String passwordHash =
//                Base64.getEncoder().encodeToString(hash);
//        System.out.println("password hash: " + passwordHash);
    }

}
