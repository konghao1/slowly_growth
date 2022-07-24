//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 1299 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        /**
         * 时间复杂度O(m*n)
         * dp[i][j]记录走到当前位置的最小路径和
         */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //i == 0 && j == 0时，代表左上角起点位置
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {   //i == 0时，代表路线只能从左边往右走(只有一行)，所以当前位置要累加上左边相邻位置的值
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {    //j == 0时，代表路线只能从上往下走(只有一列)，所以当前位置要累加上上边相邻位置的值
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {    //(至少两行两列，此时对已你的i/j均从1开始算起，关联62题for循环)
                    //若不与左边上边相邻，则需要累加取左边跟上边相邻位置值的最小值
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        //取右下角最后一个位置的值
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
