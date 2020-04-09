package dev.pushparaj.problems;
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

public class IslandCount {
    
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        if(rows == 0)
            return 0;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(!visited[row][col] && grid[row][col] == '1'){
                    dfs(grid, visited, row, col);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    
    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        
        //check top
        if(row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] != '0')
            dfs(grid, visited, row - 1, col);
        
        //check right
        if(col + 1 < grid[0].length  && !visited[row][col + 1] && grid[row][col + 1] != '0')
            dfs(grid, visited, row, col + 1);
        
        //check bottom
        if(row + 1 < grid.length && !visited[row + 1][col] && grid[row + 1][col] != '0')
            dfs(grid, visited, row + 1, col);
        
        //check left
        if(col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] != '0')
            dfs(grid, visited, row, col - 1);
    }
}