class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            map.put(chS, map.getOrDefault(chS, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char chT = t.charAt(i);
            if (map.get(chT) != null) {

                if (map.get(chT) == 1) { // if freq is 1 remove from map
                    map.remove(chT);
                } else {
                    map.put(chT, map.get(chT) - 1); // decrease the freq by 1
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();

    }
}