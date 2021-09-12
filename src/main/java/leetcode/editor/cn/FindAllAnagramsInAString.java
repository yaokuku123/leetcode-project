package leetcode.editor.cn;
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 599 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：找到字符串中所有字母异位词
public class FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len = p.length();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        String sortedPStr = new String(pArray);
        for (int i = len-1; i < s.length(); i++) {
            String subStr = s.substring(i-len+1,i+1);
            char[] sArray = subStr.toCharArray();
            Arrays.sort(sArray);
            String sortedSStr = new String(sArray);
            if (sortedPStr.equals(sortedSStr)){
                res.add(i-len+1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}