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

        if (prices == null || prices.length == 0) {
            return 0;
        }

        //任何情况下最大利润至少为0
        int max = 0;
        int min = prices[0];

        /**
         * 第i天的最大收益跟第i-1天的最大收益 之间的关系：
         * (1)最大收益不是第i天抛出获得的        --最大收益跟第i天的价格无关
         * (2)最大收益是在第i-1天前的某天买入，并且在第i天抛出的       --最大收益跟第i天的价格有关
         *
         * 第i天的最大收益即为：max = {前i-1天的最大收益 , 第i天的价格 - 前i-1天中最小价格}
         * 前i-1天中最小价格价格需要实时更新并记录
         */
        for (int i = 1; i < prices.length; i++) {
            //price[i] - min 为这一天卖出股票可获得的最大利润
            max = Math.max(max, prices[i] - min);
            //min的初始化为数组第一个元素,遍历的时候取数组的每个元素作比较，找出来最小元素，当做股票买入的那天
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
