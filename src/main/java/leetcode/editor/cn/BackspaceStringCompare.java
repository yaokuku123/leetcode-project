package leetcode.editor.cn;
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 
//输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 
//输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 
//输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 字符串 模拟 
// 👍 292 👎 0

//Java：比较含退格的字符串
public class BackspaceStringCompare{
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        //一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。
        // 因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。
        int i = s.length() - 1,j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >=0 || j >= 0){
            while (i >= 0){
                if (s.charAt(i) == '#'){
                    skipS++;
                    i--;
                } else if (skipS > 0){
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0){
                if (t.charAt(j) == '#'){
                    skipT++;
                    j--;
                }else if (skipT > 0){
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >=0 && j>=0){
                if (s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }else {
                if (i >=0 || j>=0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}