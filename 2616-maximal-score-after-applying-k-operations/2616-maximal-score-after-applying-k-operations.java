class Solution {
    public long maxKelements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
        }

        for (int i = 0; i < k; i++) {
                int maxValue = maxHeap.poll();
                res += maxValue;
                int val = (int)Math.ceil((double)maxValue/3);
                maxHeap.add(val);
        }
        return res;
    }
}