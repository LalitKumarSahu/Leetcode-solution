
// tc:NlogN sorting + O(N) travesal, sc:O(N)
// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         int n  = points.length;
//         if(n == 1){
//             return 1;
//         }
//         // sort based on start
//         Arrays.sort(points, new Comparator<int[]>(){
//             public int compare(int a1[], int a2[]){
//               // return a1[0] - a2[0];
//               if(a1[0] == a2[0]) return 0;
//               if(a1[0] < a2[0]) return -1;
//                return 1;
//             }
//         });

// or use this
// Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

//         int arrows = 1;
//         int commonInterval[] = points[0];
//         for(int i = 1; i < n; i++){
//             int currS = points[i][0];
//             int currE = points[i][1];

//             // if interval are overlaping then we can useexisting row 
//             // burst it
//             if(currS <= commonInterval[1] ){
//                 commonInterval[0] = Math.max(commonInterval[0], currS);
//                 commonInterval[1] = Math.min(commonInterval[1], currE);

//             }else{
//                  commonInterval[0] = currS;
//                  commonInterval[1] = currE;
//                  arrows++;
//             }
//         }
//         return arrows;
//     }
// }
// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         int n = points.length;
//         if(n == 1){
//             return 1;
//         }
        
//         Arrays.sort(points, new Comparator<int[]>(){
//             public int compare(int a1[], int a2[]){
//                 if(a1[0] == a2[0]) return 0;
//                 if(a1[0] < a2[0]) return -1;
//                 return 1;
//             }
//         });

//         int arrow = 1;
//         int commonInterval[] = points[0];
//         for(int i = 1; i<n; i++){
//             int currS = points[i][0];
//             int currE = points[i][1];
             
//             // intervals are overlaping
//             if(currS <= commonInterval[1]){
//                 commonInterval[0] = Math.max(commonInterval[0], currS);
//                 commonInterval[1] = Math.min(commonInterval[1], currE);
//             }else{
//                  commonInterval[0] = currS;
//                   commonInterval[1] = currE;
//                   arrow++;
//             }
//         }
//         return arrow;

//     }
// }

// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         int n = points.length;
//         if(n == 1){
//             return 1;
//         }

//         Arrays.sort(points, new Comparator<int[]>(){
//             public int compare(int a1[], int a2[]){
//                 if(a1[0] == a2[0]) return 0;
//                 if(a1[0] < a2[0]) return -1;
//                 return 1;
//             }
//         });

//         int arrows = 1;
//         int commonInt[] = points[0];
//         for(int i = 1; i<n; i++){
//             int currS = points[i][0];
//             int currE = points[i][1];

//             if(currS <= commonInt[1]){
//                commonInt[0] = Math.max(commonInt[0], currS);
//                commonInt[1] = Math.min(commonInt[1], currE); 

//             }else{
//                 commonInt[0] = currS;
//                 commonInt[1] = currE;
//                 arrows++;
//             }
//         }
//         return arrows;

//     }
// }

class Solution {
    public int findMinArrowShots(int[][] points) {
        
       int n = points.length;

       if(n == 1){
        return 1;
       }

       // sort based on start
       Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

       int arrow = 1;
       int commanInerval[] = points[0];

       for(int i = 1; i<n; i++){
        if(points[i][0] <= commanInerval[1]){
            commanInerval[0] = Math.max( commanInerval[0], points[i][0]);
            commanInerval[1] = Math.min( commanInerval[1], points[i][1]);
 
        }else{
            commanInerval[0] = points[i][0];
            commanInerval[1] = points[i][1];

            arrow++;
            
        }
    }
    return arrow;

       

    }
}