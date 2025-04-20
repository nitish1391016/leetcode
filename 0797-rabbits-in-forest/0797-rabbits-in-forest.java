class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> groupFreq = new HashMap<>();
        int count = 0;
        
        for (int ele : answers) {
            if (ele == 0) {
                count += 1;
            } else {
                groupFreq.put(ele, groupFreq.getOrDefault(ele, 0) + 1);
                if (groupFreq.get(ele) == ele + 1) {
                    count += ele + 1;
                    groupFreq.put(ele, 0);
                }
            }
        }
        
        for (int key : groupFreq.keySet()) {
            int freq = groupFreq.get(key);
            if (freq > 0) {
                count += key + 1;
            }
        }
        
        return count;
    }
}