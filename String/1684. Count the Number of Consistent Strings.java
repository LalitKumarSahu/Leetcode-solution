class Solution {
    //Time Complexity: O(n * m)
     //sc: O(1) (since set size is bounded by 26 lowercase letters)
    public int countConsistentStrings(String allowed, String[] words) {
        int counter = 0;
        HashSet<Character>set = new HashSet<>();
        for(int i=0; i<allowed.length(); i++){
            set.add(allowed.charAt(i));
        }
        for(String str : words){ // O(N)
            boolean flag = true;
            for(int i = 0; i < str.length(); i++){ // o(M)
                if(!set.contains(str.charAt(i))){
                    flag = false;
                }
            }
            if(flag == true){
                counter++;
            }
        }

        return counter;
        
    }
}
