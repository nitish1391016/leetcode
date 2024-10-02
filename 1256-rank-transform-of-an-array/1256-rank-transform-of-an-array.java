class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sortedArray = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArray);

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0,rank=0;
        while( i < n-1) {
            if(sortedArray[i]<sortedArray[i+1]) rank++;
            map.put(sortedArray[i], rank);
            i++;
        }
        if(i == n-1)
            map.put(sortedArray[i], ++rank);
        for(i=0;i<n;i++){
            sortedArray[i] = map.get(arr[i]);
        }
        return sortedArray;
    }
}