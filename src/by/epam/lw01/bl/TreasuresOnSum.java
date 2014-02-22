package by.epam.lw01.bl;

import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

import java.util.ArrayList;

/**
 * Created by aleh on 22.02.14.
 *
 * Return Treasures which common values max and not above given sum.
 * Used Dynamic Programing.
 */
public class TreasuresOnSum implements Command {

    private ArrayList<Treasure> treasures;
    private int sum;

    @Override
    public void setParams(Object[] params) {
        sum = (Integer)params[0];
    }


    private  ArrayList<Treasure> allTreasures;
    private int[][] d;

    /**
     * Algorithm O(Count Treasure * Sum).
     */
    @Override
    public void execute() {
        treasures = new ArrayList<Treasure>();
        allTreasures = Cave.getInstance().getTreasures();

        d = new int[allTreasures.size()+1][sum+1];
        for (int i = 1; i <= allTreasures.size(); i++) {
            Treasure currTreasure = allTreasures.get(i-1);
            for (int c = 0; c <= sum; c++) {
                if (c >= currTreasure.getValue()) {
                    d[i][c] = Math.max(d[i - 1][c], d[i-1][c-currTreasure.getValue()] + currTreasure.getValue());
                } else {
                    d[i][c] = d[i-1][c];
                }
            }
        }
        retrievesTreasures(allTreasures.size(), sum);
    }

    /**
     * Recursive proc witch retrieves needed treasures.
     * @param count Remaining count of treasure.
     * @param sum Remaining sum.
     */
    private void retrievesTreasures(int count, int sum) {
        if (d[count][sum] == 0) {
            return;
        }
        if (d[count-1][sum] == d[count][sum]) {
            retrievesTreasures(count-1, sum);
        } else {
            retrievesTreasures(count-1, sum - allTreasures.get(count-1).getValue());
            treasures.add(allTreasures.get(count-1));
        }
    }

    @Override
    public Object getResult() {
        return treasures;
    }
}
