//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,104] 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 198 👎 0

//Java：找树左下角的值
public class FindBottomLeftTreeValue{
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
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
    private int maxLen = Integer.MIN_VALUE;
    private int maxLeftValue;

    private void traversal(TreeNode root,int leftLen) {
        if (root.left == null && root.right == null) {
            if (maxLen < leftLen) {
                maxLen = leftLen;
                maxLeftValue = root.val;
            }
            return;
        }
        if (root.left != null) {
            leftLen++;
            traversal(root.left,leftLen);
            leftLen--;
        }
        if (root.right != null) {
            leftLen++;
            traversal(root.right,leftLen);
            leftLen--;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        traversal(root,0);
        return maxLeftValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}