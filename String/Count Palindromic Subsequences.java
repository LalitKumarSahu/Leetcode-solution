class Solution {
    int countPS(String s) {
        
        List<String> list = new ArrayList<>();
        helper(0, s, "", list);
        return list.size();
    }

    public void helper(int i, String s, String curr, List<String> list) {
        if (i == s.length()) {
            if (curr.length() > 0 && isPalindrome(curr)) {
                list.add(curr);
            }
            return;
        }

        // NoPick
        helper(i + 1, s, curr, list);

        // Pick
        helper(i + 1, s, curr + s.charAt(i), list);
    }

    public boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

// m-2 dp meoization
class Solution {
    int[][] dp;

    int countPS(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(s, 0, n-1);
    }

    // Count palindromic subsequences in s[i...j]
    int helper(String s, int i, int j) {
        if(i > j) return 0;       // empty substring
        if(i == j) return 1;      // single character palindrome
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 1 + helper(s, i+1, j) + helper(s, i, j-1);
        } else {
            dp[i][j] = helper(s, i+1, j) + helper(s, i, j-1) - helper(s, i+1, j-1);
        }
        return dp[i][j];
    }
}


