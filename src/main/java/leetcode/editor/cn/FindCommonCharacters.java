package leetcode.editor.cn;
//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 235 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：查找常用字符
public class FindCommonCharacters{
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0){
            return res;
        }
        int[] hash = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            hash[words[0].charAt(i)-'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] hashOther = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                hashOther[words[i].charAt(j)-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                hash[j] = Math.min(hash[j],hashOther[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (hash[i]!=0){
                res.add(String.valueOf((char)(i+'a')));
                hash[i]--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}