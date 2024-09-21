class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 1; i < 10; i++) {
            addNums(n, i, res);
        }
        return res;
    }

    private static void addNums(int limit, int num, List<Integer> res) {
        if (num > limit)
            return;

        res.add(num);
        for (int i = 0; i < 10; i++) {
            if (num < limit) {
                addNums(limit, num * 10 + i, res);
            } else
                break;
        }
    }
}