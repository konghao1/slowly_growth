//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 1389 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
        /**
         * index标识dfs的深度，即每步入到下一个元素位置时，index都+1，对应匹配获取word中的字符
         * 因为不符合情况的过滤均在前面返回false，在全部符合的情况下没有return,所以当指针越界则代表正常结束
         */
        if (index == word.length()) {
            return true;
        }

        /**
         * i j < 0 时，代表二维图形的左边与上边产生了越界
         * i == nums.length j == nums[0].length 时，意味着右边与下边产生了越界，可以剪枝
         */
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return false;
        }
        /**
         * 已经遍历过，则剪枝
         */
        if (visited[i][j]) {
            return false;
        }
        /**
         * 位置元素与当前字符不相等，第三次遍历到此处位置应该对应word中第三个字符
         */
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        boolean flag = dfs(board, i - 1, j, index + 1, word, visited) ||    //上边相邻元素
                dfs(board, i + 1, j, index + 1, word, visited) ||           //下边相邻元素
                dfs(board, i, j - 1, index + 1, word, visited) ||           //左边相邻元素
                dfs(board, i, j + 1, index + 1, word, visited);             //右边相邻元素

        if (flag) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
