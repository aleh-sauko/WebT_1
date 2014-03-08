package by.epam.lw01.bl;

import by.epam.lw01.dto.CaveDTO;
import by.epam.lw01.dto.GeneralDTO;
import by.epam.lw01.dto.IntegerDTO;
import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by aleh on 22.02.14.
 *
 * Return Treasures which common values max and not above given sum.
 * Used Dynamic Programing.
 */
public class TreasuresOnSum implements Command {

    private List<Treasure> treasures;
    private List<Treasure> allTreasures;
    private Iterator<Treasure> iterator;
    private int[][] d;
    private int sum;

    /**
     * Algorithm O(Count Treasure * Sum).
     * WARNING : Don't touch, all works.
     */
    @Override
    public GeneralDTO execute(GeneralDTO dto) {
        sum = ((IntegerDTO)dto).sum;

        treasures = new ArrayList<Treasure>();
        allTreasures = new ArrayList<Treasure>();
        iterator = Cave.getInstance().getTreasures();

        int size = Cave.getInstance().getCountOfTreasures();

        d = new int[size+1][sum+1];
        for (int i = 1; i <= size; i++) {
            Treasure currTreasure = iterator.next();
            for (int c = 0; c <= sum; c++) {
                if (c >= currTreasure.getValue()) {
                    d[i][c] = Math.max(d[i - 1][c], d[i-1][c-currTreasure.getValue()] + currTreasure.getValue());
                } else {
                    d[i][c] = d[i-1][c];
                }
            }
            allTreasures.add(currTreasure);
        }
        retrievesTreasures(size, sum);

        CaveDTO res = new CaveDTO();
        res.iterator = treasures.iterator();
        return res;
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
}
