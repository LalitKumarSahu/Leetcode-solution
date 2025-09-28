class Solution {
    // tc:NlogN + 3N

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer temp[] = new Integer[n];

        for(int i=0; i<n; i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);

        List<Deque<Integer>>list = new ArrayList<>();
        HashMap<Integer,Integer>group = new HashMap<>();
        int groupIdx = 0;
        list.add(new LinkedList<>());
        list.get(groupIdx).offer(temp[0]);
        group.put(temp[0], groupIdx);

        for(int i=1; i < n; i++){
            if(temp[i] - list.get(groupIdx).peekLast() > limit){
               groupIdx++;
               list.add(new LinkedList<>());
            }
            group.put(temp[i], groupIdx);
             list.get(groupIdx).offer(temp[i]);
        }
         for(int i=0; i<n; i++){
           int gi = group.get(nums[i]);
           nums[i] = list.get(gi).poll();
        }
        return nums;
    }
}

class Solution {


    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int minVal = nums[i];
            int minIdx = -1;

            for (int j = i + 1; j < n; j++) {

                if (Math.abs(nums[j] - nums[i]) <= limit) {
                    if (nums[j] < minVal) {
                        minVal = nums[j];
                        minIdx = j;
                    }
                }
            }

            if (minIdx != -1) {
                int temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;
            }
        }
        return nums;

    }
}
