public class StockSpanProblem {
  class Solution {
    // maximum number of consecutive days from todays
    //price <= todays price
    // prevhigh vala day aur curr day ke beech ka jtine day aate hai vo curr day ka span hota hai
   // prevhigh = imidiate greater value for any days
   // her dayke liye uska prevhigh nikal lo fir span = i - prevHigh
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer>res = new ArrayList<>();
        
        Stack<Integer>s = new Stack<>();
        
        for(int i = 0; i<n; i++){
            
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res.add(i+1);
            }else{
                res.add(i - s.peek());
            }
            s.push(i);
        }
        return res;
        
    }
}
}
