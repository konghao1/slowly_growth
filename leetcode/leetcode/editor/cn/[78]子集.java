//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1724 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 回溯算法包含了几类问题：1、排列     2、组合    3、子集（也是组合问题）
     * 根本的区分在于——集合是有序还是无序的，组合的{1,2}与{2,1}是一样的，但是排列因为要求顺序性所以两者不同
     * 重要点：
     * 无序问题，取过的元素不会重新选取，for循环就需要从int i = startIndex开始，而不是int i = 0开始
     * 组合(子集)问题：for(int i = startIndex; i < nums.length; i++)
     * 排列问题：for(int i = 0; i < nums.length; i++),不需要使用startIndex(因为涉及到排序问题，不同的顺序结果不同，所以允许重新开始选择元素)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));

        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
