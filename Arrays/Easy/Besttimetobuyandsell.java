// Question Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {

    /*
    1️⃣ Brute Force Approach:
    - Try every possible pair of days (buy first, sell later)
    - Time Complexity: O(n^2)
    - Space Complexity: O(1)
    */
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;

        // Check all possible pairs of buy and sell days
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate profit if bought on day i and sold on day j
                int profit = prices[j] - prices[i];
                // Update maxProfit if current profit is higher
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /*
    2️⃣ Optimal Approach (Single Pass):
    - Keep track of the minimum price seen so far and the max profit possible at each step.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int maxProfitOptimal(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // Initialize to max possible value
        int maxProfit = 0;

        // Iterate through each day's price
        for (int price : prices) {
            // Update minPrice if current price is lower
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate potential profit and update maxProfit if higher
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    /*
    3️⃣ Kadane’s Algorithm Variant (Maximum Subarray Logic):
    - Convert to maximum difference subarray problem.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int maxProfitKadane(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;

        // Iterate through price differences starting from day 1
        for (int i = 1; i < prices.length; i++) {
            // Calculate daily profit or loss
            int diff = prices[i] - prices[i - 1];
            // Add to currentProfit (if negative, reset to 0)
            currentProfit = Math.max(0, currentProfit + diff);
            // Update maxProfit if higher
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
}
