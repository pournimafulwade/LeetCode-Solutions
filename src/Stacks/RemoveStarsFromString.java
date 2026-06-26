package Stacks;

import java.util.Stack;

public class RemoveStarsFromString {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if(ch == '*' && !stack.isEmpty()){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch:stack){
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveStarsFromString solution = new RemoveStarsFromString();

        String s1 = "leet**cod*e";
        String s2 = "erase*****";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.removeStars(s1));

        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.removeStars(s2));
    }
}

/* Solved Date: 26 June 2026

*Problem Statement*
You are given a string s, which contains stars '*'.

In one operation:
- Choose a star '*' in the string.
- Remove the closest non-star character to its left, as well as the star itself.

Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.

Example 1:
Input: s = "leet**cod*e"
Output: "lecoe"

Example 2:
Input: s = "erase*****"
Output: ""

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters and '*'.
The operation can always be performed.

----------------------------------------||----------------------------------------||----------------------------------------||

*Intuition*
- Every '*' removes the most recently added character.
- This follows the Last-In-First-Out (LIFO) principle.
- A stack is the ideal data structure to keep track of characters.
- Whenever a '*' is encountered, remove the top character from the stack.

----------------------------------------||----------------------------------------||----------------------------------------||

*Approach*
- Create an empty stack.
- Traverse each character of the string.
- If the character is '*', pop the top element from the stack.
- Otherwise, push the character onto the stack.
- After processing the entire string, append all remaining characters from the stack into a StringBuilder.
- Return the final string.

----------------------------------------||----------------------------------------||----------------------------------------||

*Complexity*
- Time Complexity: O(n)
  - Each character is pushed and popped at most once.

- Space Complexity: O(n)
  - In the worst case, the stack stores all characters.

----------------------------------------||----------------------------------------||----------------------------------------||

*Output*

Input: leet**cod*e
Output: lecoe

Input: erase*****
Output:
*/