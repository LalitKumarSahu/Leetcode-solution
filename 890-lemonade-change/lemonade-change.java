class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;

        for(int bill : bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){

                if(five == 0) return false;
                five--;
                ten++;

            }else{ // bill = 20
             if(ten > 0 && five > 0){ // 20 = 10 + 5(back)
                ten -= 1;
                five -= 1;
             }else if(five >= 3){ // 20 = 3 * 5 (back)
                five -= 3;

             }else{
                return false;
             }

            }
        }
        return true;
        
    }
}