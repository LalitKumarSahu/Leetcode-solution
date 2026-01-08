//m-1 Brute force 
// check if non-overlaping add into the list and return true
//else if there is overlaping return false;

// class MyCalendar {
//     //(Key, val)
//     TreeMap<Integer, Integer>map;
//     public MyCalendar() {
//         map = new TreeMap<>(); 
//     }
    
//     public boolean book(int startTime, int endTime) {
//         Integer lastEnd = map.lowerKey(endTime);
//         // overlap exist
//         if(lastEnd != null && startTime <= map.get(lastEnd)-1){
//             return false;
//         } 

//         // if there is no overlap then add into the map (blind insertion)
//         map.put(startTime, endTime);
//         return true;
//     }
// }

class MyCalendar {
    //(Key, val)
   TreeMap<Integer, Integer>map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
       Integer lastEnd = map.lowerKey(endTime);
       // overlap exist
       if(lastEnd != null && startTime <= map.get(lastEnd) -1){
         return false;
       }
       map.put(startTime, endTime);
       return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */