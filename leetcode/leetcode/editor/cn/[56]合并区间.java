//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1563 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        //interval数组如只有一个元素则就为本身
        if (intervals.length < 2) {
            return intervals;
        }
        //将interval每个数组按第一个元素由小到大排序
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        List<int[]> res = new ArrayList<>();
        //将第一个元素数组加入结果集
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            //选择当前遍历的第一个元素数组
            int[] curInterval = intervals[i];
            //找出来需要对比的前一个元素数组
            int[] peek = res.get(res.size() - 1);
            //比较peek数组的第二位与curInterval数组第一位数值的大小
            //如果peek[1] > cuInterval[0],即左数组的右端点大于右数组的左端点则说明有重叠
            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
            } else {
                peek[1] = Math.max(peek[1], curInterval[1]);
            }
        }
        /**
         * 需要关注res.toArray(new int[res.size()][]);的过程
         */
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
