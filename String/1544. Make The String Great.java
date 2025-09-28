class Solution {
    // tc:O(N) + o(N) = O(N)
    // sc:O(N)-use sb
    public String makeGood(String s) {

       StringBuilder ans = new StringBuilder();

       for(char ch : s.toCharArray()){
        int len = ans.length();

        if(len > 0 && Math.abs(ans.charAt(len-1) - ch) == 32){
            ans.deleteCharAt(len-1);
        }else{
            ans.append(ch);
        }
             
       }
       return ans.toString();
        
    }
}

class Solution {
 
    public String makeGood(String s) {
       
       Stack<Character>stack = new Stack<>();
       
       for(char ch : s.toCharArray()){
       

        if(!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32){
            stack.pop();
        }else{
            stack.push(ch);
        }
             
       }
       String ans = "";
       while(!stack.isEmpty()){
          ans =  stack.pop() + ans;
       }
       return ans;
        
    }
}



