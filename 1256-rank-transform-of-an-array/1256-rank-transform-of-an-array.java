class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }
            else{
                map.put(arr[i], new LinkedList<Integer>());
                map.get(arr[i]).add(i);
            }
        }
        int rank =1;
        for(int key: map.keySet()){
            for(int index: map.get(key)){
                arr[index] = rank;
            }
            rank++;
        }
        return arr;
    }
}