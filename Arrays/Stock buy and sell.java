public class Stock buy and sell {

  class Solution {
    // max - only one time buy and sell 
    int stockBuySell1(int arr[]) {
        int min = arr[0];
        int profit = 0;

        for(int i = 1; i < arr.length; i++){
            int cost = arr[i] - min;     // sell today
            profit = Math.max(profit, cost); // update best profit
            min = Math.min(min, arr[i]);     // update buy day
        }

        return profit;
    }
}
// isme multiple buy and sell kar sakte hai 
class Solution {
    int stockBuySell2(int arr[]) {
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }

        return profit;
    }
}

  
}
