package by.epam.lw01.entity;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>Entity treasure which have name and value.</p>
 * Nothing difficult.
 */
public class Treasure {

    private String name;
    private int value;

    public Treasure(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Treasure.class.getSimpleName() + " with name " + name + " have value " + value + ".";
    }
}
