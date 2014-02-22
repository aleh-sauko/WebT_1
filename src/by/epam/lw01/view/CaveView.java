package by.epam.lw01.view;

import by.epam.lw01.controller.CaveController;
import by.epam.lw01.entity.Treasure;
import by.epam.lw01.util.UserCommand;

import java.util.ArrayList;

/**
 * Created by aleh on 22.02.14.
 */
public class CaveView {

    private CaveController caveController = new CaveController();

    public void invokeUserCommand(UserCommand command) {
        switch (command) {
            case CREATE_CAVE:
                createCave();
                break;
            case ADD_TREASURE:
                addTreasures();
                break;
            case SHOW_TREASURE:
                showTreasure();
                break;
            case SHOW_MOST_EXPENSIVE_TREASURE:
                showMostExpensiveTreasure();
                break;
            case TREASURE_ON_SUM:
                treasureOnSum();
                break;
        }
    }

    public void createCave() {
        Object[] params = {"Gates of Hell"};
        System.out.println(caveController.performCommand(UserCommand.CREATE_CAVE, params));
    }

    public void addTreasures() {
        for (int i = 0; i < 100; i++) {
            Object[] params = {"Treasure " + i, new Double(Math.random()*1000).intValue()};
            caveController.performCommand(UserCommand.ADD_TREASURE, params);
        }
    }

    public void showTreasure() {
        System.out.println();
        ArrayList<Treasure> treasures =
                (ArrayList<Treasure>) caveController.performCommand(UserCommand.SHOW_TREASURE, null);
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
        System.out.println();
    }

    private void showMostExpensiveTreasure() {
        System.out.println("Most Expensive treasure : " + caveController.performCommand(UserCommand.SHOW_MOST_EXPENSIVE_TREASURE, null));
    }

    private void treasureOnSum() {
        Object[] params = { new Integer(3000) };
        System.out.println();
        System.out.println("Treasure on sum " + params[0] + " : ");
        ArrayList<Treasure> treasures =
                (ArrayList<Treasure>) caveController.performCommand(UserCommand.TREASURE_ON_SUM, params);
        int totalCost = 0;
        for (Treasure treasure : treasures) {
            System.out.println("\t" + treasure);
            totalCost += treasure.getValue();
        }
        System.out.println("With Total Cost : " + totalCost + ".");
        System.out.println();
    }

    public void showResult(UserCommand command) {
        System.out.println(caveController.getResult(command));
    }
}
