// User function Template for Java

class Solution {
    static boolean match(String wild, String pattern) {
        int n = wild.length();
        int m = pattern.length();
        
        return fn(n-1, m-1, wild, pattern);
    }
    
    static boolean fn(int i, int j, String wild, String pattern){
        // base case :
        if(i < 0 && j < 0) return true;
        
        if(i < 0 && j >= 0) return false;
        
        if(j < 0 && i >= 0){
            for(int k = 0; k <= i; k++){
                if(wild.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        
        if(wild.charAt(i) == pattern.charAt(j) || wild.charAt(i) == '?'){
            return fn(i-1, j-1, wild, pattern);
        }
        else if(wild.charAt(i) == '*'){
            // * can match empty OR one char
            return (fn(i-1, j, wild, pattern) || fn(i, j-1, wild, pattern));
        }
        return false;
    }
}

// meomization
import java.util.*;

class Solution {
    static boolean match(String wild, String pattern) {
        int n = wild.length();
        int m = pattern.length();
        Boolean dp[][] = new Boolean[n][m];  // null = not calculated
        
        return fn(n-1, m-1, wild, pattern, dp);
    }
    
    static boolean fn(int i, int j, String wild, String pattern, Boolean dp[][]){
        // base case :
        if(i < 0 && j < 0) return true;
        
        if(i < 0 && j >= 0) return false;
        
        if(j < 0 && i >= 0){
            for(int k = 0; k <= i; k++){
                if(wild.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        
        if(dp[i][j] != null) return dp[i][j];
        
        if(wild.charAt(i) == pattern.charAt(j) || wild.charAt(i) == '?'){
            return dp[i][j] = fn(i-1, j-1, wild, pattern, dp);
        }
        else if(wild.charAt(i) == '*'){
            // * can match empty OR one char
            return dp[i][j] = (fn(i-1, j, wild, pattern, dp) || fn(i, j-1, wild, pattern, dp));
        }
        return dp[i][j] = false;
    }
}

