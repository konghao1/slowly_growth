//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 1361 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0; //代表正方形的最大边长
        //不存在正方形的情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return max;
        }

        int rows = matrix.length;//正方形的行数
        int cols = matrix[0].length;//正方形的列数
        //定义dp数组，含义为当前以(i , j)为右下角的，且只包含1的正方形的边长最大值
        int[][] dp = new int[rows][cols]; //最大边长同样是一个相同形状的矩阵

        //开始遍历整个二维矩阵
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //开始统计包含1的正方形的边长最大值
                if (matrix[i][j] == '1') {
                    //当此位置为最上面或最左面时，最大边长只能为1（因为认定此位置为正方向的右下角）
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        //动态规划，统计每一个包含1的正方形的最大边长，为左边、上边、左上边三个位置中最小边长 + 1
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                    //每个包含1的正方形在获取到dp[i][j]边长最大值之后与保存的max进行比较，目的是找出遍历后的边长最大值
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        //找出max最大值之后计算出面积
        return max * max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
