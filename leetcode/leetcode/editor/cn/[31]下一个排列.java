//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1215 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*例子：
     * nums = [1,2,7,4,3,1]
     * 从后往前寻找
     * 第一个最大索引是 nums[1] = 2 ,nums[1]  = 2, nums[2] = 7,nums[1] < nums[1]
     * 再找到第二个最大索引是 nums[4] = 3.
     * 交换，nums = [1,3,7,4,2,1];
     * 翻转，nums = [1,3,1,2,4,7]
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * */

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //从后往前，先找出最大的索引k，满足nums[k] < nums[k+1]
        int firstMaxIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstMaxIndex = i;
                break;
            }
        }
        //如果不存在就翻转整个数组
        if (firstMaxIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        //再找出来一个最大索引l,满足nums[l] > nums[k]
        int secondMaxIndex = -1;
        for (int i = nums.length - 1; i > firstMaxIndex; i--) {
            if (nums[i] > nums[firstMaxIndex]) {
                secondMaxIndex = i;
                break;
            }
        }//交换nums[k]与nums[l]
        swap(nums, firstMaxIndex, secondMaxIndex);
        //翻转nums[k+1 : ]，k+1位置后面的数据
        reverse(nums, firstMaxIndex + 1, nums.length - 1);
        return;
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int nums[], int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
