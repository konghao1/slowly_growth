//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1439 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*
     * 回溯问题——一颗侧决策树的遍历过程
     *   1、路径：已经做出的选择
     *   2、选择列表：当前可以做的选择
     *   3、结束条件：到达决策树底层，无法再做选择的条件。
     *
     *   result = []
     *   private void backtrack(路径，选择列表){
     *       if 满足条件时：
     *           result.add(路径);
     *              return;
     *       for选择 in  选择列表{
     *           做选择
     *           backtrack(路径，选择列表);
     *           撤销选择；
     *       }
     *   }
     * */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //对选择列表进行排序，方便剪枝操作
        Arrays.sort(candidates);
        process(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void process(int[] candidates, int target, List<List<Integer>> res, List<Integer> tempList, int start) {
        if (target < 0) {
            return;
        }
        //因为是通过路径值的总和==target来计算，故递归相减后，target == 0 是所需答案
        if (target == 0) {
            //new ArrayList来使用副本添加，否则参数传递引用地址，里面的元素都是相同的值
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //设置start，每次递归的时候保证在candidates中的当前以及之后的数字中选择，避免重复
            //因为之前将candidates进行了排序，保证了由小到大的排列顺序，所以在深度遍历树的路径时，路径先走小数字的分支，
            //后走大数字的分支，这样可以吧避免重复,如{2,3,6,7},会出现[[2,2,3],[2,3,2],[3,2,2],[7]],其中[[2,2,3],[2,3,2],[3,2,2]]
            //每个数组的位置顺序就是由小到大排列，当target < candidates[i]，时候判断target与当前数字的大小，如果小于当前数字，说明可能会出现重复值
            if (target < candidates[i]) {
                break;
            }
            //做选择，tempList则是记录的路径数字
            tempList.add(candidates[i]);
            //不断地减小target的数值进行递归
            process(candidates, target - candidates[i], res, tempList, i);
            //走完分支后的回溯，可以理解为回到上一层的父节点
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
