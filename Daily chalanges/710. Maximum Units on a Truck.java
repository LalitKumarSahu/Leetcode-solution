//LALIT KUMAR
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1]));
        int maxUnit = 0;
        for(int boxes[] : boxTypes){
            int box = boxes[0];
            int unit = boxes[1];

            if(truckSize == 0){
                break;
                
            }

            if(box <= truckSize){
                maxUnit += box * unit;
                truckSize -= box;

            }else if(box > truckSize){
                maxUnit += truckSize * unit;
                truckSize = 0;
               
            }
        }
        return maxUnit;
    }
}



// harsit
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1]));
        int maxUnit = 0;
        for(int boxes[] : boxTypes){
            int box = Math.min(truckSize, boxes[0]);

            maxUnit += box * boxes[1];
            
            truckSize -= box;
            if(truckSize == 0) {
                break;
            }
        }
        return maxUnit;
    }
}