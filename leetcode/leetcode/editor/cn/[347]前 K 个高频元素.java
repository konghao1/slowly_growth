//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 
// 👍 1454 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        //map结构，key = nums[i] value = 该元素出现的次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        //优先队列，维护一个小根堆,按照出现的次数即map.getValue()从小到大进行排序
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> (o1.getValue() - o2.getValue()));
        //遍历entrySet讲entry = {key : value}放入优先队列，进行小根堆维护
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            //进入小根堆
            queue.offer(entry);
            //前K个元素即保持队列中一直存在k的size
            if (queue.size() > k) {
                //因为进入queue就会进行排序，所以弹出来的队列头部一直都是堆中的排序最小值
                queue.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            //queue中保存的是entry键值对，需要的元素是key，所以弹出队列中保持的key
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
