class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        int n = words.length;
        for(int i=0; i<n; i++){
            String str = words[i];
            if(str.startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}