//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 1299 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int count = matrix.length * matrix[0].length;//遍历元素的数量统计

        while (count >= 1) {
            //从左往右遍历，不变的是行，变得是列，count表示遍历的元素情况，要保证还有元素没统计
            for (int i = left; i <= right && count >= 1; i++) {
                list.add(matrix[top][i]);
                count--;//统计完元素之后计数
            }
            top++;//从左到右遍历后，转方向从上到下遍历，此时指向改变方向后的第一个未被统计的位置

            for (int i = top; i <= bottom && count >= 1; i++) {
                list.add(matrix[i][right]);
                count--;
            }
            right--;

            for (int i = right; i >= left && count >= 1; i--) {
                list.add(matrix[bottom][i]);
                count--;
            }
            bottom--;
            for (int i = bottom; i >= top && count >= 1; i--) {
                list.add(matrix[i][left]);
                count--;
            }
            left++;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
