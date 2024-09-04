class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Use a large prime number slightly larger than the grid size to avoid collisions.
        int prime = 40009; // Fine-tuned large prime number close to grid size
        HashSet<Integer> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] * prime + o[1]);
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
                while (command-- > 0) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];
                    if (set.contains(nx * prime + ny)) {
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
