package Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int k = solution.removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);
        System.out.print("Array after removing duplicates: [");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i < k - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}




/* Solved Date: 25 June 2026

*Problem Statement*
 Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

 Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.

 The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

 Custom Judge:

 The judge will test your solution with the following code:

 int[] nums = [...]; // Input array
 int[] expectedNums = [...]; // The expected answer with correct length

 int k = removeDuplicates(nums); // Calls your implementation

 assert k == expectedNums.length;
 for (int i = 0; i < k; i++) {
 assert nums[i] == expectedNums[i];
 }
 If all assertions pass, then your solution will be accepted.

 Example 1:

 Input: nums = [1,1,2]
 Output: 2, nums = [1,2,_]
 Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).
 Example 2:

 Input: nums = [0,0,1,1,1,2,2,3,3,4]
 Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).

 Constraints:

 1 <= nums.length <= 3 * 104
 -100 <= nums[i] <= 100
 nums is sorted in non-decreasing order.
 ----------------------------------------||----------------------------------------||----------------------------------------||
 *Intuition*
 - Since the array is already sorted, all duplicates will appear next to each other.
 - So we don’t need extra space to track duplicates — we can use two pointers:
 - One pointer (i) keeps track of the position of the last unique element
 - Another pointer (j) scans through the array
 - Whenever we find a new unique value, we place it at the next position of i.
 ----------------------------------------||----------------------------------------||----------------------------------------||
 *Approach*
 - Start i = 0, which points to the first unique element.
 - Traverse the array from index 1 to n-1 using j.
 - If nums[j] != nums[i], it means we found a new unique element:
 - increment i
 - place nums[j] at nums[i]
 - After the loop, the number of unique elements is i + 1.
 ----------------------------------------||----------------------------------------||----------------------------------------||
 *Complexity*
 - Time complexity: O(n)
 - We traverse the array once.
 - Space complexity: O(1)
 - We modify the array in-place without using extra space.
 ----------------------------------------||----------------------------------------||----------------------------------------||
 *Output*
 Number of unique elements: 5
 Array after removing duplicates: [0, 1, 2, 3, 4]
 */