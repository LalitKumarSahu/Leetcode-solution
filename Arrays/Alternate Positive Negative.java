import java.util.*;
public class Alternate Positive Negative {
  class Solution {
    // Brute force
    void rearrange1(ArrayList<Integer> arr) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Step 1: separate +ve and -ve
        for (int x : arr) {
            if (x > 0) pos.add(x);
            else neg.add(x);
        }

        arr.clear(); // empty original list

        // Step 2: fill alternately
        int i = 0;
        while (i < pos.size() && i < neg.size()) {
            arr.add(pos.get(i)); // +ve
            arr.add(neg.get(i)); // -ve
            i++;
        }
    }
    
    // optimal Approach - postive and neg are equal
    void rearrange2(ArrayList<Integer> arr) {
        int n = arr.size();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
    
        int posIdx = 0;
        int negIdx = 1;
    
        for (int i = 0; i < n; i++) {
            int x = arr.get(i);
            if (x < 0) {
                ans.set(negIdx, x);
                negIdx += 2;
            } else {
                ans.set(posIdx, x);
                posIdx += 2;
            }
        }
    
        // copy back to arr
        for (int i = 0; i < n; i++) {
            arr.set(i, ans.get(i));
        }
}

    // optimal Approach - postive and neg are not equal
   void rearrange3(ArrayList<Integer> arr) {
    int n = arr.size();
    ArrayList<Integer> pos = new ArrayList<>();
    ArrayList<Integer> neg = new ArrayList<>();

    // Separate positive and negative numbers
    for (int x : arr) {
        if (x < 0) neg.add(x);
        else pos.add(x);
    }

    int i = 0, p = 0, q = 0;
    
    // Fill alternately
    while (p < pos.size() && q < neg.size()) {
        arr.set(i++, pos.get(p++));  // pos
        arr.set(i++, neg.get(q++));  // neg
    }

    // Fill leftover positives
    while (p < pos.size()) {
        arr.set(i++, pos.get(p++));
    }

    // Fill leftover negatives
    while (q < neg.size()) {
        arr.set(i++, neg.get(q++));
    }
}


}

  
}
