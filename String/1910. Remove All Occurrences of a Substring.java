class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int m = part.length();
        for(int i = 0; i<n; i++){
          char ch = s.charAt(i);
          sb.append(ch);
          if(sb.length() >= m){
             String sub = sb.substring(sb.length() - m);
             if(sub.equals(part)){
                // Original: "abcdef"
                 //setLength(3) → sirf first 3 characters rakhe → "abc"
                 //Baaki characters delete ho gaye    
                sb.setLength(sb.length() - m);
             }
          }
        }
        return sb.toString();
    }
}