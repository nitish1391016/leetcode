// Class to solve the problem "Count Substrings That Satisfy K-Constraint I"
// 
// Problem statement:
// You are given a binary string `s` and an integer `k`.
//
// A binary string satisfies the k-constraint if either of the following conditions holds:
// - The number of 0's in the string is at most `k`.
// - The number of 1's in the string is at most `k`.
//
// Return an integer denoting the number of substrings of `s` that satisfy the k-constraint.
//
// Example 1:
// Input: s = "10101", k = 1
// Output: 12
// Explanation: Every substring of `s` except the substrings "1010", "10101", and "0101" satisfies the k-constraint.
//
// Example 2:
// Input: s = "1010101", k = 2
// Output: 25
// Explanation: Every substring of `s` except the substrings with a length greater than 5 satisfies the k-constraint.
//
// Example 3:
// Input: s = "11111", k = 1
// Output: 15
// Explanation: All substrings of `s` satisfy the k-constraint.
//
// Constraints:
// - 1 <= s.length <= 50
// - 1 <= k <= s.length
// - s[i] is either '0' or '1'.

public class LeetCode_3258_CountSubstringsThatSatisfyKConstraint {

    // Method to count substrings that satisfy the K-constraint using a brute-force approach
    // Time Complexity: O(n^2), Space Complexity: O(1)
    public int countKConstraintSubstrings(String s, int k) {
        int res = 0; // Variable to store the result (number of valid substrings)
        
        // Loop through each character in the string as the starting point of a substring
        for (int i = 0; i < s.length(); i++) {
            int zero = 0, one = 0; // Counters for '0's and '1's in the substring
            
            // Extend the substring from index `i` to the end of the string
            for (int j = i; j < s.length(); j++) {
                
                // Update the counters based on the current character
                if (s.charAt(j) == '0') {
                    zero++;
                } else {
                    one++;
                }
                
                // Check if the substring satisfies the K-constraint
                // If the number of '0's or '1's in the substring is less than or equal to `k`
                if (zero <= k || one <= k) {
                    res++; // Increment the result as the substring is valid
                }
            }
        }
        
        return res; // Return the total count of valid substrings
    }

    // Optimized method to count substrings that satisfy the K-constraint
    // Time Complexity: O(n), Space Complexity: O(1)
    public int countKConstraintSubstringsOptimized(String s, int k) {
        int l = 0, r = 0; // Two pointers representing the window
        int one = 0, zero = 0; // Counters for '0's and '1's in the window
        int ans = 0; // Variable to store the result (number of valid substrings)

        // Iterate over the string with the right pointer
        while (r < s.length()) {
            // Update the counters based on the current character
            if (s.charAt(r) == '0') zero++;
            else one++;
            
            // Shrink the window from the left if both counters exceed k
            while (zero > k && one > k) {
                if (s.charAt(l) == '0') zero--;
                else one--;
                l++;
            }

            // At this point, the window [l, r] is valid
            // The number of valid substrings ending at r is (r - l + 1)
            // Explanation:
            // After sliding 'l' if needed, we have found the leftmost index for the subarrays
            // that end at 'r'. For example, consider the array [1, 2, 3, 4, 5]. If `r` is at `5`,
            // the valid substrings ending at `5` are [4, 5], [3, 4, 5], [2, 3, 4, 5], and [1, 2, 3, 4, 5].
            // The number of such substrings is simply `r - l + 1`.
            // This works because shorter substrings that would have been valid were already
            // counted in previous iterations of `r`. For instance, when `r = 3`, substrings like
            // [2, 3] and [3] would have been accounted for.
            ans += (r - l + 1);

            // Move the right pointer to the next character
            r++;
        }

        return ans; // Return the total count of valid substrings
    }
}
