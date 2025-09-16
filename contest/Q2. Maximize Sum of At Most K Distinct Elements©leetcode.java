class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        // add nums into set for remove duplicate
       Set<Integer>set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        // sort into desc order
        List<Integer>list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        int size = Math.min(k, list.size());
        int res[] = new int[size];
        for(int i = 0; i<size; i++){
            res[i] = list.get(i);
        }
        return res;
        
    }
}