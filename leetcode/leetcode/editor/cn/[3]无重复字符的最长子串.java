//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 8770 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*//利用map的size来记录最长子串的长度，子串不能被分割，是连续的
        Map<Character, Boolean> map = new HashMap<>();
        int max = 0;//记录长度的最大值
        int start = 0;//每次都从元素的开头开始遍历

        char[] arr = s.toCharArray();

        for (int i = start; i < arr.length; i++) {
            for (int j = start; j < arr.length; j++) {
                //如果包含了遇到了重复元素，则从下一个元素开始遍历，否则就加入map
                if (map.containsKey(arr[j])) {
                    start = start + 1;
                    break;
                } else {
                    map.put(arr[j], true);
                }
            }
            //遇到重复元素break时max来记录最大长度
            max = Math.max(max, map.size());
            //每次遍历前清除map，维持map大小的初始化
            map.clear();
        }
        return max;*/

        /**
         * 滑动窗口解法，O(n)时间复杂度，一次遍历两个指针start/end
         * 其中窗口的长度为 end - start + 1
         */
        int max = 0;
        // map = {key : 元素, value = 元素下标}
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char element = s.charAt(end);
            if (map.containsKey(element)) {
                start = Math.max(start, map.get(element) + 1);//start指针指向前一个重复元素的下一位，避免重复元素出现在滑动窗口
            }
            map.put(element, end);//元素 和 元素下标
            max = Math.max(max, end - start + 1);//max记录滑动窗口的最大长度，最大长度为end - start + 1固定值
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
