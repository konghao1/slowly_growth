//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1910 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
//        //获取数组范围大小
//        int n = nums.length;
//        //获取一直在更新的可以跳跃的最远位置
//        int maxIndex = 0;
//        //遍历nums数组
//        for(int i = 0; i < n; i++){
//            //更新最远位置
//            if(i <= maxIndex){
//                maxIndex = Math.max(maxIndex , i+nums[i]);
//                if(maxIndex >= n - 1){
//                    return true;
//                }
//            }
//        }
//        return false;
        //记录能跳跃的最远距离位置
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //若i > maxIndex,则说明i这个位置跳不到
            if (i > maxIndex) {
                return false;
            }
            //一直更新能跳跃的最远距离位置
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
