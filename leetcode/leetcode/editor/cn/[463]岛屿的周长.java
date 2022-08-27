//给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。 
//
// 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//输出：16
//解释：它的周长是上面图片中的 16 个黄色的边 
//
// 示例 2： 
//
// 
//输入：grid = [[1]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// row == grid.length 
// col == grid[i].length 
// 1 <= row, col <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
// 👍 584 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int islandPerimeter(int[][] grid) {
        /**
         * 核心思想：岛屿的周长计算就是每一个格子上下左右中，取越界与海洋的边
         * 即在 i < 0 || j < 0 || i > grid.length || j > grid[0].length时周长+1，
         * 在 上下左右 相邻为海洋时周长+1
         */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //从岛屿开始遍历计算
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }


    private int dfs(int[][] grid, int i, int j) {
        //某个方向越界则周长 +1
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 1;
        }
        //某个方向是海洋则周长 +1
        if (grid[i][j] == 0) {
            return 1;
        }
        //当相邻位置不是岛屿时不变
        if (grid[i][j] != 1) {
            return 0;
        }
        //遍历过的位置置为2表明不是陆地不是海洋，避免重复计算
        grid[i][j] = 2;
        //上
        int top = dfs(grid, i - 1, j);
        //下
        int bottom = dfs(grid, i + 1, j);
        //左
        int left = dfs(grid, i, j - 1);
        //右
        int right = dfs(grid, i, j + 1);
        //计算四个方向的值得到某个岛屿可计算周长的边长
        return top + bottom + left + right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
