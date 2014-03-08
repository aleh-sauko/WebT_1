package by.epam.lw01.bl;

import by.epam.lw01.dto.CaveDTO;
import by.epam.lw01.dto.GeneralDTO;
import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by aleh on 22.02.14.
 *
 * Show all treasure in Cave.
 */
public class ShowTreasures implements Command {
    @Override
    public GeneralDTO execute(GeneralDTO param) {
        CaveDTO dto = new CaveDTO();
        dto.iterator = Cave.getInstance().getTreasures();
        return dto;
    }
}
