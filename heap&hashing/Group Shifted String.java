class Solution {
    public static String getKey(String str){
        String key = "";
        for(int i = 1; i < str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            int diff = curr - prev;
            if(diff < 0){
                diff += 26;
            }
            key += diff + "#";
        }
        key += ".";
        return key;
    }

    public ArrayList<ArrayList<String>> groupShiftedString(String[] arr) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String str : arr){
            String key = getKey(str);

            if(!map.containsKey(key)){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                ArrayList<String> list = map.get(key); // ✅ fixed line
                list.add(str);
            }
        }

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(ArrayList<String> list : map.values()){
            res.add(list);
        }

        return res;
    }
}
