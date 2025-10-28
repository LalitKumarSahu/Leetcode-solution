class Solution {
    public int findSubarray(int[] arr) {
        // code here.
        int n = arr.length;
        int count = 0;
        for(int i = 0; i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum += arr[j];
                
                if(sum == 0){
                    count++;
                }
            }
        }
        return count;
    }
}

// m-2 optimization
class Solution {
    public int findSubarray(int[] arr) {
        // code here.
        int n = arr.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0, 1);
        for(int num : arr){
            sum += num;
            
            if(map.containsKey(sum)){
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}