class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String elements[] = new String[n];
        for(int i=0; i<n; i++){ // N
            elements[i] = Integer.toString(nums[i]);
        }
        //--------custum sorting-- -//KNlogN-->
        Arrays.sort(elements, new Comparator<String>(){
            public int compare(String a, String b){
                String first = a + b;  // if a > b then vaise hi rhega a and b
                String sec = b + a;
                return sec.compareTo(first); // K // if  b>a then sorting
            }
        });
        //multiple 0 then return only one 0
        if(elements[0].equals("0")){
            return "0";
        }
        //  String res = "";
        // for(String val : elements){
        //    res += val;
        // }
        // return res;

        // ----merge---->
        StringBuilder sb = new StringBuilder();
        for(String val : elements){
            sb.append(val);
        }
        return sb.toString();
    }
}
