package leetcode.editor.cn;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1518 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] letterMap = {
                    "", // 0
                    "", // 1
                    "abc", // 2
                    "def", // 3
                    "ghi", // 4
                    "jkl", // 5
                    "mno", // 6
                    "pqrs", // 7
                    "tuv", // 8
                    "wxyz", // 9
        };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        backTracking(digits,0);
        return result;
    }

    private void backTracking(String digits,int index) {
        if (digits.length() == index) {
            result.add(sb.toString());
            return;
        }
        String letter = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            backTracking(digits,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}