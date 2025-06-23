// Question Link: https://leetcode.com/problems/product-of-array-except-self/

class Solution {

    /*
    1️⃣ Brute Force Approach:
    - For each index, multiply all other elements.
    - Time Complexity: O(n^2)
    - Space Complexity: O(1) (excluding output)
    */
    public int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // For each index
        for (int i = 0; i < n; i++) {
            int product = 1;
            // Multiply all other elements except nums[i]
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    /*
    2️⃣ Optimal Approach (Left Product and Right Product Arrays):
    - Use two passes to compute left and right products.
    - Time Complexity: O(n)
    - Space Complexity: O(n)
    */
    public int[] productExceptSelfTwoArrays(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        // Calculate left products
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Calculate right products
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Calculate result by multiplying left and right products
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    /*
    3️⃣ Optimal Space (In-Place Output Array + Single Variable for Right Product):
    - Use output array to store left products in first pass.
    - In second pass, multiply output elements with running product from right.
    - Time Complexity: O(n)
    - Space Complexity: O(1) (excluding result array)
    */
    public int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // First pass: store left products in result array
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Second pass: multiply with running product from the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
