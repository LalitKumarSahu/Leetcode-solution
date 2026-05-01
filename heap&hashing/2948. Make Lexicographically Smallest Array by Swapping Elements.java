import java.util.*;

public class 2948. Make Lexicographically Smallest Array by Swapping Elements {
  class Solution {
    // tc:NlogN + 3N

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int temp[] = new int[n];
        for(int i =0; i<n; i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        List<Deque<Integer>>list = new ArrayList<>();
        HashMap<Integer,Integer>group = new HashMap<>();
        int grpIdx = 0;
        list.add(new LinkedList<>());
        list.get(grpIdx).offer(temp[0]);
        group.put(temp[0], grpIdx);

        for(int i = 1; i<n; i++){
            if(temp[i] - list.get(grpIdx).peekLast() > limit){
                grpIdx++;
                list.add(new LinkedList<>());
            }
            list.get(grpIdx).offer(temp[i]);
             group.put(temp[i], grpIdx);
        }

        for(int i= 0; i<n; i++){
           int gi = group.get(nums[i]);
           nums[i] = list.get(gi).poll();

        }
        return nums;

       

    }
}

}
