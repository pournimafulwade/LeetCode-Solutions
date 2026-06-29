package DailyChallengeSolutions;

import java.util.Arrays;

public class NumberOfStringsThatAppearAsSubstringsInWord {

    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfStringsThatAppearAsSubstringsInWord solution =
                new NumberOfStringsThatAppearAsSubstringsInWord();

        String[] patterns1 = {"a", "abc", "bc", "d"};
        String word1 = "abc";

        String[] patterns2 = {"a", "b", "c"};
        String word2 = "aaaaabbbbb";

        String[] patterns3 = {"a", "a", "a"};
        String word3 = "ab";

        System.out.println("Input: Pattern: " + Arrays.toString(patterns1) + " word: " + word1 + " Output: " + solution.numOfStrings(patterns1, word1));
        System.out.println("Input: Pattern: " + Arrays.toString(patterns2) + " word: " + word2 + " Output: "  + solution.numOfStrings(patterns2, word2));
        System.out.println("Input: Pattern: " + Arrays.toString(patterns3) + " word: " + word3 + " Output: "  + solution.numOfStrings(patterns3, word3));
    }
}
/* Solved Date: 27 June 2026

*Problem Statement*
Given an array of strings patterns and a string word, return the number of strings
in patterns that exist as a substring in word.

A substring is a contiguous sequence of characters within a string.

Example 1:
Input: patterns = ["a","abc","bc","d"], word = "abc"
Output: 3

Example 2:
Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
Output: 2

Example 3:
Input: patterns = ["a","a","a"], word = "ab"
Output: 3

Constraints:
1 <= patterns.length <= 100
1 <= patterns[i].length <= 100
1 <= word.length <= 100
patterns[i] and word consist of lowercase English letters.

----------------------------------------||----------------------------------------||----------------------------------------||

*Intuition*
- We need to check whether each string in the patterns array exists inside the given word.
- Java provides the built-in contains() method, which directly checks if one string is a substring of another.
- For every matching pattern, increase the count.

----------------------------------------||----------------------------------------||----------------------------------------||

*Approach*
- Initialize a counter to 0.
- Traverse every string in the patterns array.
- For each pattern, check if word.contains(pattern).
- If true, increment the counter.
- Return the final count.

----------------------------------------||----------------------------------------||----------------------------------------||

*Complexity*
- Time Complexity: O(n × m)
  - n = number of patterns
  - m = length of the word (contains() may scan the word)

- Space Complexity: O(1)
  - No extra data structure is used.

----------------------------------------||----------------------------------------||----------------------------------------||

*Output*

Input: patterns = ["a","abc","bc","d"], word = "abc"
Output: 3

Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
Output: 2

Input: patterns = ["a","a","a"], word = "ab"
Output: 3
*/