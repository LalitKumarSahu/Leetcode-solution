import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs); // Sorting the array
        String str1 = strs[0]; // First string after sorting
        String str2 = strs[strs.length - 1]; // Last string after sorting
        int idx = 0;

        while (idx < str1.length() && idx < str2.length()) {
            if (str1.charAt(idx) == str2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }

        return idx == 0 ? "" : str1.substring(0, idx); // Return the common prefix
    }
}