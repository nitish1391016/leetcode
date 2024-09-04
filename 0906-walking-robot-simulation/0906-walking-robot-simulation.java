class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + " " + obstacle[1]);
        }

        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int directionIndex = 0, posX = 0, posY = 0, maxDistance = 0;

        for (int command : commands) {
            if (command == -1) {
                directionIndex = (directionIndex + 1) % 4;
            } else if (command == -2) {
                directionIndex = (directionIndex + 3) % 4;
            } else {
                int dx = directions[directionIndex][0];
                int dy = directions[directionIndex][1];

                while (command-- > 0) {
                    int nextX = posX + dx;
                    int nextY = posY + dy;
                    if (obstacleSet.contains(nextX + " " + nextY)) {
                        break;
                    }
                    posX = nextX;
                    posY = nextY;
                }
                maxDistance = Math.max(maxDistance, posX * posX + posY * posY);
            }
        }
        return maxDistance;
    }
}
