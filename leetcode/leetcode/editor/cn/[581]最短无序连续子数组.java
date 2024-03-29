//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 1018 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0];//从左向右记录最大值
        int min = nums[nums.length - 1];//从右向左记录最小值
        int left = 0, right = 0;

        //定义max初始值为第一个元素值，从左往右遍历，不断更新max最大值，若max不更新则说明新的值<最大值，为破坏顺序的值
        //使用left指针记录
        for (int i = 0; i < nums.length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
            } else {
                left = i;
            }
        }

        //定义min初始值为最后一个元素值，从右往左遍历，不断更新min最小值，若min不更新则说明新的值>最小值，为破坏顺序的值
        //使用right指针记录
        for (int j = nums.length - 1; j >= 0; j--) {
            if (min >= nums[j]) {
                min = nums[j];
            } else {
                right = j;
            }
        }

        //如果数组本来就是有序的，则左右指针没有变化
        if (left == 0 || right == nums.length - 1) {
            return 0;
        }
        //最后记录长度，断点为left和right
        return left - right + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
