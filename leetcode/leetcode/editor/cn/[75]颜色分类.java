//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库的sort函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 
// 👍 1352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 对数组进行两次遍历
     * 第一次遍历挑选nums[i] == 0的值与nums[ptr]交换，ptr指针始终标识数组头部0的范围
     * 第二次遍历挑选nums[i] == 1的值与nums[ptr]交换，开始位置为ptr指针所在位置，对排好序的0值后面进行排序
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int ptr = 0;//标记0的范围，从nums位置0——>ptr - 1的范围都为0的范围
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

        /*int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            }
            if (nums[i] == 1) {
                count1++;
            }
            if (nums[i] == 2) {
                count2++;
            }
        }
        Arrays.fill(nums, 0, count0, 0);
        Arrays.fill(nums, count0, count0 + count1, 1);
        Arrays.fill(nums, count0 + count1, nums.length, 2);*/


    }
}
//leetcode submit region end(Prohibit modification and deletion)
