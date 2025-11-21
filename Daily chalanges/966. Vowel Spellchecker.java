import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        // Step 1: Preprocess wordlist
        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String devowelWord = devowel(word);
            vowelInsensitive.putIfAbsent(devowelWord, word);
        }

        // Step 2: Answer queries
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (exactWords.contains(query)) {
                result[i] = query; // Rule 1
            } else {
                String lower = query.toLowerCase();
                if (caseInsensitive.containsKey(lower)) {
                    result[i] = caseInsensitive.get(lower); // Rule 2
                } else {
                    String devowelQuery = devowel(query);
                    if (vowelInsensitive.containsKey(devowelQuery)) {
                        result[i] = vowelInsensitive.get(devowelQuery); // Rule 3
                    } else {
                        result[i] = ""; // Rule 4
                    }
                }
            }
        }

        return result;
    }

    // Helper: replace vowels with '*'
    private String devowel(String word) {
        return word.toLowerCase().replaceAll("[aeiou]", "*");
    }
}

// lalit kumar
