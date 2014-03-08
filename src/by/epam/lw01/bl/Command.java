package by.epam.lw01.bl;

import by.epam.lw01.dto.GeneralDTO;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>Interface for Command pattern.</p>
 */
public interface Command {
    public GeneralDTO execute(GeneralDTO param) throws CommandCastException;
}
