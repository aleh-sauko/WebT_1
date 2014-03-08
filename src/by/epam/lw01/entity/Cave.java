package by.epam.lw01.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by aleh on 22.02.14.
 *
 * <p>Entity of cave which keep treasure</p>
 * Used singleton for access.
 */
public class Cave {

    private static Cave instance;

    private String name;
    private List<Treasure> treasures;

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

    public Iterator<Treasure> getTreasures() {
        return treasures.iterator();
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    public int getCountOfTreasures() {
        return treasures.size();
    }

    @Override
    public String toString() {
        return Cave.class.getSimpleName() + " with name " + name + ".";
    }
}
