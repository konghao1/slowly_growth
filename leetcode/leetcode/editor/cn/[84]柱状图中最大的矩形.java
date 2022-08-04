//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 2089 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        /**
         * 双指针，暴力遍历，超时
         *//*
        if (heights.length == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            //向左探测移动的指针
            int left = i;
            //记录当前位置的高度
            int curHeight = heights[i];
            //一直向左探测是否有高度>=当前位置的矩形，如果有就加入矩形面积
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }

            int right = i;
            //一直向右探测是否有高度>=当前位置的矩形，如果有就加入矩形面积
            while (right < heights.length - 1 && heights[right + 1] >= curHeight) {
                right++;
            }
            //向左和向右移动到最远的矩形底长
            int width = right - left + 1;
            //底长乘以当前矩形的高度则为结果
            result = Math.max(result, width * curHeight);
        }
        return result;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
