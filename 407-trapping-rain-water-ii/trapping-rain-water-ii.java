import java.util.*;

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        // Min Heap: cell with lowest height gets processed first
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Step 1: Add boundary cells to heap
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int totalWater = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Step 2: BFS from the lowest boundary cell
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            for (int[] dir : dirs) {
                int x = cell.x + dir[0];
                int y = cell.y + dir[1];

                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    // Water trapped = max(0, currentBoundaryHeight - neighborHeight)
                    totalWater += Math.max(0, cell.height - heightMap[x][y]);
                    // Push the max height to maintain water level
                    minHeap.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
                }
            }
        }

        return totalWater;
    }

    // Custom Cell class for storing coordinates and height
    static class Cell {
        int x, y, height;
        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
