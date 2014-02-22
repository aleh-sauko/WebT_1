package by.epam.lw01;

import by.epam.lw01.util.UserCommand;
import by.epam.lw01.view.CaveView;

/**
 * Created by aleh on 22.02.14.
 */
public class Main {

    public static void main(String[] args) {

        CaveView caveView = new CaveView();
        caveView.invokeUserCommand(UserCommand.CREATE_CAVE);
        caveView.invokeUserCommand(UserCommand.ADD_TREASURE);
        caveView.invokeUserCommand(UserCommand.SHOW_TREASURE);
        caveView.invokeUserCommand(UserCommand.SHOW_MOST_EXPENSIVE_TREASURE);
        caveView.invokeUserCommand(UserCommand.TREASURE_ON_SUM);

    }
}
