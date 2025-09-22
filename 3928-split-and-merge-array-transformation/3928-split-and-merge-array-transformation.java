class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<Integer>();
        for(int ele: nums1)
            list1.add(ele);
        List<Integer> list2 = new ArrayList<Integer>();
        for(int ele: nums2)
            list2.add(ele);
        if(list1.equals(list2))   return 0;

        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(list1);
        Set<String> seen = new HashSet<>();
        seen.add(list1.toString());
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i=0;i<size;i++){
                List<Integer> curr = q.poll();
                if(curr.equals(list2)) return steps; 
                for(int l=0;l<curr.size();l++){
                    for(int r=l;r<curr.size();r++){
                        // making sublist of 0 does not make sense, so starting from l+1
                        List<Integer> left = new ArrayList<>(curr.subList(0, l));
                        List<Integer> right = new ArrayList<>(curr.subList(r+1, curr.size()));
                        List<Integer> rem = new ArrayList<>(curr.subList(l, r+1));

                        List<Integer> newli = new ArrayList<>();
                        newli.addAll(left);
                        newli.addAll(right);
                        for(int ind = 0;ind < newli.size();ind++){
                            if (ind >= l && ind <= r+1) continue; // skip no-op moves
                            List<Integer> finalli = new ArrayList<Integer>(newli);
                            finalli.addAll(ind, rem);
                            if(!seen.contains(finalli.toString())){
                                seen.add(finalli.toString());
                                q.offer(finalli);
                            }
                        }
                    }
                }
            }
            steps++; 
        }
        return -1;
    }

}