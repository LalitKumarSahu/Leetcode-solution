public class 731. My Calendar II {
  class MyCalendarTwo {
    List<int[]>bookings;
    TreeMap<Integer,Integer>overlappedMap;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlappedMap = new TreeMap<>();
        
    }
    
    public boolean book(int startTime, int endTime) {

        // if event is persent in overlaped then return false
        Integer prev = overlappedMap.lowerKey(endTime);
        if(prev != null && startTime <= overlappedMap.get(prev)-1){ // overlaping
            return false;
        }
        // insert into booking and if it is overlaping with
        // any booking then insert into overlaped map

        for(int booking[]: bookings){
            // booking[0], start
            // booking[1], end

            int commStart = Math.max( booking[0], startTime);
            int commEnd = Math.min(booking[1], endTime);
            if(commStart < commEnd){
               overlappedMap.put(commStart, commEnd);
           
            }

        }
        bookings.add(new int[]{startTime, endTime});
        return true;

        
    }
}

// m-2
import java.util.*;

class MyCalendarTwo {
    TreeMap<Integer, Integer> bookings;
    int maxAllowed;

    public MyCalendarTwo() {
        bookings = new TreeMap<>();
        maxAllowed = 2; // max 2 events allowed at same time
    }

    public boolean book(int start, int end) {
        // Start time par +1 event, end time par -1 event
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);

        int overlapCount = 0;

        // Prefix sum of active bookings
        for (Map.Entry<Integer, Integer> entry : bookings.entrySet()) {
            overlapCount += entry.getValue();
            if (overlapCount > maxAllowed) {
                // Revert changes
                bookings.put(start, bookings.get(start) - 1);
                if (bookings.get(start) == 0) {
                    bookings.remove(start);
                }

                bookings.put(end, bookings.get(end) + 1);
                if (bookings.get(end) == 0) {
                    bookings.remove(end);
                }

                return false; // triple booking detected
            }
        }

        return true; // booking successful
    }
}


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */

