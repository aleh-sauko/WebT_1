package by.epam.lw01.bl;

import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

/**
 * Created by aleh on 22.02.14.
 */
public class AddTreasure implements Command {

    private String name;
    private Integer value;

    @Override
    public void setParams(Object[] params) {
        name = (String)params[0];
        value = (Integer)params[1];
    }

    @Override
    public void execute() {
        Cave.getInstance().addTreasure(new Treasure(name, value));
    }

    @Override
    public Object getResult() {
        return null;
    }
}
