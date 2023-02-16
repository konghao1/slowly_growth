//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 2291 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i]表示总金额为i时所需要最少硬币的个数为dp[],数组下标从0开始，则总金额为0时个数为0
        int[] dp = new int[amount + 1];//加上dp[0]，长度为amount + 1

        //给dp的每个下标处设置初始值，值代表硬币个数，求最小，所以设置amount + 1
        //即总金额为11元，存在面值为1元的硬币时最多硬币11枚，相当于初始化正无穷，便于后面取最小值
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;

        //dp[]数组长度为amount + 1,循环求解填充dp数组，其中dp[0]已经初始化为0,所以从下标1开始填充
        for (int i = 1; i <= amount; i++) {
            //循环遍历面值的数组
            for (int j = 0; j < coins.length; j++) {
                //当面值 <= 总金额时才能得出硬币数，否则无硬币数可计算
                if (coins[j] <= i) {
                    //初始值dp[i] 与 总金额i - 各个面值 的最小硬币数 + 1(即，每个面值的硬币数)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        //求解的是组成总金额amount的硬币个数，也就是dp[amount]，如果dp[amount] > amount总金额，则代表初始化的值一直未改变，
        //即没有这样面值的硬币能够凑出来总金额
        if (dp[amount] > amount) {
            return -1;
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
