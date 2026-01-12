// class Solution {
//     //tc:O(N * 2^N) , sc-n substring
//     int maxCount;
//     public int maxUniqueSplit(String s) {
//         maxCount = 0;
//         HashSet<String>set = new HashSet<>();
//         backtrack(s, set, 0);
//         return maxCount;
//     }
//     // generating all posibility substring  = 2^n
//     // every posiblity ke liye n option hai
//     public void backtrack(String s, HashSet<String>set, int idx){
//         int n = s.length();
//         if(idx == n){
//             maxCount = Math.max(maxCount, set.size());
//             return;
//         }
//         for(int i = idx; i<n; i++){
//             String sub = s.substring(idx, i+1);
//             if(!set.contains(sub)){
//                 set.add(sub);
//                 backtrack(s, set, i+1);
//                 set.remove(sub);
//             }
//         }
//     }
// }

class Solution {
    int maxCount;
    public int maxUniqueSplit(String s) {
        maxCount = 0;
        HashSet<String>set = new HashSet<>();
        backtrack(s, set, 0);
        return maxCount;
     
  }
  public void backtrack(String s, HashSet<String>set, int idx){
        int n  = s.length();
        if(idx == n){
            maxCount = Math.max(maxCount, set.size());
            return;
        }
        for(int i = idx; i < n; i++){
            String sub = s.substring(idx, i+1);
            if(!set.contains(sub)){
                set.add(sub);
                backtrack(s, set, i+1);
                set.remove(sub);
            }
        }
  }
}