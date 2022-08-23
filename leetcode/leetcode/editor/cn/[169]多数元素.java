//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 1535 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        /**
         * key为当前数组元素，value为此元素出现的次数,O(n)空间复杂度
         */
        /*Map<Integer, Integer> integerMap = new HashMap<>();
        for (int num : nums) {
            integerMap.put(num, integerMap.getOrDefault(num, 0) + 1);
            if (integerMap.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;*/

        /**
         * 摩尔投票法
         * 利用的就是多数元素的个数 > [n / 2]，其余元素的个数肯定个数小于 [n / 2]
         */
        //取第一个元素为candidate
        int temp = nums[0];
        //计数
        int count = 1;
        //从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            //与temp相同的数则计数+1
            if (nums[i] == temp) {
                count++;
            } else if (count == 0) { //当count--到0的时候意味着candidate更改
                temp = nums[i];
            } else { //否则就计数-1
                count--;
            }
        }
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
