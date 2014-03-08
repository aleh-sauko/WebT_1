package by.epam.lw01.bl;

import by.epam.lw01.dto.CaveDTO;
import by.epam.lw01.dto.GeneralDTO;
import by.epam.lw01.dto.TreasureDTO;
import by.epam.lw01.entity.Cave;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>Command to create cave with passed name.</p>
 */
public class CaveCreate implements Command {

    @Override
    public GeneralDTO execute(GeneralDTO param) throws CommandCastException {

        if (!(param instanceof CaveDTO)) {
            throw new CommandCastException();
        }

        CaveDTO dto = (CaveDTO) param;
        Cave result = Cave.getInstance();
        result.setName(dto.name);
        dto.cave = result;
        return dto;
    }
}
