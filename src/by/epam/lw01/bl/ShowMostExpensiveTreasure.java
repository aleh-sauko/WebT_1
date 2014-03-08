package by.epam.lw01.bl;

import by.epam.lw01.dto.GeneralDTO;
import by.epam.lw01.dto.TreasureDTO;
import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by aleh on 22.02.14.
 *
 * Return most expensive treasure in cave.
 */
public class ShowMostExpensiveTreasure implements Command {

    @Override
    public GeneralDTO execute(GeneralDTO param) {
        Iterator<Treasure> treasures = Cave.getInstance().getTreasures();

        if (treasures == null && !treasures.hasNext()) {
            return null;
        }

        TreasureDTO dto = new TreasureDTO();
        dto.treasure = treasures.next();
        while (treasures.hasNext()) {
            Treasure treasure = treasures.next();
            if (treasure.getValue() > dto.treasure.getValue()) {
                dto.treasure = treasure;
            }
        }

        return dto;
    }
}
