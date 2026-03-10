// class Solution {
//     //tc:O(N) + k*9, sc:O(N)
//     public int robotSim(int[] commands, int[][] obstacles) {

//         // 0: North, 1: East, 2:South, 3:West
//         int [][] directions = {{0,1}, {1,0}, {0,-1},{-1, 0}};
//         int[] currPos = {0,0};
//         int res = 0;
//         int currDir = 0; //North , 0 is the idx

//         HashMap<Integer, HashSet<Integer>>obstacleMap = new HashMap<>();
//         for(int []obstacle :obstacles ){ //O(N) - iterate and insert into set
//             if(!obstacleMap.containsKey(obstacle[0])){
//                 obstacleMap.put(obstacle[0], new HashSet<>()); // x co-ordinate put in map
//             }
//             obstacleMap.get(obstacle[0]).add(obstacle[1]); // y co-ordinate DD in SET

//         }
//         for(int command:commands){  // O(K) - iteraate on commaand
//                 if(command == -1){
//                     // turn right
//                     currDir =(currDir + 1) % 4;
//                     continue;
//                 }
//                 if(command == -2){
//                     // turn left
//                     currDir = (currDir-1);
//                     if(currDir == -1){
//                         currDir = 3;
//                     }
//                     continue;
//                 }

//             // move forward
//             int []direction = directions[currDir];
//             for(int step = 0; step <command; step++){ //9
//                 int nextX = currPos[0] + direction[0];
//                 int nextY  = currPos[1] + direction[1];

//                 //check obstacle is persent or not
//                 if(obstacleMap.containsKey(nextX) && obstacleMap.get(nextX).contains(nextY)){
//                     break;
//                 }
//                 currPos[0] = nextX;
//                 currPos[1] = nextY;
//             }
//             res = Math.max(res, currPos[0] * currPos[0] + currPos[1] * currPos[1]);
//         }
//         return res;
//     }

// }

// ----------------------------->
// class Solution {
//     //tc:O(N) + k*9, sc:O(N)
//     public int robotSim(int[] commands, int[][] obstacles) {
//       // direction
//       int directions[][] ={ {0,1}, {1, 0}, {0, -1}, {-1, 0}};
//       int currPos[]  = {0, 0};
//       int res  = 0;
//       int currDir = 0; //North , 0th is the idx

//       // strore obstacles
//       HashMap<Integer, Set<Integer>>map = new HashMap<>();
//       for(int []obstacle : obstacles ){
//         if(!map.containsKey(obstacle[0])){
//             map.put(obstacle[0], new HashSet<>());
//         }
//         map.get(obstacle[0]).add(obstacle[1]);
//       }
      
//       for(int cmd : commands){
//         if(cmd == -1){ //right
//         currDir = (currDir+1)%4;
//         continue;
//         }else if(cmd == -2){
//             currDir = currDir - 1;
//             if(currDir == -1){  // north me ho aur -1 hoga to minus -1 aa jayega
//                 currDir = 3; // lassst idx pe bhej denge
//             }
//             continue;
//         }

//         int [] direction = directions[currDir];
//         for(int step = 0; step<cmd; step++){
//             int nextX = currPos[0] + direction[0];
//             int nextY = currPos[1] + direction[1];

//             if(map.containsKey(nextX) && map.get(nextX).contains(nextY)){
//                 break;
//             }
//             currPos[0] = nextX;
//             currPos[1] = nextY;

//         }
//          res = Math.max(res, currPos[0] * currPos[0] + currPos[1] * currPos[1]);
//       }
//       return res;


//     }

// }

class Solution {
  public int robotSim(int[] commands, int[][] obstacles) {
      int directions[][] = {{0,1},{1, 0},{0, -1},{-1, 0}};
      int currPos[] = {0, 0};
      int currDir = 0;
      int res = 0;

      HashMap<Integer,Set<Integer>>map = new HashMap<>();

      for(int obst[] :obstacles ){
        if(!map.containsKey(obst[0])){
            map.put(obst[0], new HashSet<>());
        }
        map.get(obst[0]).add(obst[1]);
      }

      for(int cmd:  commands ){
        if(cmd == -1){
            currDir = (currDir+ 1)%4;
            continue;
        }else if(cmd == -2){
            currDir = currDir - 1;
            if(currDir == -1){
              currDir = 3;
            }
            continue;
        }
        int direction[] = directions[currDir];

        for(int step = 0; step < cmd; step++){
                int nextX = currPos[0] + direction[0];
                int nextY = currPos[1] + direction[1];

                if(map.containsKey(nextX) && map.get(nextX).contains(nextY)){
                    break;
                }
                currPos[0] = nextX;
                currPos[1] = nextY;
        }
         res = Math.max(res, currPos[0] * currPos[0] + currPos[1] * currPos[1]);


      }
      return res;


    }

}