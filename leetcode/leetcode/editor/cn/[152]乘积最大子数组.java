//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
// Related Topics 数组 动态规划 
// 👍 1752 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE; //保存最终结果最大值
        int imax = 1; //保存最大值
        int imin = 1; //保存最小值

        for (int i = 0; i < nums.length; i++) {
            //当nums[i]为负数的时候，正数所记录的最大值*负数则变为最小值，最小值*负数则变为最大值
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            //当nums[i]为负数时，交换最大最小值为下面计算做准备
            /**
             * 当前的乘积最大值，要么为前面元素统计出来的最大值，要么就是元素本身
             */
            imax = Math.max(imax * nums[i], nums[i]);
            /**
             * 因为元素中会有负数的存在，所以还要不断维护最小值，保证当nums[i]为负数时交换最小值乘元素本身为最大值
             */
            imin = Math.min(imin * nums[i], nums[i]);
            //获取最终最大值max
            max = Math.max(max, imax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
