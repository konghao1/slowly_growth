//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 
// 👍 2261 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        /* *//**
         * 测试38/68   [2,1,1,2]过不了
         *//*
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int resA = 0;
        int resB = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                resA += nums[i];
            } else {
                resB += nums[i];
            }
        }
        return Math.max(resA, resB);*/

        /**
         * 动态转移方程 dp[n] = Max(dp[n - 1], dp[n -2] + nums[n - 1])
         * n为nums的index == 2时，nums数据前面补一个初始元素，即
         * 【0】      2       7       9           3           1
         * dp[0]   dp[1]   dp[2]    dp[3]       dp[4]    dp[5]
         *
         * for循环遍历从index == 2开始，取nums[i - 1]目的是求出index下前一个元素对应的dp[index]数值
         * 当i = 2循环时，满足转移方程如下
         * dp[2] = Max(dp[2 - 1], dp[2 - 2] + nums[2 - 1])，即
         * dp[2] = Max(2, 0 + 7)，加上了前面添加的一个空位凑成满足方程
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        /**
         * dp数据比nums数组多一位，多的为nums前一位，保证状态方程
         */
        int[] dp = new int[nums.length + 1];

        //dp第一位元素为构造的，所以赋值0
        dp[0] = 0;
        //第一个元素即为dp第二个元素
        dp[1] = nums[0];

        //从index == 2开始遍历，挑选i - 1 与 (i -2) + nums(i - 1)的比较值，i - 1是要找index位置的数
        //dp最后一个元素时，index索引应该为nums.length的值，
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[nums.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
