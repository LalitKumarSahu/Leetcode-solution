// brute force approach
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i <= n - k; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(arr[j]);
            }

            list.add(set.size());
        }

        return list;
    }
}


// m-2 sliding window approach
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        // First window
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());

        // Sliding window
        for (int i = k; i < n; i++) {
            // remove outgoing element
            int outgoing = arr[i - k];
            map.put(outgoing, map.get(outgoing) - 1);
            if (map.get(outgoing) == 0) map.remove(outgoing);

            // add new incoming element
            int incoming = arr[i];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);

            result.add(map.size());
        }

        return result;
    }
}
