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

// m-2 sweep line algo

class MyCalendarTwo {
    TreeMap<Integer, Integer> booking;
    int maxAllowed;

    public MyCalendarTwo() {
        booking = new TreeMap<>();
        maxAllowed = 2;

    }

    public boolean book(int startTime, int endTime) {

        booking.put(startTime, booking.getOrDefault(startTime, 0) + 1);
        booking.put(endTime, booking.getOrDefault(endTime, 0) - 1);

        int overlappedCount = 0;

        for (int key : booking.keySet()) {
            overlappedCount += booking.get(key);

            if (overlappedCount > maxAllowed) {
                booking.put(startTime, booking.get(startTime)-1);
                if (booking.get(startTime) == 0) {
                    booking.remove(startTime);
                }
                booking.put(endTime, booking.get(endTime ) + 1);
                if (booking.get(endTime) == 0) {
                    booking.remove(endTime);
                }
                return false;
            }
        }
        return true;

    }
}