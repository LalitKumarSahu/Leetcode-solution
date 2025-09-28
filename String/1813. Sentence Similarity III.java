class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() > sentence2.length()){
            return areSentencesSimilar(sentence2, sentence1);
        }
        String smallerWord[] = sentence1.split(" ");
        String LargestWord[] = sentence2.split(" ");

        int start = 0;
        int end1 = smallerWord.length-1;
        int end2 = LargestWord.length-1;

        // find perfix word
        while(start <= end1 && smallerWord[start].equals(LargestWord[start])){
            start++;
        }

        // find suffix word
        while(start <= end1 && smallerWord[end1].equals(LargestWord[end2])){
            end1--;
            end2--;
        }
        return (start > end1); // perfix aur suffix hatane ke bad sen2 empty ho jana chaye




        
    }
}