public class 1408. String Matching in an Array {
  class Solution {
    public List<String> stringMatching(String[] words) {
        List<String>res = new ArrayList<>();
        int n = words.length;
        // j hamesa 0 start hoga i aage hota rhega
        // i = 0 = mass, j = 0 to n , mass kisi me nhi hai i = 1=as, j= 0 to n
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j) continue;

                if(words[j].contains(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
}
