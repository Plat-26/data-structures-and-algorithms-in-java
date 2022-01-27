package algorithms.dynamicprogramming.tabulation;

public class GridTravelerTabulation {

    public static void main(String[] args) {
        GridTravelerTabulation gridTab = new GridTravelerTabulation();
        System.out.println(gridTab.gridTraveler(3, 3));
    }

    /**
     * Time: O(mn)
     * Space: O(mn)
     * @param row, m
     * @param col, n
     * @return
     */
    public int gridTraveler(int row, int col) {
        int[][] grid = new int[row + 1][col + 1];
        grid[1][1] = 1;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i + 1 < grid.length) {
                    grid[i + 1][j] += grid[i][j];
                }
                if (j + 1 < grid[i].length) {
                    grid[i][j + 1] += grid[i][j];
                }
            }
        }
        return grid[row][col];
    }
}
