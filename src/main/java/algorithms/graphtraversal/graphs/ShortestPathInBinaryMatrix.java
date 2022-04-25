package algorithms.graphtraversal.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell
 * (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected
 * (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */
public class ShortestPathInBinaryMatrix {

  private int[][] DIRECTIONS = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

  public int shortestPathBinaryMatrix(int[][] grid) {
    if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
      return -1;
    }

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 1});

    while(!queue.isEmpty()) {
      int[] dir = queue.poll();
      int row = dir[0];
      int col = dir[1];
      int len = dir[2];

      grid[row][col] = 1;
      if(row == grid.length - 1 && col == grid[0].length - 1) {
        return len;
      }
      for(int[] path : DIRECTIONS) {
        int new_row = row + path[0];
        int new_col = col + path[1];

        if(isValidIndex(grid, new_row, new_col) && grid[new_row][new_col] == 0) {
          queue.add(new int[]{new_row, new_col, len + 1});
        }

      }
    }
    return -1;
  }

  private boolean isValidIndex(int[][] grid, int row, int col) { //23
    if(row >= 0 && row < grid.length) {
      if(col >= 0 && col < grid[row].length) {
        return true;
      }
    }
    return false;
  }
}
