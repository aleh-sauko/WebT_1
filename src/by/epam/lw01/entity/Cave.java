package by.epam.lw01.entity;

import java.util.ArrayList;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>Entity of cave which keep treasure</p>
 * Used singleton for access.
 */
public class Cave {

    private static Cave instance;

    private String name;
    private ArrayList<Treasure> treasures;

    private Cave() {
        treasures = new ArrayList<Treasure>();
    }

    public static Cave getInstance() {
        if (instance == null) {
            synchronized (Cave.class) {
                if (instance == null) {
                    instance = new Cave();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    @Override
    public String toString() {
        return Cave.class.getSimpleName() + " with name " + name + ".";
    }
}
