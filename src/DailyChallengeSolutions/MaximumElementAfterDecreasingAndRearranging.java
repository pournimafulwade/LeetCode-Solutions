package DailyChallengeSolutions;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        MaximumElementAfterDecreasingAndRearranging solution =
                new MaximumElementAfterDecreasingAndRearranging();

        int[] arr1 = {2, 2, 1, 2, 1};
        int[] arr2 = {100, 1, 1000};
        int[] arr3 = {1, 2, 3, 4, 5};

        int ans1 = solution.maximumElementAfterDecrementingAndRearranging(arr1);
        System.out.println("Modified Array: " + Arrays.toString(arr1));
        System.out.println("Maximum Element: " + ans1);
        System.out.println();

        int ans2 = solution.maximumElementAfterDecrementingAndRearranging(arr2);
        System.out.println("Modified Array: " + Arrays.toString(arr2));
        System.out.println("Maximum Element: " + ans2);
        System.out.println();

        int ans3 = solution.maximumElementAfterDecrementingAndRearranging(arr3);
        System.out.println("Modified Array: " + Arrays.toString(arr3));
        System.out.println("Maximum Element: " + ans3);
    }
}

/* Solved Date: 28 June 2026

*Problem Statement*
You are given an array of positive integers arr.

You can perform the following operations any number of times:
- Decrease any element to a smaller positive integer.
- Rearrange the elements in any order.

After the operations:
1. The first element must be 1.
2. The absolute difference between adjacent elements must be at most 1.

Return the maximum possible value of any element after satisfying these conditions.

Example 1:
Input: arr = [2,2,1,2,1]
Output: 2

Example 2:
Input: arr = [100,1,1000]
Output: 3

Example 3:
Input: arr = [1,2,3,4,5]
Output: 5

Constraints:
1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9

----------------------------------------||----------------------------------------||----------------------------------------||

*Intuition*
- Since rearranging is allowed, we should first sort the array.
- The smallest element must become 1.
- Every next element can be at most one greater than the previous element.
- If an element is larger than the allowed value, decrease it.
- This greedy approach keeps every element as large as possible while satisfying the conditions.

----------------------------------------||----------------------------------------||----------------------------------------||

*Approach*
- Sort the array.
- Set the first element to 1.
- Traverse from left to right:
  - Update each element as:
    arr[i] = min(arr[i], arr[i - 1] + 1)
- Return the last element, which is the maximum possible value.

----------------------------------------||----------------------------------------||----------------------------------------||

*Complexity*
- Time Complexity: O(n log n)
  - Sorting takes O(n log n).
  - Single traversal takes O(n).

- Space Complexity: O(1)
  - No extra space is used apart from the sorting algorithm.

----------------------------------------||----------------------------------------||----------------------------------------||

*Output*

Modified Array: [1, 1, 2, 2, 2]
Maximum Element: 2

Modified Array: [1, 2, 3]
Maximum Element: 3

Modified Array: [1, 2, 3, 4, 5]
Maximum Element: 5

*/