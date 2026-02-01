//m-1 
//arr ko map me store kar lenge (value, idx)
//sort arr , and iterate sorted arr and find the orgIdx from map
// and assign the rank


// m-2 by using counting sort
class Solution {
    //tc:O(N) + O(N) + O(M),sc:O(M), by using counting sort
    public int findmax(int[] score){
        int max = Integer.MIN_VALUE;
        for(int element : score){
            max = Math.max(max, element);
        }
        return max;
    }

    public String[] findRelativeRanks(int[] score) {
        int maxVal = findmax(score);
        int[] map = new int[maxVal + 1];
        int n = score.length;

        // score value -> original index mapping
        for (int i = 0; i < n; i++) {
            map[score[i]] = i + 1;
        }

        String[] res = new String[n];
        int rank = 1;

        // Traverse from max to min score
        for (int i = maxVal; i >= 0; i--) {
            if (map[i] != 0) {
                int originalIdx = map[i] - 1;

                if (rank == 1) {
                    res[originalIdx] = "Gold Medal";
                } else if (rank == 2) {
                    res[originalIdx] = "Silver Medal";
                } else if (rank == 3) {
                    res[originalIdx] = "Bronze Medal";
                } else {
                    res[originalIdx] = Integer.toString(rank); // rank ko string me convert 
                }
                rank++;
                if (rank > n) break;
            }
        }
        return res;
    }
}
