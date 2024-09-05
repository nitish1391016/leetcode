class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // Step 1: Calculate the sum of existing rolls
        int rollsSum = 0;
        for (int x : rolls) {
            rollsSum += x;
        }
        
        // Step 2: Calculate the total sum needed for all rolls (existing + missing)
        int totalSum = mean * (rolls.length + n);
        
        // Step 3: Calculate the sum needed for the missing rolls
        int missingSum = totalSum - rollsSum;
        
        // Step 4: Check if it's possible to distribute the missing sum
        if (missingSum < n || missingSum > n * 6) {
            return new int[0];  // If not possible, return an empty array
        }
        
        // Step 5: Distribute the sum as evenly as possible
        int[] res = new int[n];
        int quotient = missingSum / n;
        int remainder = missingSum % n;
        
        // Step 6: Fill the array with the quotient, and distribute the remainder
        for (int i = 0; i < n; i++) {
            res[i] = quotient + (i < remainder ? 1 : 0);
        }
        
        return res;
    }
}
