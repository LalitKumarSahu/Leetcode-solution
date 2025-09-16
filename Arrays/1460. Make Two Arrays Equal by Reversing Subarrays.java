import java.util.HashMap;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        
        if(target.length != arr.length){
            return false;
        }
        for(int i=0; i<target.length; i++){
            if(target[i] != arr[i]){
                return false;
            }
        }
        return true;
    }
}
//m-2 by using hashMap
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int elm : target) {
            map1.put(elm, map1.getOrDefault(elm, 0) + 1);
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int elm : arr) {
            map2.put(elm, map2.getOrDefault(elm, 0) + 1);
        }

        if (map1.size() != map2.size()) return false;

        for (int key : map1.keySet()) {
            if (!map2.containsKey(key)) return false;
            if (!map1.get(key).equals(map2.get(key))) return false;
        }

        return true;
    }
}
// m-3 only single map
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int elm : target) {
            map1.put(elm, map1.getOrDefault(elm, 0) + 1);
        }
        for (int elm : arr) {
            if (!map1.containsKey(elm)) return false;

           map1.put(elm, map1.get(elm)-1);

           if(map1.get(elm) == 0){
            map1.remove(elm);
           }
        }

        return map1.isEmpty();
    }
}


