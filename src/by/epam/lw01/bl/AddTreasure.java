package by.epam.lw01.bl;

import by.epam.lw01.dto.GeneralDTO;
import by.epam.lw01.dto.TreasureDTO;
import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>Add Treasure to cave with given name and value.</p>
 */
public class AddTreasure implements Command {

    @Override
    public GeneralDTO execute(GeneralDTO param) throws CommandCastException {

        if (!(param instanceof TreasureDTO)) {
            throw new CommandCastException();
        }

        TreasureDTO dto = (TreasureDTO) param;
        Cave.getInstance().addTreasure(new Treasure(dto.name,
                dto.value));
        return null;
    }
}
