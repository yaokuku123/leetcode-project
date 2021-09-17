package leetcode.editor.cn;
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 348 👎 0

import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Java：二叉搜索树中的众数
public class FindModeInBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private List<Integer> list = new ArrayList<>();
    private TreeNode pre = null;
    private int maxCount;
    private int count;

    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre == null) count = 1;
        else if (root.val == pre.val) count++;
        else if (root.val > pre.val) count = 1;
        pre = root;
        if (count == maxCount) {
            list.add(root.val);
        } else if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        }
        traversal(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}