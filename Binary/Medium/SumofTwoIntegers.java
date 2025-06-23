// Question Link: https://leetcode.com/problems/sum-of-two-integers/

class Solution {

    /*
    Approach: Bit Manipulation (Using XOR and AND)
    - XOR (^) acts like addition without carry.
    - AND (&) + left shift (<< 1) finds carry positions.
    - Repeat until carry becomes zero.
    - Time Complexity: O(1) (since integer is 32 bits max)
    - Space Complexity: O(1)
    */
    public int getSum(int a, int b) {
        // Iterate till there's no carry
        while (b != 0) {
            // Calculate carry (common set bits of a and b)
            int carry = (a & b) << 1;

            // Add without carry using XOR
            a = a ^ b;

            // Assign carry to b for next iteration
            b = carry;
        }
        // Final value of a is the result
        return a;
    }
}
