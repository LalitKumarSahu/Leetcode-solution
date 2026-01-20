import java.util.HashMap;

public class CountSubarraysWithGivenXOR {
  class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);   // important

        int prefixXor = 0;
        long count = 0;

        for (int num : arr) {
            prefixXor ^= num;

            int required = prefixXor ^ k;
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }
}

}
