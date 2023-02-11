//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 105 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 前缀和 
// 👍 1355 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int[] left = new int[N];//某索引的左乘积
        int[] right = new int[N];//某索引的右乘积

        int[] res = new int[N];

        left[0] = 1;//最左侧索引的左乘积默认为1
        //数组中每个索引处的左乘积，形成left[]数组
        for (int i = 1; i < N; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[N - 1] = 1;//最右侧索引的左乘积默认为1
        //从倒数第二个索引处开始，数组中每个索引处的右乘积，形成right[]数组
        for (int i = N - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        //每个索引出的左乘积 * 右乘积
        for (int i = 0; i < N; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
