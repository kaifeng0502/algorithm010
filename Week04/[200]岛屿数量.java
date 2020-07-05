//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length ==0) return  0;
        int n = grid.length;
        int m = grid[0].length;
        int island = 0;
        for ( int i = 0; i <= n-1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    dfs(grid, i, j);
                }

            }

        }
        return island;
        

    }
    public void dfs(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row > grid.length - 1 || column > grid[0].length -1 || grid[row][column] =='0') return;
        grid[row][column] = '0';
        dfs(grid,row-1, column);
        dfs(grid,row+1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
