public class 2349. Design a Number Container System {
  class NumberContainers {
    HashMap<Integer,Integer>idxToNumber;
    HashMap<Integer, TreeSet<Integer>>numberToIdx;

    public NumberContainers() {
        idxToNumber = new HashMap<>();
        numberToIdx = new HashMap<>();

    }
    
    public void change(int index, int number) {
        //pehele se number pada hai? yes to remove(delete old) and put in idxto number
        if(idxToNumber.containsKey(index)){
            int prev = idxToNumber.get(index);
            numberToIdx.get(prev).remove(index);
            if(numberToIdx.get(prev).size() == 0){
                numberToIdx.remove();
            }
        }
        // insert new
        idxToNumber.put(index, number);
        if(!numberToIdx.containsKey(number)){
            numberToIdx.put(number, new TreeSet<>());
        }
        numberToIdx.get(number).add(index);
        
    }
    
    public int find(int number) {
        if(!numberToIdx.containsKey(number)){
           return -1;
        }
        return numberToIdx.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
}
