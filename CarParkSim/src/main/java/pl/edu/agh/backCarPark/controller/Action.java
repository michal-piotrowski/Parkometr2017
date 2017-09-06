package pl.edu.agh.backCarPark.controller;


import pl.edu.agh.backCarPark.model.Parking;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Michał Piotrowski on 2017-08-21.
 */
public class Action {
    private static Scanner scanner;
    private static Parking parking;
    private byte menuStage;

    private enum UserInputVerifResult {CORRECT, BAD_N_OF_ARGS, EXIT}

    static {
        scanner = new Scanner(System.in);
        parking = Parking.getInstance();
    }

    static List<String> queryForAction() {
        System.out.println("Choose an operation to perform in a virtual parking: \n");
        System.out.println(ActionTypes.getAvailableActionsPrettyFormatted());
        String input = scanner.nextLine();
        List<String> spaceSeparated = Arrays.asList(input.split(" "));

        UserInputVerifResult res = verifyInput(spaceSeparated);
        if (res.equals(UserInputVerifResult.BAD_N_OF_ARGS)) {
            System.out.println("Bad number of arguments");
            return Arrays.asList(ActionTypes.BAD_N_OF_ARGS);
        } else if (res.equals(UserInputVerifResult.EXIT)) {
            return Arrays.asList(ActionTypes.EXIT);
        }

        return spaceSeparated;
    }

    static String executeAction(List<String> actionNameAndArgs) throws Exception {
        String actionName = actionNameAndArgs.get(0);

        List<String> arguments = actionNameAndArgs.subList(1, actionNameAndArgs.size());
        switch (actionName) {
            // User input based flow & display of parking current state
            case ActionTypes.EXIT:
                System.out.println("GG WP");
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.EXIT;
            case ActionTypes.BAD_N_OF_ARGS:
                System.out.println("Incorrect number of arguments");
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.BAD_N_OF_ARGS;

            case ActionTypes.PRINT_SPOTS:
                System.out.println(parking.toString());
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.PRINT_SPOTS;
            // ------------------------------ Parking Layout & Occupation of spots
            case ActionTypes.ADD_SPOT:
                parking.addSpot(arguments.get(0), arguments.get(1));
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.ADD_SPOT;
            case ActionTypes.REMOVE_SPOT:
                parking.removeSpot(arguments.get(0), arguments.get(1));
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.REMOVE_SPOT;
            case ActionTypes.OCCUPY_SPOT:
                if (arguments.size() == 2)
                    parking.occupySpot(arguments.get(0), arguments.get(1));
                else
                    parking.occupySpot(arguments.get(0), arguments.get(1), Long.parseLong(arguments.get(2)));
                System.out.println("Press Enter to continue");
                System.in.read();
                return ActionTypes.OCCUPY_SPOT;
            case ActionTypes.VACATE_SPOT:
                parking.vacateSpot(arguments.get(0), arguments.get(1));
                return ActionTypes.VACATE_SPOT;
            //------------------------------
            default:
                System.out.println("I've not recognised the input");
                return ActionTypes.NOT_RECOGNISED;
        }
    }

    /*
        Verify correctness of user input pertaining to suggested syntax in cli mode
     */
    private static UserInputVerifResult verifyInput(List<String> input) {
        String actionName = input.get(0);
        int nArgs = input.size() - 1;
        if (actionName.toLowerCase().replaceAll("\\s", "").equals("exit"))
            return UserInputVerifResult.EXIT;
        System.out.println(ActionTypes.nArgsByAction(actionName));
        System.out.println(nArgs);
        if (!ActionTypes.nArgsByAction(actionName).contains(nArgs))
            return UserInputVerifResult.BAD_N_OF_ARGS;
        return UserInputVerifResult.CORRECT;
    }


}
