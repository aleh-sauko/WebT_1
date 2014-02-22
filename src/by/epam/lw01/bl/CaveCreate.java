package by.epam.lw01.bl;

import by.epam.lw01.entity.Cave;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>Command to create cave with passed name.</p>
 */
public class CaveCreate implements Command {

    private Cave result = null;
    private String name;

    @Override
    public void setParams(Object[] params) {
        name = (String) params[0];
    }

    @Override
    public void execute() {
        result = Cave.getInstance();
        result.setName(name);
    }

    @Override
    public Cave getResult() {
        return result;
    }
}
