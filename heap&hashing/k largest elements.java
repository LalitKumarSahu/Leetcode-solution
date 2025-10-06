class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : arr){
            pq.add(num);
        }
        
        ArrayList<Integer>res = new ArrayList<>();
        for(int i = 0; i<k; i++){
            if(!pq.isEmpty()){
                res.add(pq.poll());
            }
        }
        return res;
        
    }
}
