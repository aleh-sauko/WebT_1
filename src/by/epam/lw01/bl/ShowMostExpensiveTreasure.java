package by.epam.lw01.bl;

import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

import java.util.ArrayList;

/**
 * Created by aleh on 22.02.14.
 *
 * Return most expensive treasure in cave.
 */
public class ShowMostExpensiveTreasure implements Command {

    private Treasure treasure;

    @Override
    public void setParams(Object[] params) {}

    @Override
    public void execute() {
        ArrayList<Treasure> treasures = Cave.getInstance().getTreasures();

        if (treasures == null || treasures.size() == 0) {
            return;
        }

        this.treasure = treasures.get(0);
        for (Treasure treasure : treasures) {
            if (treasure.getValue() > this.treasure.getValue()) {
                this.treasure = treasure;
            }
        }
    }

    @Override
    public Object getResult() {
        return treasure;
    }
}
