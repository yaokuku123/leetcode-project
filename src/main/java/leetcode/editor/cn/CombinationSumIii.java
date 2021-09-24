package leetcode.editor.cn;//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯 
// 👍 356 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：组合总和 III
public class CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n,0,k,1);
        return result;
    }

    private void backTracking(int targetNum,int sum,int k,int startIndex) {
        if (targetNum < sum) {
            return;
        }
        if (path.size() == k) {
            if (targetNum == sum) result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1 ; i++) {
            sum += i;
            path.add(i);
            backTracking(targetNum,sum,k,i + 1);
            path.remove(path.size() -1);
            sum -= i;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}