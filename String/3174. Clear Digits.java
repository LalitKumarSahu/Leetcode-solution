class Solution {
    public String clearDigits(String s) {
        Stack<Character>stack = new Stack<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            if(!Character.isDigit(s.charAt(i)) ){ // if character then push into stack
             stack.push(s.charAt(i));

            }else{  // if digit pop the top character
               if(!stack.isEmpty())
                stack.pop();
            }
          
        }
        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
        res.insert(0, stack.pop());
        }
        return res.toString();
        
    }
}

class Solution {
    // tc-O(N) sc-O(N)
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for(int i=0; i<n; i++){
            if(!Character.isDigit(s.charAt(i)) ){ // if character then push into stack
              sb.append(s.charAt(i));

            }else{  // if digit pop the top character
               if(sb.length() != 0){
                  sb.deleteCharAt(sb.length()-1);
               }
                
            }
          
        }
        return sb.toString();
      
        
    }
}