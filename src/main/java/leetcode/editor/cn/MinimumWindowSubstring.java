package leetcode.editor.cn;
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1245 👎 0

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Java：最小覆盖子串
public class MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Character,Integer> target = new HashMap<>();
    Map<Character,Integer> origin = new HashMap<>();
    public String minWindow(String s, String t) {
        //在滑动窗口类型的问题中都会有两个指针，一个用于「延伸」现有窗口的 r 指针，
        // 和一个用于「收缩」窗口的 l 指针。在任意时刻，只有一个指针运动，而另一个保持静止。
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i),target.getOrDefault(t.charAt(i),0)+1);
        }
        int left = 0,right = 0;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        for (;right < s.length() ; right++){
            if (target.containsKey(s.charAt(right))){
                origin.put(s.charAt(right),origin.getOrDefault(s.charAt(right),0)+1);
            }
            while (check() && left <=right){
                if (right - left + 1 < len){
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (target.containsKey(s.charAt(left))){
                    origin.put(s.charAt(left),origin.getOrDefault(s.charAt(left),0)-1);
                }
                left++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (origin.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}