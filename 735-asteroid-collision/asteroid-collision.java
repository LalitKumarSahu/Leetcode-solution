class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>s = new Stack<>();
        int n = asteroids.length;
        for(int i= 0; i<n; i++){
            // if stack is Empty or asteroids is postive then blind inseretion
            if(s.isEmpty() || asteroids[i] > 0){
                s.push(asteroids[i]);
            }else{
                while(!s.isEmpty()){
                    int top = s.peek();
                    if(top < 0){
                        s.push(asteroids[i]);
                        break;
                    }
                    int modVal = Math.abs(asteroids[i]);
                    if(modVal == top){
                        s.pop();
                        break;
                    }else if(modVal < top){
                        break;
                    }else{
                        s.pop();
                        if(s.isEmpty()){
                          s.push(asteroids[i]);
                          break;   
                        }
                    }
                }
               

            }

        }
        int len = s.size();
        int ansArr[] = new int[len];

        for(int i = len-1; i>=0; i--){
            ansArr[i] = s.pop();
        }
        return ansArr;
    }
}