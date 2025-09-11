class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        
        Set<Character> record = new HashSet<>();
        record.add('A'); record.add('a'); record.add('E');record.add('e');record.add('I');
        record.add('i');record.add('O');record.add('o');record.add('U');record.add('u');

       StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
           char ch = s.charAt(i);
           if(record.contains(ch)){ // all vowel
             sb.append(ch);
           }
        }
         // sort 
         // Step 1: Convert to char array
        char[] chars = sb.toString().toCharArray();

        // Step 2: Sort the array
        Arrays.sort(chars);

        // Step 3: Create new StringBuilder from sorted chars
        StringBuilder sortedSb = new StringBuilder(new String(chars));
        
     StringBuilder res = new StringBuilder();
        int idx = 0;
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(!record.contains(ch)){
                res.append(ch);
            }else{
                res.append(sortedSb.charAt(idx));
                idx++;
            }

        }
        return res.toString();
    }
}

// m-2 by using pq
class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq = new  PriorityQueue<>();
        Set<Character> record = new HashSet<>();
        record.add('A'); record.add('a'); record.add('E');record.add('e');record.add('I');
        record.add('i');record.add('O');record.add('o');record.add('U');record.add('u');
        int n = s.length();
        for(int i =0; i < n; i++) {
            char ch = s.charAt(i);
            if(record.contains(ch)) {
                pq.offer(ch);
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(!record.contains(ch)){
                res.append(ch);
            }else{
                res.append(pq.poll());
            }

        }
        return res.toString();
    }
}