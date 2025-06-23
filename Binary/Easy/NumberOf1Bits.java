// Question Link: https://leetcode.com/problems/number-of-1-bits/

class Solution {

    /*
    1️⃣ Basic Bit Checking Approach:
    - Check each bit one by one.
    - Use (n & 1) to check last bit.
    - Right shift n by 1 each time.
    - Time Complexity: O(32) = O(1)
    - Space Complexity: O(1)
    */
    public int hammingWeightBasic(int n) {
        int count = 0;

        while (n != 0) {
            // If last bit is 1, increment count
            count += (n & 1);
            // Right shift n by 1
            n >>>= 1;  // Unsigned right shift to handle negatives correctly
        }
        return count;
    }

    /*
    2️⃣ Brian Kernighan’s Algorithm (Optimal)
    - Continuously flip the least significant '1' bit to '0'
    - Count number of operations until n becomes 0
    - Time Complexity: O(k), where k = number of set bits
    - Space Complexity: O(1)
    */
    public int hammingWeightKernighan(int n) {
        int count = 0;

        while (n != 0) {
            // n & (n-1) drops the lowest set bit
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
