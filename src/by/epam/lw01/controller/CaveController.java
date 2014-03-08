package by.epam.lw01.controller;

import by.epam.lw01.bl.*;
import by.epam.lw01.dto.GeneralDTO;
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
public final class CaveController {

    private Map<UserCommand, Command> commandMap;
    private static CaveController instance;

    private CaveController() {
        commandMap = new HashMap<UserCommand, Command>();
        commandMap.put(UserCommand.CREATE_CAVE, new CaveCreate());
        commandMap.put(UserCommand.ADD_TREASURE, new AddTreasure());
        commandMap.put(UserCommand.SHOW_TREASURE, new ShowTreasures());
        commandMap.put(UserCommand.SHOW_MOST_EXPENSIVE_TREASURE, new ShowMostExpensiveTreasure());
        commandMap.put(UserCommand.TREASURE_ON_SUM, new TreasuresOnSum());
    }

    public static CaveController getInstance() {
        if (instance == null) {
            synchronized (CaveController.class) {
                if (instance == null) {
                    instance = new CaveController();
                }
            }
        }
        return instance;
    }

    /**
     * Execute appropriate command with given params used pattern Command.
     * @param command Enum @see UserCommand.
     * @param param Parameters pass to command.
     * @return Result of command.
     */
    public GeneralDTO performCommand(UserCommand command, GeneralDTO param) {
        GeneralDTO dto = null;
        try {
            dto = commandMap.get(command).execute(param);
        } catch (CommandCastException e) {
            e.printStackTrace();
        }
        return dto;
    }

}
