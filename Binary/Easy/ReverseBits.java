// Question Link: https://leetcode.com/problems/reverse-bits/

class Solution {

    /*
    1️⃣ Basic Approach (Bit by Bit)
    - Extract each bit using (n & 1)
    - Shift it to its reversed position
    - Time Complexity: O(32) = O(1)
    - Space Complexity: O(1)
    */
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Left shift result to make space for next bit
            result <<= 1;

            // Extract last bit from n and add it to result
            result |= (n & 1);

            // Unsigned right shift n to move to next bit
            n >>>= 1;
        }
        return result;
    }

    /*
    2️⃣ Optimized Approach (Optional)
    - Use lookup table for faster processing if needed for multiple calls.
    - Not commonly needed unless repeated calls.
    - Time Complexity: O(1) for each reverseBits call
    - Space Complexity: O(1) extra
    */
    // (Optional implementation — usually interviewer focuses on approach 1)
}
