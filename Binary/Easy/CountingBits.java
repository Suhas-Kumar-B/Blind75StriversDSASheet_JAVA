// Question Link: https://leetcode.com/problems/counting-bits/

class Solution {

    /*
    1️⃣ Brute Force (Use Brian Kernighan’s or Bit Count individually for each number)
    - For each number from 0 to n, count set bits.
    - Time Complexity: O(n * log n)
    - Space Complexity: O(1) extra + result array
    */
    public int[] countBitsBruteForce(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = countOnes(i);
        }
        return result;
    }

    // Helper method to count number of 1s in a number
    private int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    /*
    2️⃣ Optimal Approach: Dynamic Programming + Bit Shift
    - Idea:
        Number of 1's in i = Number of 1's in (i / 2) + (i % 2)
    - Time Complexity: O(n)
    - Space Complexity: O(1) extra + result array
    */
    public int[] countBitsDP(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            // result[i >> 1] is count for i/2, (i & 1) is 1 if i is odd
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
