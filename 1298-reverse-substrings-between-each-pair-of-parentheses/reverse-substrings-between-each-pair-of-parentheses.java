// class Solution {
//     //tc:O(N) ---sc:O(N)---->
//     public String reverseParentheses(String s) {
//         Stack<Character> stack = new Stack<>();

//         for (char ch : s.toCharArray()) {
//             if (ch == ')') {
//                 // Step 1: Pop characters until '(' is found
//                 StringBuilder sb = new StringBuilder();
//                 while (!stack.isEmpty() && stack.peek() != '(') {
//                     sb.append(stack.pop());
//                 }

//                 // Step 2: Pop the '(' from the stack
//                 if (!stack.isEmpty()) stack.pop();

//                 // Step 3: Push reversed characters back into the stack
//                 for (char c : sb.toString().toCharArray()) {
//                     stack.push(c);
//                 }

//             } else {
//                 // Push all characters including '('
//                 stack.push(ch);
//             }
//         }

//         // Step 4: Build final result from the stack
//         StringBuilder res = new StringBuilder();
//         while (!stack.isEmpty()) {
//             res.append(stack.pop());
//         }

//         // Stack stores characters in reverse, so reverse final string
//         return res.reverse().toString();
//     }
// }

// m-2
// class Solution {
//     //tc:O(N) ---sc:O(N)---->
//     public String reverseParentheses(String s) {
//         Stack<Integer> stack = new Stack<>();
//         StringBuilder res = new StringBuilder();
//         int arr[] = new int[s.length()];

//         for (int i=0; i<s.length(); i++) {
//           char ch = s.charAt(i);
//           if(ch == '(') {
//             stack.push(i);

//             } else if(ch == ')') {
//                 int openIdx = stack.pop();
//                 arr[openIdx] = i;
//                 arr[i] = openIdx;
               
//             }
//         }
//         int i=0;
//         int dir = 1;
//         while(i < s.length()){
//             char ch = s.charAt(i);
//             if(ch == '(' || ch == ')'){
//                 i = arr[i];
//                 dir = -1 * dir;
//             }else{
//                 res.append(ch);
//             }
//             i += dir;
//         }
//         return res.toString();
        
//     }
// }

class Solution {
    //tc:O(N) ---sc:O(N)---->
    public String reverseParentheses(String s) {
       Stack<Character>st = new Stack<>();

       for(char ch : s.toCharArray()){
        if(ch == ')'){
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty() && st.peek() != '('){
                sb.append(st.pop());
            }
            if(!st.isEmpty()) st.pop();

            // push back into stack
            for(char c : sb.toString().toCharArray()){
                st.push(c);
            }

        }else{
            st.push(ch);
        }
       }
       StringBuilder res = new StringBuilder();
       while(!st.isEmpty()){
        res.append(st.pop());
       }
       return res.reverse().toString();
    }
}


