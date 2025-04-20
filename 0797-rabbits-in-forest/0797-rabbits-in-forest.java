import java.util.HashMap;
import java.util.Map;

/**
 * Solution class to determine the minimum number of rabbits in the forest
 * based on their answers about same-colored rabbits.
 */
public class Solution {
    /**
     * Calculates the minimum total number of rabbits that could be in the forest.
     *
     * @param answers an array where answers[i] is the number of other rabbits having the same color as rabbit i
     * @return the minimum total number of rabbits consistent with the provided answers
     */
    public int numRabbits(int[] answers) {
        // Map to track how many times each answer value has been seen so far
        Map<Integer, Integer> groupFreq = new HashMap<>();
        // 'count' will accumulate the minimum rabbit total
        int count = 0;

        // Iterate through each rabbit's answer
        for (int answer : answers) {
            if (answer == 0) {
                // A rabbit that says "0" implies it's the only one of its color
                count += 1;
            } else {
                // Increase the frequency of this answer (group size = answer + 1)
                int freq = groupFreq.getOrDefault(answer, 0) + 1;
                groupFreq.put(answer, freq);

                // Once we've seen (answer + 1) rabbits claiming this answer,
                // we have a complete group and can count them
                if (freq == answer + 1) {
                    count += answer + 1;
                    // Reset frequency to start counting a potential new group
                    groupFreq.put(answer, 0);
                }
            }
        }

        // After processing all answers, any non-zero frequencies indicate
        // incomplete groups. Each such group still requires a full (answer + 1) rabbits.
        for (Map.Entry<Integer, Integer> entry : groupFreq.entrySet()) {
            int answer = entry.getKey();
            int freq = entry.getValue();
            if (freq > 0) {
                count += answer + 1;
            }
        }

        return count;
    }
}
