// Question Link: https://leetcode.com/problems/missing-number/

class Solution {

    /*
    1️⃣ Sorting + Linear Scan
    - Sort the array and check which number is missing.
    - Time Complexity: O(n log n)
    - Space Complexity: O(1)
    */
    public int missingNumberSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        // If last number is missing (n)
        return nums.length;
    }

    /*
    2️⃣ Sum Formula (Optimal)
    - Sum of 0 to n = n*(n+1)/2
    - Missing number = expectedSum - actualSum
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int missingNumberSum(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    /*
    3️⃣ XOR Trick (Optimal)
    - XOR of a number with itself is 0
    - XOR of a number with 0 is the number itself
    - XOR all numbers from 0 to n and all elements in the array
    - Missing number will be left out
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int missingNumberXOR(int[] nums) {
        int xor = 0;
        int n = nums.length;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        // XOR all numbers in the array
        for (int num : nums) {
            xor ^= num;
        }

        // Remaining value is the missing number
        return xor;
    }
}
