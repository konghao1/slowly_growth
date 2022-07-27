//环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号
//为 (i + 1) % n 的车站之间的距离。 
//
// 环线上的公交车都可以按顺时针和逆时针的方向行驶。 
//
// 返回乘客从出发点 start 到目的地 destination 之间的最短距离。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：distance = [1,2,3,4], start = 0, destination = 1
//输出：1
//解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：distance = [1,2,3,4], start = 0, destination = 2
//输出：3
//解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：distance = [1,2,3,4], start = 0, destination = 3
//输出：4
//解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^4 
// distance.length == n 
// 0 <= start, destination < n 
// 0 <= distance[i] <= 10^4 
// 
// Related Topics 数组 
// 👍 89 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *
     *              [9]             [5]
     *      0——————————————1————————————————2
     *
     *        [4]                        [7]
     *              4——————————————3
     *                     [2]
     *
     * distance[] = {9,5,7,2,4}
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        /**
         * 车站为环形，其中distance[]为车站之间的距离
         * start  destination可能是从小序号-->大序号，也可能是大序号-->小序号
         * 无论怎么走，都是将环形截成了两半，且距离跟start destination的大小无关
         */
        //定义环形两半的距离之和
        int sum1 = 0;
        int sum2 = 0;

        //无论start destination的大小，均确定最小与最大值
        int paramStart = Math.min(start, destination);
        int paramDestination = Math.max(start, destination);

        //遍历距离数组进行两半距离求和
        for (int i = 0; i < distance.length; i++) {
            //先求paramStart-->paramDestination一边的
            if (i >= paramStart && i < paramDestination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
