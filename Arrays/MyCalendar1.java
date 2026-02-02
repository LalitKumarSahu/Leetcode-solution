//m-1 Brute force 
// check if non-overlaping add into the list and return true
//else if there is overlaping return false;

import java.util.*;
class MyCalendar {
    //(Key, val)->key = start time, val = end Time
    TreeMap<Integer, Integer>map;
    public MyCalendar() {
        map = new TreeMap<>(); 
    }
    
    public boolean book(int startTime, int endTime) {
        Integer lastEnd = map.lowerKey(endTime);
        // overlap exist, to not store inot map
        if(lastEnd != null && startTime <= map.get(lastEnd)-1){
            return false;
        } 

        // if there is no overlap then add into the map (blind insertion)
        map.put(startTime, endTime);
        return true;
    }
}