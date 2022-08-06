//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 2479 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 暴力法，超时
         */
        /*if (prices.length == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    continue;
                }
                result = Math.max(result, prices[j] - prices[i]);
            }
        }
        return result;
    }*/

        /**
         * 贪心算法
         */
        /*if (prices == null || prices.length == 0) {
            return 0;
        }

        //任何情况下最大利润至少为0
        int max = 0;
        int min = prices[0];

        *
         * 第i天的最大收益跟第i-1天的最大收益 之间的关系：
         * (1)最大收益不是第i天抛出获得的        --最大收益跟第i天的价格无关
         * (2)最大收益是在第i-1天前的某天买入，并且在第i天抛出的       --最大收益跟第i天的价格有关
         *
         * 第i天的最大收益即为：max = {前i-1天的最大收益 , 第i天的价格 - 前i-1天中最小价格}
         * 前i-1天中最小价格价格需要实时更新并记录

        for (int i = 1; i < prices.length; i++) {
            //price[i] - min 为这一天卖出股票可获得的最大利润
            max = Math.max(max, prices[i] - min);
            //min的初始化为数组第一个元素,遍历的时候取数组的每个元素作比较，找出来最小元素，当做股票买入的那天
            min = Math.min(min, prices[i]);
        }
        return max;*/

        /**
         * 动态规划算法
         */
        if (prices == null || prices.length == 0) {
            return 0;
        }

        //dp[i][j]标识i天结束时候，持股状态为j时，手上最大现金数，其中j == 1时表示持股
        //买入股票则现金数减少，卖出股票时则现金数增多，现金数等同于题目中的利润，即买入股票后卖出获得的差价
        //dp[i][0] : i这一天不持有股票：1、昨天不持股，今天无操作    2、昨天持股，今天卖出(现金数增加)
        //dp[i][1] : i这一天持有股票：1、昨天持有股票，今天无操作    2、昨天不持股，今天买入股票(只允许买入一次)
        int[][] dp = new int[prices.length][2];

        //初始化：第一天    不持股为0，持股需要减去第一天(i == 0)的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //第二天开始遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); //max(前一天不持股不操作，前一天持股今天卖出)
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]); //max(前一天持股今天不操作，前一天不持股今天买入)
        }
        /**
         * 全部交易结束后，dp[i][1]持股的收益一定是小宇dp[i][0]不持股的收益，所以结果统计不持股收益即可
         */
        return dp[prices.length - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
