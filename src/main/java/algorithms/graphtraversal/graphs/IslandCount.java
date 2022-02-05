package algorithms.graphtraversal.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function, islandCount, that takes in a grid containing Ws and Ls.
 * W represents water and L represents land. The function should return the number of islands
 * on the grid. An island is a vertically or horizontally connected region of land.
 */
public class IslandCount {

  public static void main(String[] args) {
    IslandCount count = new IslandCount();

    char[][] grid = {
            {'W', 'L', 'W', 'W', 'W'},
            {'W', 'L', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'L', 'W'},
            {'W', 'W', 'L', 'L', 'W'},
            {'L', 'W', 'W', 'L', 'L'},
            {'L', 'L', 'W', 'W', 'W'}
    };

    System.out.println(count.islandCount(grid));
  }

  /**
   * Time: O(mn) - where m = no. of rows and n = no. of columns
   * @param grid
   * @return
   */
  public int islandCount(char[][] grid) {
    int count = 0;
    //a set to avoid circular movements through the grid
    Set<String> visited = new HashSet<>();
    //iterative code to move through the whole grid
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (explore(grid, row, col, visited)) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean explore(char[][] grid, int row, int col, Set<String> visited) {
    if (!isValidRow(grid, row, col) || !isValidCol(grid, row, col)) {
      return false;
    }

    if (grid[row][col] == 'W') {
      return false;
    }

    String position = row + "," + col;
    if (visited.contains(position)) {
      return false;
    }
    visited.add(position);

    explore(grid, row, col - 1, visited);
    explore(grid, row, col + 1, visited);
    explore(grid, row - 1, col, visited);
    explore(grid, row + 1, col, visited);

    return true;
  }

  private boolean isValidRow(char[][] grid, int row, int col) {
    return 0 <= row && row < grid.length;
  }

  private boolean isValidCol(char[][] grid, int row, int col) {
    return 0 <= col && col < grid[row].length;
  }
}
