import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int k, int n, int start) {
       // Base Case: Agar currentList ka size k ho aur n ka value 0 ho, to matlab humne ek valid combination find kar liya hai. Us combination ko result list me add kar diya jaata hai.
        if (currentList.size() == k && n == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        //Loop: start se lekar 9 tak loop chalta hai. Har number ko currentList me add kiya jaata hai, aur fir backtrack method recursively call hota hai, saath hi n - i aur i + 1 parameters pass hote hain.
        for (int i = start; i <= 9; i++) {
            currentList.add(i);
            backtrack(result, currentList, k, n - i, i + 1);
            currentList.remove(currentList.size() - 1); // backtrack
        }
    }
}
