package pl.edu.agh.backCarPark.controller;


import pl.edu.agh.backmainapp.webservice.NotifyMainModuleBean;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Michał Piotrowski on 2017-08-21.
 */
public class Action {
    private static Scanner scanner;

    private enum UserInputVerifResult {CORRECT, BAD_N_OF_ARGS, EXIT, NOT_RECOGNISED}

    static {
        scanner = new Scanner(System.in);
    }

    static List<String> queryForAction() {
        System.out.println("Choose an operation to perform in a virtual parking: \n");
        System.out.println(ActionTypes.getAvailableActionsPrettyFormatted());
        String input = scanner.nextLine();
        List<String> spaceSeparated = Arrays.asList(input.split(" "));

        UserInputVerifResult res = verifyInput(spaceSeparated);
        if (res.equals(UserInputVerifResult.BAD_N_OF_ARGS)) {
            return Arrays.asList(ActionTypes.BAD_N_OF_ARGS);
        } else if (res.equals(UserInputVerifResult.EXIT)) {
            return Arrays.asList(ActionTypes.EXIT);
        }

        return spaceSeparated;
    }

    static String executeAction(List<String> actionNameAndArgs, NotifyMainModuleBean port) throws Exception {
        String actionName = actionNameAndArgs.get(0);
        List<String> arguments = actionNameAndArgs.subList(1, actionNameAndArgs.size());
        switch (actionName) {

            // ------------------------------ Parking Layout & Occupation of spots ----------------------
            case ActionTypes.ADD_SPOT:
                System.out.println(port.notifyaddSpot(arguments.get(0), arguments.get(1)));
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.ADD_SPOT;
            case ActionTypes.REMOVE_SPOT:
                System.out.println(port.notifyRemoveSpot(arguments.get(0), arguments.get(1)));
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.REMOVE_SPOT;
            case ActionTypes.OCCUPY_SPOT:
                System.out.println(port.notifyOccupySpot(arguments.get(0), arguments.get(1)));
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.OCCUPY_SPOT;
            case ActionTypes.VACATE_SPOT:
                System.out.println(port.notifyVacateSpot(arguments.get(0), arguments.get(1)));
//                parking.vacateSpot(arguments.get(0), arguments.get(1));
                return ActionTypes.VACATE_SPOT;
            // ------------------------------ User input based flow & display of parking current state ----------------------
            case ActionTypes.EXIT:
                System.out.println("GG WP");
                return ActionTypes.EXIT;
            case ActionTypes.BAD_N_OF_ARGS:
                System.out.println("Incorrect number of arguments");
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.BAD_N_OF_ARGS;

            case ActionTypes.PRINT_SPOTS:
                System.out.println(port.notifyPrintSpots());
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.PRINT_SPOTS;
            //------------------------------
            default:
                System.out.println("Input is unclear to me");
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.NOT_RECOGNISED;

        }
    }

    /*
        Verify correctness of user input pertaining to suggested syntax in cli mode
     */
    private static UserInputVerifResult verifyInput(List<String> input) {
        String actionName = input.get(0).toLowerCase().replaceAll("\\s", "");
        int nArgs = input.size() - 1;
        if (!ActionTypes.getAvailableActionsPrettyFormatted().contains(actionName) || actionName.equals(""))
            return UserInputVerifResult.NOT_RECOGNISED;
        if (actionName.equals("exit"))
            return UserInputVerifResult.EXIT;
        if (!ActionTypes.nArgsByAction(actionName).contains(nArgs))
            return UserInputVerifResult.BAD_N_OF_ARGS;
        return UserInputVerifResult.CORRECT;
    }
}
