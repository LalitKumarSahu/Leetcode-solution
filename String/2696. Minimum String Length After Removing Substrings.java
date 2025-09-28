class Solution {
    public int minLength(String s) {
        Stack<Character>stack = new Stack<>();

        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            if(ch == 'B' && stack.peek() == 'A'){
                stack.pop();
            }else if(ch == 'D' && stack.peek() == 'C'){
                stack.pop();

            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
// m-2 using 2 pointer read and write
class Solution {
    public int minLength(String s) {
        int n = s.length();
        char str[] = s.toCharArray(); // N
        int w = 0;
        for(int r = 0; r < n; r++){ // N
            if(w == 0){
                str[w] = str[r];
                w++;
                continue;
            }
            if(str[r] == 'B' && str[w-1] == 'A'){
                w--;
            } else if(str[r] == 'D' && str[w-1] == 'C'){
                w--;
            }else{
                str[w] = str[r];
                w++;
            }
        }
        return w;
    }
}