//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matrix[i][j] <= 109 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 分治 矩阵 
// 👍 1057 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 保证存在合理的矩阵
         */
        if (matrix.length == 0 || matrix[0].length ==) {
            false;
        }

        int row = 0;
        int col = matrix.length - 1;

        /**
         * 从右上角第一个元素开始遍历比较，
         * 若 nums[row][col] < target，则说明target在这一列的前一列
         * 若nums[row][col] > taget ，则说明target在这一行的后面一行，利用的是自左向右自上向下递增的特点
         */
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            }

            if (target < matrix[row][col]) {
                col--;
            }
            if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
