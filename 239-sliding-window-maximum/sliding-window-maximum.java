class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>dq  = new ArrayDeque<Integer>();

        int n = nums.length;
        int res[] = new int[n-k+1];
        if(n==0) return res;

        int idx = 0;
        while(idx < k){

            // nums[idx] agr bada hai to deque se chota elm delete hoga, fir bada vala insert
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[idx]){
                dq.pollLast();
            }
            dq.offerLast(idx);
            idx++;
        }
        res[0] = nums[dq.peekFirst()];
        // 0,1,2->1,2,3
        // remove i-1 <= 
        // add i+k-1

        for(int i = 1; i<n-k+1; i++){

            // remove jo i-1 se chote hai
            while(!dq.isEmpty() && dq.peekFirst() <= i-1){
                dq.pollFirst();
            }
            // and add next window idx
            // nums[idx] agr bada hai to deque se chota elm delete hoga, fir bada vala insert
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i+k-1]){
                dq.pollLast();
            }
            dq.offerLast(i+k-1);
             res[i] = nums[dq.peekFirst()];

        }
        return res;
    }
}