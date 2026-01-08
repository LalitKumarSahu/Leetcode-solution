  
import java.util.*;
public class FractionalKnapsack {
    class Item {
        int val;
        int wt;

        Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;

        // step 1: create item array
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        // step 2: sort items by value/weight in descending order
        Arrays.sort(items, (a, b) -> 
            Double.compare((double) b.val / b.wt, (double) a.val / a.wt)
        );

        // step 3: pick items
        double totalVal = 0.0;

        for (int i = 0; i < n; i++) {
            if (items[i].wt <= capacity) {
                totalVal += items[i].val;
                capacity -= items[i].wt;
            } else {
                totalVal += ((double) items[i].val / items[i].wt) * capacity;
                break;
            }
        }

        return totalVal;
    }
}

