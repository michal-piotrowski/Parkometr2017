package pl.edu.agh.backCarPark.controller;

import java.util.*;

/**
 * Created by Michał Piotrowski on 2017-08-21.
 *
 * All available CLI operations are listed here
 */
public class ActionTypes {
    private static List<List<String>> actionsAndArgs;
    // those will use the webService
    public static final String ADD_SPOT = "addspot";
    public static final String REMOVE_SPOT = "removespot";
    public static final String OCCUPY_SPOT = "occupyspot";
    public static final String VACATE_SPOT = "vacatespot";
    public static final String PRINT_SPOTS = "printspots";

    public static final String EXIT = "exit";

    public static final String NOT_RECOGNISED = "ACTION_NOT_RECOGNISED";
    public static final String BAD_N_OF_ARGS = "BAD_N_OF_ARGS";



    static {
        actionsAndArgs = new ArrayList<>();
        actionsAndArgs.add(new ArrayList<>(Arrays.asList(ADD_SPOT, "AreaID", "SpotID")));
        actionsAndArgs.add(new ArrayList<>(Arrays.asList(REMOVE_SPOT, "AreaID", "SpotID")));
        actionsAndArgs.add(new ArrayList<>(Arrays.asList(OCCUPY_SPOT, "AreaID", "SpotID")));
//        actionsAndArgs.add(new ArrayList<>(Arrays.asList(OCCUPY_SPOT, "AreaID", "SpotID", "TimeInSeconds")));
        actionsAndArgs.add(new ArrayList<>(Arrays.asList(VACATE_SPOT, "AreaID", "SpotID")));
        actionsAndArgs.add(new ArrayList<>(Arrays.asList(PRINT_SPOTS)));
        actionsAndArgs.add(new ArrayList<>(Arrays.asList(EXIT)));
    }

    public static String getAvailableActionsPrettyFormatted() {
        StringBuilder actionsBuilder = new StringBuilder();
        for (List<String> action: actionsAndArgs) {
            actionsBuilder.append(action.get(0));
            for (String s: action.subList(1, action.size()))
                actionsBuilder.append(" <" + s + ">");
            actionsBuilder.append("\n");
        }
        return actionsBuilder.toString();
    }

    public static List<Integer> nArgsByAction(String actionType) {
        List<Integer> availableCounts = new ArrayList<>();
        for(List<String> action:actionsAndArgs){
            if (action.get(0).equals(actionType))
                availableCounts.add(action.size() - 1);
        }
        return availableCounts;
    }
}
