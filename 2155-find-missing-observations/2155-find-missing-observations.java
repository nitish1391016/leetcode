class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int rollsSum = 0;
        for (int x : rolls)
            rollsSum += x;

        int missingSum = (mean * (rolls.length + n)) - rollsSum;
        if (missingSum < n || missingSum > n * 6)
            return new int[0];

        int[] res = new int[n];
        int quotient = missingSum / n;
        int remainder = missingSum % n;

        // Distribute the quotient and remainder
        for (int i = 0; i < n; i++) {
            res[i] = quotient + (i < remainder ? 1 : 0);
        }

        return res;
    }
}
