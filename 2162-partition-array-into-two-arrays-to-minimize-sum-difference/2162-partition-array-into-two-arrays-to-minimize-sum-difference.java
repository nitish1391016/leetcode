import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int k = n / 2;
        int total = 0;
        for (int num : nums) total += num;

        int[] left = Arrays.copyOfRange(nums, 0, k);
        int[] right = Arrays.copyOfRange(nums, k, n);

        Map<Integer, List<Integer>> leftSums = getSubsetSums(left);
        Map<Integer, List<Integer>> rightSums = getSubsetSums(right);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= k; i++) {
            List<Integer> leftList = leftSums.get(i);
            List<Integer> rightList = rightSums.get(k - i);
            Collections.sort(rightList);

            for (int sumLeft : leftList) {
                int target = total / 2 - sumLeft;
                int idx = Collections.binarySearch(rightList, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < rightList.size())
                    minDiff = Math.min(minDiff, Math.abs(total - 2 * (sumLeft + rightList.get(idx))));
                if (idx > 0)
                    minDiff = Math.min(minDiff, Math.abs(total - 2 * (sumLeft + rightList.get(idx - 1))));
            }
        }

        return minDiff;
    }

    private Map<Integer, List<Integer>> getSubsetSums(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= n; i++) map.put(i, new ArrayList<>());

        int limit = 1 << n;
        for (int mask = 0; mask < limit; mask++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    sum += arr[j];
                    count++;
                }
            }
            map.get(count).add(sum);
        }
        return map;
    }
}
