class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,TreeSet<Integer>> row = new HashMap<>();
        HashMap<Integer,TreeSet<Integer>> col = new HashMap<>();

        for(int[] axis:buildings){
            int x = axis[0];
            int y = axis[1];
            col.computeIfAbsent(x, k -> new TreeSet<Integer>()).add(y);
            row.computeIfAbsent(y, k -> new TreeSet<Integer>()).add(x);
        }
        int res = 0;
        for(int[] axis:buildings){
            int x = axis[0];
            int y = axis[1];
            boolean top = col.get(x).lower(y) != null;
            boolean bot = col.get(x).higher(y) != null;
            boolean left = row.get(y).lower(x) != null;
            boolean right = row.get(y).higher(x) !=null;
            if(top && bot && left && right){
                res++;
            }
        }
        return res;
    }
}