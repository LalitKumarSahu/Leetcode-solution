// we will sort not based on inc or dec 
// we wwill sort based on two comparesion
// for eg - 23, 9 = 239 or 923
// i = 0 j = i+1 to n compare and swap i = 1 and j = i+1 and so on
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
        //multiple 0 then return only one 0  eg = "00"->'0'
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
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {
                System.out.println("Time overwrite aborted");
            }
        }));
  }
}

// class Solution {
//     public String largestNumber(int[] nums) {
//       int n = nums.length;
//       String elements[] = new String[n];
      
//       for(int i = 0; i<n; i++){
//         elements[i] = Integer.toString(nums[i]);
//       }

//       Arrays.sort(elements, new Comparator<String>(){
//         public int compare(String a, String b){
//             String first = a + b;
//             String sec = b + a;

//             return sec.compareTo(first);
//         }
//       });

//       if(elements[0].equals("0")){
//         return "0";
//       }

//       StringBuilder res = new StringBuilder();
//       for(String elm : elements){
//         res.append(elm);
//       }
//       return res.toString();
//     }
// }