//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 
// 👍 613 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        /**
         * 每个字符对应，且出现的次数相同，则先判断长度
         */
        if (s.length() != t.length()) {
            return false;
        }

        /**
         * map的key为具体字符，value为该字符出现的次数
         */
        Map<Character, Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (char sc : sChar) {
            //map.getOrDefault()计算该元素及其出现的次数
            map.put(sc, map.getOrDefault(sc, 0) + 1);
        }

        char[] tChar = t.toCharArray();
        for (char tc : tChar) {
            //遍历另一个字符数组，改变map中元素及其数量，先减元素数量，当数量为0时减去元素
            //遍历第二个字符数组结束后map减元素后size() == 0,贼说明是有效的字母异位词
            map.put(tc, map.getOrDefault(tc, 0) - 1);
            if (map.get(tc) == 0) {
                map.remove(tc);
            }
        }
        if (map.size() == 0) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
