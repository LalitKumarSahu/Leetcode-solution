// User function Template for Java

class Solution {
    public String removeConsecutiveCharacter(String s) {
        // code here
        StringBuilder res = new StringBuilder();
        int n = s.length();
        
        res.append(s.charAt(0));
        
        for(int i = 1; i<n; i++){
            char ch = s.charAt(i);
            if(ch == res.charAt(res.length()-1)){
                continue;
            }
            res.append(ch);
            
            
        }
        return res.toString();
    }
}