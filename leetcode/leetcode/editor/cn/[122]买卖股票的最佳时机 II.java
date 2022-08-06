//给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。 
//
// 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。 
//
// 返回 你能获得的 最大 利润 。 
//
// 
//
// 示例 1： 
//
// 
//输入：prices = [7,1,5,3,6,4]
//输出：7
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
//     总利润为 4 + 3 = 7 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//     总利润为 4 。 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 104 
// 0 <= prices[i] <= 104 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1786 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];

        //初始化第一天手上的利益
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        /**
         * 买卖最佳时机2 ： 每一天都可以买入或者卖出股票，但是任何时候只能拥有一支股票
         * 所以每天结束时存在两种状态：手里有支股票  和 手里无股票
         * 转移状态：
         * dp[i][0]  : i这一天不持有股票：1、昨日不持股且不操作    2、昨日持股但今天卖出(+prices[i])
         * dp[i][1]  : i这一天持有股票：1、昨日持有股票且不操作    2、昨日不持有股票但今天买入(-prices[i])
         */
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        /**
         * 全部交易结束后，dp[i][1]持股的收益一定是小宇dp[i][0]不持股的收益，所以结果统计不持股收益即可
         */
        return dp[prices.length - 1][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
