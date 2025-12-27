import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan {
  class StockSpanner {
    Stack<Integer>s;
    ArrayList<Integer>list;
    public StockSpanner() {
        s = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        // price is greater than stack top
        while(!s.isEmpty() && list.get(s.peek()) <= price){
            s.pop();
        }
        int prevGreaterIdx = (s.isEmpty())?-1:s.peek();
        int currIdx = list.size() - 1;
        int ans = currIdx - prevGreaterIdx;
        s.push(currIdx);
        return ans;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
