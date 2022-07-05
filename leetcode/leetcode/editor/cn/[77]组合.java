//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 
// 👍 1031 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, k, 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int n, int k, int startIndex) {
        if (tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            tempList.add(i);
            backtrack(list, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
