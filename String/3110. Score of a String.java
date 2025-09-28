class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        int n = s.length();
        for(int i=0; i<n-1; i++){
            char currChar = s.charAt(i);
             sum += Math.abs(currChar - s.charAt(i+1));
        }
        return sum;
    }
}