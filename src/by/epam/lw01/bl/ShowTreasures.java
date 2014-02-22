package by.epam.lw01.bl;

import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

import java.util.ArrayList;

/**
 * Created by aleh on 22.02.14.
 */
public class ShowTreasures implements Command {

    private ArrayList<Treasure> treasures;

    @Override
    public void setParams(Object[] params) {}

    @Override
    public void execute() {
        treasures = Cave.getInstance().getTreasures();
    }

    @Override
    public ArrayList<Treasure> getResult() {
        return treasures;
    }
}
