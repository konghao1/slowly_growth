//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1103 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int secondPosition = findSecondPosition(nums, target);
        return new int[]{firstPosition, secondPosition};
    }

    //寻找第一个位置时，两次出现的位置相对来说肯定是靠左侧，所以相等的时候right左移缩进区间
    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        //当target极大的时候，仍然有nums[mid] < target,则left = mid + 1,
        //若mid指向数组最后一个元素时，left就会越界,避免越界需要做left != nums.length
        //当target极小的时候，仍有nums[mid] > target，则right = mid - 1,
        //此时若mid指向数组第一个元素的时候，right就会越界，但是此时left不会越界，所以只需要判断==target就够了
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    //寻找第二个位置时候，两次出现的位置相对来说肯定是靠右侧，所以相等的时候left右移缩进区间
    private int findSecondPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
