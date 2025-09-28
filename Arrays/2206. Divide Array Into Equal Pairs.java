class Solution {
    public boolean divideArray(int[] nums) {
        HashSet<Integer>set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        return (set.size() == 0);
    }
}

// m-2 by using HashMap
class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int count : map.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}

// m-3 by sorting and comapre i & i+1 is equal then check i+2 & i+3
class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length % 2 != 0) return false;
       Arrays.sort(nums);

       for(int i=0; i<nums.length; i+=2){
          if(nums[i] != nums[i+1]){
            return false;
          }

       }
       return true;
    }
}

