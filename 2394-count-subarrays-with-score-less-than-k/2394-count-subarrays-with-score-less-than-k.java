class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0; // Running sum of the current window (subarray)
        long res = 0; // Final result: count of subarrays with score < k
        // Two pointers approach: 'i' is the right end, 'j' is the left end of the window
        for (int i = 0, j = 0; i < nums.length; ++i) {
            sum += nums[i]; // Expand the window by adding the current element to sum
            // Shrink the window from the left as long as the score is not strictly less than k
            while (sum * (i - j + 1) >= k) {
                sum -= nums[j++]; // Remove nums[j] from sum and move left pointer forward
            }
            // At this point, all subarrays ending at 'i' and starting from j to i are valid
            res += i - j + 1; // Add the number of valid subarrays ending at index i
        }
        return res; // Return the total count
    }
}
