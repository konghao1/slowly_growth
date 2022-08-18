//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 
// 👍 2520 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        /**
         * 利用set进行去重,存在元素则remove，不存在则add
         *//*
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                hashSet.remove(num);
            } else {
                hashSet.add(num);
            }
        }

        int result = 0;
        //最后set中只剩一个单独的元素无法remove掉
        for (int num : nums) {
            if (hashSet.contains(num)) {
                result = num;
            }
        }
        return result;*/

        /**
         * 异或运算： 0 ^ 0 = 0  1 ^ 0 = 1   1 ^ 0 = 1   1 ^ 1 = 0
         */
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
