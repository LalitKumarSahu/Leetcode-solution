public class Stock Buy and Sell – Max one Transaction Allowed {
  // User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        
        for(int i = 1; i<prices.length;i++){
            int cost = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit, cost);
            buyPrice  = Math.min(buyPrice, prices[i]);
        }
        return maxProfit;
     
    }
}
  
}
