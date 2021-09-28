package leetcode.editor.cn;//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1332 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums,0);
        return result;
    }

    private void backTracking(int[] nums,int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums,i + 1);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}