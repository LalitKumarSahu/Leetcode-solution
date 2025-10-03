class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int start = 0; // txt ke pointer
        
        while (start <= n - m) {
            int end = 0; // pat ka pointer
            
            while (end < m && txt.charAt(start + end) == pat.charAt(end)) {
                end++;
            }
            
            if (end == m) { // pura pattern match ho gaya
                res.add(start);  // ✅ 0-based indexing
            }
            
            start++; // next index try karenge
        }
        
        return res;
    }
}
