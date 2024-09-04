class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Optimized custom hash function with bit shifting
        HashSet<Integer> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add((o[0] << 16) + o[1]); // Using bit shifting
        }

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0;
        int result = 0;

        for (int command : commands) {
            if (command == -1) {
                d = (d + 1) % 4;
            } else if (command == -2) {
                d = (d + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];
                    if (set.contains((nx << 16) + ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    result = Math.max(result, x * x + y * y);
                }
            }
        }

        return result;
    }
}
