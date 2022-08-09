//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 1352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 最长连续序列，选择nums中的每一个数字x，且以x为起点，在数组中查询x+1,x+2...x+y是否存在
     * 如果查到了存在x+y，那么连续序列的个数即为y - x + 1
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        /**
         * 将数组元素存入set进行去重后保存
         */
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        //记录连续序列的个数
        int result = 0;

        /**
         * 对去重后的set进行遍历，对每个元素是否为连续序列起点元素进行判断(若存在element - 1则说明element不是起点元素)
         * 不存在element - 1 则说明该元素可能为起点元素，将其值用start指针记录，对start + 1进行判断是否在set中可以查到，
         * 如果可以查到则说明从start到start + 1是具有连续性的，最后一直取遍历到每个元素的result最大值
         */
        for (int element : hashSet) {
            //true表示该元素可能为连续序列的起点元素
            if (!hashSet.contains(element - 1)) {
                int start = element;
                //从起点元素开始一直寻找连续性
                while (hashSet.contains(start + 1)) {
                    start++;
                }
                //记录连续序列的最大个数
                result = Math.max(result, start - element + 1);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
