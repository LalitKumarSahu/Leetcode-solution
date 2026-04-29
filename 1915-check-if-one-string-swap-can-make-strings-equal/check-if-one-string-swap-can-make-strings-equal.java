class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int n = s1.length();
        if(s1.length() != s2.length())return false;
        for(int i =0; i<n; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 != ch2){
                count++;
            }
        }
        if(count == 0)return true;
        if(count > 2) return false;
        int i = 0;
        int j = 0;
        for(int k = 0; k<n; k++){
            char ch1 = s1.charAt(k);
            char ch2 = s2.charAt(k);
            if(ch1 != ch2){
                if(i == 0){
                    i = k;
                }else{
                    j = k;
                }
            }
        }
        return (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i));
    }
}