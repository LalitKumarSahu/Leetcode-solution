class Solution {
    public int maxFreqSum(String s) {
        int n = s.length();
        Set<Character>set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        HashMap<Character,Integer>map1 = new HashMap<>();
        HashMap<Character, Integer>map2 = new HashMap<>();

        int mFreq1 = 0;
        int mFreq2 = 0;


        for(int i= 0; i<n; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                mFreq1 = Math.max(mFreq1, map1.get(ch));

            }else{
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
                mFreq2 = Math.max(mFreq2, map2.get(ch));
                
            }

        }

        if(mFreq1 == 0 && mFreq2 == 0 ) return 0;
         
         return mFreq1 + mFreq2;
    }
}

// ---------m-2--------------------->
// m-2
class Solution {
    //tc:O(N), sc:O(1)
    public int maxFreqSum(String s) {
        int n = s.length();
        int freq[] = new int[26];   
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        int mFreq1 = 0;
        int mFreq2 = 0;

        for(int i= 0; i<26; i++){ //N
            if(freq[i] > 0){
                char ch = (char)(i + 'a');
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                 mFreq1 = Math.max(mFreq1, freq[i]);
                }else{
                 mFreq2 = Math.max(mFreq2, freq[i]);
                }
            }          
                
      }
      return mFreq1 + mFreq2;
    }
}