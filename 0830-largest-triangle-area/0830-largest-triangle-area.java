class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int n = points.length;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double curr = triangleArea(points[i], points[j], points[k]);
                    if (curr > maxArea) {
                        maxArea = curr;
                    }
                }
            }
        }
        
        return maxArea;
    }
    
    private double triangleArea(int[] p1, int[] p2, int[] p3) {
        // Shoelace formula
        return 0.5 * Math.abs(
            p1[0]*(p2[1]-p3[1]) + 
            p2[0]*(p3[1]-p1[1]) + 
            p3[0]*(p1[1]-p2[1])
        );
    }
}
