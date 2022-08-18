//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
// Related Topics 位运算 数组 
// 👍 637 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        /**
         * HashMap来统计出现的次数
         *//*
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[index] = entry.getKey();
                index++;
            }
        }
        return result;*/

        /**
         * 位运算
         */
        // 所有数异或的结果
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        // 取出不同的那个位，我们这里取最右边的那个1
        int bit = xor & (-xor);
        // 按这个位将所有数分成两半分别异或的结果就是我们要找的那两个数
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                x = x ^ num;
            } else {
                y = y ^ num;
            }
        }
        return new int[]{x, y};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
