// class Solution {
//     public double averageWaitingTime(int[][] customers) {
//         int idealTime = 0;
//         long totalWtTime = 0;

//         for (int[] customer : customers) {
//             int arrival = customer[0];
//             int cook = customer[1];

//             if (idealTime <= arrival) {
//                 idealTime = arrival + cook;
//                 totalWtTime += cook;
//             } else {
//                 idealTime += cook;
//                 totalWtTime += (idealTime - arrival);
//             }
//         }

//         return (double) totalWtTime / customers.length;
//     }
// }

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int idealTime = 0;
        long totalWtTime = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int cook = customer[1];

            if (idealTime <= arrival) {
                idealTime = arrival + cook;
               
            } else {
                idealTime += cook;
              
            }
            totalWtTime += (idealTime - arrival);
        }

        return (double) totalWtTime / customers.length;
    }
}

