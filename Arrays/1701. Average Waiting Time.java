class Solution {
    public double averageWaitingTime(int[][] customers) {
        int idealTime = 1;
        long totalWtTime = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int cook = customer[1];

            if (idealTime <= arrival) { // 1st cust
                idealTime = arrival + cook;
                totalWtTime += cook; // idT - cus[0];
            } else {
                idealTime += cook; // idt + cus[1]; idt + food prep
                totalWtTime += (idealTime - arrival);
            }
        }

        return (double) totalWtTime / customers.length;
    }
}
