package DailyChallengeSolutions;

public class NumberOfSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {

        int[] count = new int[3];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            count[s.charAt(right) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {

                ans += s.length() - right;

                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        NumberOfSubstringsContainingAllThreeCharacters solution =
                new NumberOfSubstringsContainingAllThreeCharacters();

        String s1 = "abcabc";
        String s2 = "aaacb";
        String s3 = "abc";

        System.out.println("Input : " + s1);
        System.out.println("Output: " + solution.numberOfSubstrings(s1));
        System.out.println();

        System.out.println("Input : " + s2);
        System.out.println("Output: " + solution.numberOfSubstrings(s2));
        System.out.println();

        System.out.println("Input : " + s3);
        System.out.println("Output: " + solution.numberOfSubstrings(s3));
    }
}


/* Solved Date: 28 June 2026

*Problem Statement*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1


Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.

----------------------------------------||----------------------------------------||----------------------------------------||

*Intuition*
- We need to count all substrings that contain at least one 'a', one 'b', and one 'c'.
- Instead of checking every substring (which would be O(n²)), we use a sliding window.
- Once a window contains all three characters, every substring extending to the right is also valid.

----------------------------------------||----------------------------------------||----------------------------------------||

*Approach*
- Use two pointers:
  - left → start of the window
  - right → end of the window
- Maintain the count of 'a', 'b', and 'c' in the current window.
- Expand the window by moving right.
- Whenever the window contains all three characters:
  - Every substring starting at left and ending from right to n-1 is valid.
  - Add (n - right) to the answer.
  - Shrink the window from the left.

----------------------------------------||----------------------------------------||----------------------------------------||

*Complexity*
- Time Complexity: O(n)
  - Each character enters and leaves the sliding window at most once.

- Space Complexity: O(1)
  - We only use an array of size 3 to store the frequency of 'a', 'b', and 'c'.

----------------------------------------||----------------------------------------||----------------------------------------||

*Output*

Input : abcabc
Output: 10

Input : aaacb
Output: 3

Input : abc
Output: 1

*/