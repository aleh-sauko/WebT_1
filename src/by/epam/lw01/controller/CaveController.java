package by.epam.lw01.controller;

import by.epam.lw01.bl.*;
import by.epam.lw01.util.UserCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleh on 22.02.14.
 */
public class CaveController {

    private Map<UserCommand, Command> commandMap;

    public CaveController() {
        commandMap = new HashMap<UserCommand, Command>();
        commandMap.put(UserCommand.CREATE_CAVE, new CaveCreate());
        commandMap.put(UserCommand.ADD_TREASURE, new AddTreasure());
        commandMap.put(UserCommand.SHOW_TREASURE, new ShowTreasures());
        commandMap.put(UserCommand.SHOW_MOST_EXPENSIVE_TREASURE, new ShowMostExpensiveTreasure());
        commandMap.put(UserCommand.TREASURE_ON_SUM, new TreasuresOnSum());
    }

    public Object performCommand(UserCommand command, Object[] params) {
        if (params != null) {
            commandMap.get(command).setParams(params);
        }
        commandMap.get(command).execute();
        return commandMap.get(command).getResult();
    }

    public Object getResult(UserCommand command) {
        return commandMap.get(command).getResult();
    }
}
