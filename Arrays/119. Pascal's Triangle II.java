import java.util.*;
public class 119. Pascal's Triangle II {
  class Solution {
    public List<Integer> getRow(int rowIndex) {
        return new ArrayList<>(generateRow(rowIndex + 1));

    }
    public List<Integer>generateRow(int row){
        long ans = 1;
        List<Integer>ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col = 1; col <row; col++){
            ans =  ans * (row - col);
            ans = ans/col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
}
}
