package Strings;

public class ReverseString {

    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder(new String(s));
        sb.reverse();

        char[] reversed = sb.toString().toCharArray();

        for (int i = 0; i < s.length; i++) {
            s[i] = reversed[i];
        }
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);

        System.out.print("Reversed String: ");
        for (char ch : s) {
            System.out.print(ch + " ");
        }
    }
}
/* Solved Date: 24 June 2026

*Problem Statement*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.
----------------------------------------||----------------------------------------||----------------------------------------||
 *Intuition*
- We need to reverse the given character array.
- One simple way is to first convert the character array into a string.
- Then we can use `StringBuilder`'s built-in `reverse()` method to reverse the string easily.
- After reversing, we convert it back into a character array and copy the characters back into the original input array.
----------------------------------------||----------------------------------------||----------------------------------------||
 *Approach*
- Convert the input character array `s` into a string.
- Create a `StringBuilder` using that string.
- Reverse the string using `sb.reverse()`.
- Convert the reversed string back into a character array.
- Traverse the reversed array and copy each character back into the original array `s`.
----------------------------------------||----------------------------------------||----------------------------------------||
 *Complexity*
- Time Complexity: O(n)
  - Reversing the string and copying characters back both take linear time.
- Space Complexity: O(n)
  - Extra space is used for the `StringBuilder` and the reversed character array.
----------------------------------------||----------------------------------------||----------------------------------------||
 *Output*
Reversed String: o l l e h
 */