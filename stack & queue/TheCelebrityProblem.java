import java.util.*;
public class TheCelebrityProblem {
  // Celebrity kisi ko nahi jaanta → mat[c][i] == 0

//Sab celebrity ko jaante hain → mat[i][c] == 1 (i ≠ c)

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        Stack<Integer>s = new Stack<>();
        int n = mat.length;
        
        for(int i = 0; i<n; i++){
            s.push(i);
        }
        
        while(s.size() > 1){
            int i = s.peek();
            s.pop();
            int j = s.peek();
            s.pop();
            
            //Agar i, j ko nahi jaanta → i celebrity ho sakta hai
            //eliminate j
            if(mat[i][j] == 0){ 
                s.push(i);
            }else{
                //Agar i, j ko jaanta hai → i celebrity nahi ho sakta
                // eliminate i
                s.push(j);
            }
        }
        
        //Ye confirmed celebrity nahi, sirf candidate hai.
        int celibrity = s.pop();
        
        for(int i = 0; i<n; i++){
            // mat[i][celebrity] == 1 → sab usse jaante hain
            //mat[celebrity][i] == 0 → wo kisi ko nahi jaanta
            
            if(i != celibrity && (mat[i][celibrity] == 0 || mat[celibrity][i] == 1)){
                return -1;
            }
        }
        return celibrity;
    }
}
}
