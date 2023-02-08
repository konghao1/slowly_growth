//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1896 👎 0

/**
 * 排序后第K个最大元素
 * 第一个最大元素索引是len - 1
 * 第二个最大元素索引是len - 2
 * 第k个最大元素索引是len - k
 *
 *
 * 每次经过「划分」操作后，我们一定可以确定一个元素的最终位置，即 x 的最终位置为 q，
 * 并且保证 a[l ⋯q - 1] 中的每个元素小于等于 a[q]，且 a[q] 小于等于 a[q + 1 ⋯ r]中的每个元素。
 * 所以只要某次划分的 q 为倒数第 k 个下标的时候，我们就已经找到了答案。 我们只关心这一点，
 * 至于 a[l ⋯ q - 1] 和 a[q+1 ⋯ r] 是否是有序的，我们不关心。
 *
 * 引入随机povit避免最坏时间复杂度O(n2)情况
 *
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;//第K个大的数的索引在排序后为N - k
        int target = len - k;

        int start = 0;
        int end = len - 1;

        while (true) {
            int pivotIndex = partition(nums, start, end);//找到对应元素索引的位置
            if (target == pivotIndex) {
                return nums[pivotIndex];
            } else if (target > pivotIndex) {
                start = pivotIndex + 1;
            } else {
                end = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start;
        int right = end;

        while (left != right) {//left与right不重合时
            while (left < right && nums[right] >= pivot) {//left < right控制两指针重合
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }

            if (left < right) { //两指针不重合时交换left与right元素，待后续pivot与指针重合处交换形成pivot分隔左右两边
                swap(nums, left, right);
            }
        }
        swap(nums, left, start);//pivot与leftright指针重合处交换，使得pivot左边小于它，右边大于它

        return left;//返回pivot的索引位置
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
