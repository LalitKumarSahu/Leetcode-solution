import java.util.*;
class Solution {
    //tc:(2^N) + N , sc:O(N)

    public List<List<String>> partition(String s) {
        List<List<String>>res = new ArrayList<>();
        int n = s.length();
        List<String>curr = new ArrayList<>();
        recBack(s, 0 , curr, res);
        return res;
    }
  
    public void recBack(String s, int partionIdx, List<String>curr, List<List<String>>res  ){
        int n = s.length();
        if(partionIdx == n){
          res.add(new ArrayList<>(curr));
          return;
        }
        for(int end = partionIdx; end <n; end++){ // start 0th idx se partition
            if(isPalindrome(s,partionIdx, end )){ // chekc palindrome 0 to 0
                curr.add(s.substring(partionIdx, end+1)); // substring ko res me add kar denge = a
                recBack(s, end+1, curr, res);
                curr.remove(curr.size()-1);

            }
        }
    }
      public boolean isPalindrome(String s, int st, int end){
        while(st < end){
            if(s.charAt(st) != s.charAt(end)){
                return false;
            }
            st++;end--;
        }
        return true;
    }
}