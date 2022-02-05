package algorithms.graphtraversal.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function, minimumIsland, that takes in a grid containing Ws and Ls.
 * W represents water and L represents land. The function should return the size of
 * the smallest island. An island is a vertically or horizontally connected region of land.
 * You may assume that the grid contains at least one island.
 */
public class MinimumIsland {

  public static void main(String[] args) {
    MinimumIsland min = new MinimumIsland();

    char[][] grid = {
        {'W', 'L', 'W', 'W', 'W'},
        {'W', 'L', 'W', 'W', 'W'},
        {'W', 'W', 'W', 'L', 'W'},
        {'W', 'W', 'L', 'L', 'W'},
        {'L', 'W', 'W', 'L', 'L'},
        {'L', 'L', 'W', 'W', 'W'}
    };
    int island = min.minimumIsland(grid);
    System.out.println(island);
  }

  /**
   * Time: O(mn) where m = no of rows in grid and n = no. of cols in grid
   * @param grid
   * @return
   */
  public int minimumIsland(char[][] grid) {
    Set<String> visited = new HashSet<>();
    int count = Integer.MAX_VALUE;

    //loop through every position
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        //explore each position
        int islandCount = exploreAndCount(grid, row, col, visited);
        //set minimum count
        if (islandCount > 0) {
          count = Math.min(count, islandCount);
        }
      }
    }
    return count;
  }

  private int exploreAndCount(char[][] grid, int row, int col, Set<String> visited) {
    if (!isValidRow(grid, row, col) || !isValidCol(grid, row, col)) {
      return 0;
    }
    if (grid[row][col] == 'W') {
      return 0;
    }

    String pos = row + "," + col;
    if (visited.contains(pos)) {
      return 0;
    }
    int count = 1;
    visited.add(pos);

    count += exploreAndCount(grid, row + 1, col, visited);
    count += exploreAndCount(grid, row - 1, col, visited);
    count += exploreAndCount(grid, row, col - 1, visited);
    count += exploreAndCount(grid, row, col + 1, visited);
    return count;
  }

  private boolean isValidRow(char[][] grid, int row, int col) {
    return row >= 0 && row < grid.length;
  }

  private boolean isValidCol(char[][] grid, int row, int col) {
    return col >= 0 && col < grid[row].length;
  }
}
