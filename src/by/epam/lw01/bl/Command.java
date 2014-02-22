package by.epam.lw01.bl;

/**
 * Created by aleh on 22.02.14.
 */
public interface Command {
    public void setParams(Object[] params);
    public void execute();
    public Object getResult();
}
