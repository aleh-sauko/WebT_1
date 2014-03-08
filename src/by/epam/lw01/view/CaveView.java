package by.epam.lw01.view;

import by.epam.lw01.controller.CaveController;
import by.epam.lw01.dto.CaveDTO;
import by.epam.lw01.dto.IntegerDTO;
import by.epam.lw01.dto.TreasureDTO;
import by.epam.lw01.entity.Treasure;
import by.epam.lw01.util.UserCommand;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>View used for changed data between user and model.<p/>
 * <p>User CaveController @see CaveController</p>
 */
public class CaveView {

    private CaveController caveController = CaveController.getInstance();

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
        CaveDTO dto = new CaveDTO();
        dto.name = "Gates of Hell";
        System.out.println(((CaveDTO)caveController.performCommand(UserCommand.CREATE_CAVE, dto)).cave);
    }

    public void addTreasures() {
        for (int i = 0; i < 100; i++) {
            TreasureDTO dto = new TreasureDTO();
            dto.name = "Treasure " + i;
            dto.value = new Double(Math.random()*1000).intValue();
            caveController.performCommand(UserCommand.ADD_TREASURE, dto);
        }
    }

    public void showTreasure() {
        System.out.println();
        Iterator<Treasure> treasures =
                ((CaveDTO)caveController.performCommand(UserCommand.SHOW_TREASURE, null)).iterator;
        while (treasures.hasNext()) {
            System.out.println(treasures.next());
        }
        System.out.println();
    }

    private void showMostExpensiveTreasure() {
        System.out.println("Most Expensive treasure : " + ((TreasureDTO)caveController.performCommand(UserCommand.SHOW_MOST_EXPENSIVE_TREASURE, null)).treasure);
    }

    private void treasureOnSum() {
        IntegerDTO dto = new IntegerDTO();
        dto.sum = 3000;
        System.out.println();
        System.out.println("Treasure on sum " + dto.sum + " : ");
        Iterator<Treasure> treasures =
                ((CaveDTO)caveController.performCommand(UserCommand.TREASURE_ON_SUM, dto)).iterator;
        int totalCost = 0;
        while (treasures.hasNext()) {
            Treasure treasure = treasures.next();
            System.out.println("\t" + treasure);
            totalCost += treasure.getValue();
        }
        System.out.println("With Total Cost : " + totalCost + ".");
        System.out.println();
    }
}
