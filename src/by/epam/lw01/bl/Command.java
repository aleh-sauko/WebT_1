package by.epam.lw01.bl;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>Interface for Command pattern.</p>
 */
public interface Command {
    /**
     * Used to set appropriate params if need.
     * @param params Passed parameters.
     */
    public void setParams(Object[] params);
    public void execute();
    /**
     * Get result of last executed command.
     * @return
     */
    public Object getResult();
}
