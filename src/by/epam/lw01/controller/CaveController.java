package by.epam.lw01.controller;

import by.epam.lw01.bl.*;
import by.epam.lw01.util.UserCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>Cave controller use in @see CaveView<p/>
 *
 * Used Map for execute appropriate command (init in constructor)
 * (UserCommand @see UserCommand -> Command @see Command).
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

    /**
     * Execute appropriate command with given params used pattern Command.
     * @param command Enum @see UserCommand.
     * @param params Parameters pass to command.
     * @return Result of command.
     */
    public Object performCommand(UserCommand command, Object[] params) {
        if (params != null) {
            commandMap.get(command).setParams(params);
        }
        commandMap.get(command).execute();
        return commandMap.get(command).getResult();
    }

    /**
     * @param command Enum @see UserCommand.
     * @return Get result of last execution command appropriate UserCommand.
     */
    public Object getResult(UserCommand command) {
        return commandMap.get(command).getResult();
    }
}
