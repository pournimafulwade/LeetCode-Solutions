package Stacks;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";
        String s5 = "([)]";

        System.out.println("Input: " + s1 + " -> Output: " + solution.isValid(s1));
        System.out.println("Input: " + s2 + " -> Output: " + solution.isValid(s2));
        System.out.println("Input: " + s3 + " -> Output: " + solution.isValid(s3));
        System.out.println("Input: " + s4 + " -> Output: " + solution.isValid(s4));
        System.out.println("Input: " + s5 + " -> Output: " + solution.isValid(s5));
    }
}




/* Solved Date: 24 June 2026

*Problem Statement*
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 ----------------------------------------||----------------------------------------||----------------------------------------||
 *Intuition*
- A closing bracket must always match the most recently opened bracket.
- This “last opened, first closed” behavior is exactly what a stack is good for.
  - If we see an opening bracket (, {, or [, we push it into the stack.
  - If we see a closing bracket ), }, or ], it must match the top of the stack.
  - If it doesn’t match, or the stack is empty when we try to close, the string is invalid.
  - At the end, the stack must be empty, meaning every opening bracket had a matching closing bracket.
 ----------------------------------------||----------------------------------------||----------------------------------------||
 *Approach*
- Create a stack to store opening brackets.
- Traverse each character in the string:
  - If it is an opening bracket, push it into the stack.
  - Otherwise, it is a closing bracket:
    - If the stack is empty, return false.
    - Pop the top element from the stack.
    - Check whether it matches the current closing bracket.
       - If not, return false.
- After processing all characters, return true only if the stack is empty.
 ----------------------------------------||----------------------------------------||----------------------------------------||
 *Complexity*
 - Time complexity: O(n)
    - Each character is pushed and popped at most once.
 - Space complexity: O(n)
    - In the worst case, all characters could be opening brackets and stored in the stack.
 ----------------------------------------||----------------------------------------||----------------------------------------||
 *Output*
Input: () -> Output: true
Input: ()[]{} -> Output: true
Input: (] -> Output: false
Input: ([]) -> Output: true
Input: ([)] -> Output: false
 */