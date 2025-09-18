
import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
      List<Integer>idxArr = new ArrayList<>(); //O(N)
      for(int i = 0; i<n; i++){
        idxArr.add(i);
      }
      Collections.sort(idxArr, new Comparator<Integer>(){ //NlogN
        public int compare(Integer x, Integer y){
            return arr[x] - arr[y];
        }
      });
      int rank = 0;
      int prev = Integer.MAX_VALUE;
      int res[] = new int[n];
      for(int idx : idxArr){ //O(N)
        if(prev != arr[idx]){ // same na ho , agar same hai to vhi rank aa jaygi
            prev = arr[idx];
            rank++;
        }
        res[idx] = rank;
      }
      return res;
    }
}



class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        //(element, idx)
        PriorityQueue<int[]>pq = new PriorityQueue<>(new Comparator<int[]>(){

             public int compare(int[] x, int[] y) {
                return x[0]- y[0]; // comapre on the basis of element
            }
        });
    
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{arr[i], i});
        }

        int rank = 0;
        int prev = Integer.MAX_VALUE;
         while(!pq.isEmpty()){
            int curr[] = pq.poll();
            if (prev != curr[0]) {
                prev = curr[0];
                rank++;
            }
            arr[curr[1]] = rank;  // curr[1] = idx
        }
        return arr;
    }
}
// m-3 -- tc-O(NlogN) + O(NlogN) + O(n)--sc-O(N) + O(N)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        TreeSet<Integer>set = new TreeSet<>();
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int elm : arr){ // iterate arr and add into treeset - O(NlogN)
            set.add(elm);
        }
        int rank = 1;
        for(int num : set){  // iterate treeset and add into map - O(NlogN)
            map.put(num, rank);
            rank++;
        }
        for(int i=0; i<n; i++){ // O(N)
            arr[i] = map.get(arr[i]); // find rank of elm and store into arr
        }
        return arr;
    }
}