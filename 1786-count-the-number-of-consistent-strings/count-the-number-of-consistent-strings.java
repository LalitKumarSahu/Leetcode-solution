// class Solution {
//     //Time Complexity: O(n * m)
//      //sc: O(1) (since set size is bounded by 26 lowercase letters)
//     public int countConsistentStrings(String allowed, String[] words) {
//         int counter = 0;
//         HashSet<Character>set = new HashSet<>();
//         for(int i=0; i<allowed.length(); i++){
//             set.add(allowed.charAt(i));
//         }
//         for(String str : words){ // O(N)
//             boolean flag = true;
//             for(int i = 0; i < str.length(); i++){ // o(M)
//                 if(!set.contains(str.charAt(i))){
//                     flag = false;
//                 }
//             }
//             if(flag == true){
//                 counter++;
//             }
//         }

//         return counter;
        
//     }
// }

//----------------------------->
// class Solution {
//     //Time Complexity: O(n * m)
//      //sc: O(1) (since set size is bounded by 26 lowercase letters)
//     public int countConsistentStrings(String allowed, String[] words) {
//       int counter = 0;

//       HashSet<Character>set = new HashSet<>();
//       for(int i=0; i<allowed.length(); i++){
//         set.add(allowed.charAt(i));
//       }
      
     
//       for(String str : words){ //["ad","bd","aaab","baa","badab"] - > ad, bd--
//        boolean flag = true;
//         for(int i=0; i<str.length(); i++){
//             if(!set.contains(str.charAt(i))){
//                 flag = false;
//             }
//         }
//         if(flag == true) counter++;

//       }
//       return counter;
        
//     }
// }

//------------------------------->
// class Solution {
//     //Time Complexity: O(n * m)
//      //sc: O(1) (since set size is bounded by 26 lowercase letters)
//     public int countConsistentStrings(String allowed, String[] words) {
//       int counter = 0;
//       HashSet<Character>set = new HashSet<>();
//       for(int i =0 ; i<allowed.length(); i++){
//         char ch = allowed.charAt(i);
//         set.add(ch);
//       }

//       for(String str : words){
//         boolean flag = true;
//         for(int i= 0; i<str.length(); i++){
//             char ch1 = str.charAt(i);

//             if(!set.contains(ch1)){
//                 flag = false;
//             }
//         }
//          if(flag == true) counter++;
//       }
     
//       return counter;
        
//     }
// }

//------------------------------->
// class Solution {
//     //Time Complexity: O(n * m)
//      //sc: O(1) (since set size is bounded by 26 lowercase letters)
//     public int countConsistentStrings(String allowed, String[] words) {
//         int counter= 0;
//      HashSet<Character>set = new HashSet<>();
//      for(int i = 0; i<allowed.length(); i++){
//         set.add(allowed.charAt(i));
//      }
      
//       for(String str : words){

//         boolean flag = true;
//         for(int i = 0; i<str.length(); i++){
//             if(!set.contains(str.charAt(i))){
//                 flag = false;
//             }
//         }
//         if(flag == true) counter++;
//       }
//       return counter;
        
//     }
// }

//---------->
class Solution {
    //Time Complexity: O(n * m)
     //sc: O(1) (since set size is bounded by 26 lowercase letters)
    public int countConsistentStrings(String allowed, String[] words) {
       int counter = 0;
       HashSet<Character>set = new HashSet<>();

       for(int i = 0; i<allowed.length(); i++){
         set.add(allowed.charAt(i));
       }
       for(String word : words){
        boolean flag = true;
        for(int i = 0; i<word.length(); i++){
            if(!set.contains(word.charAt(i))){
                flag = false;
            }
        }
        if(flag == true) counter++;
       }
       return counter;
        
    }
}
