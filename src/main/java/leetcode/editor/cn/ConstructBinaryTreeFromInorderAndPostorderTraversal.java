package leetcode.editor.cn;
//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 568 👎 0

//Java：从中序与后序遍历序列构造二叉树
public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private TreeNode buildTree1(int[] inorder,int inLeft,int inRight,
                                int[] postorder,int postLeft,int postRight) {
        if (inRight - inLeft < 1) {
            return null;
        }
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        int rootIndex = 0;
        int rootValue = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootValue);
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree1(inorder,inLeft,rootIndex,postorder,postLeft,postLeft + (rootIndex - inLeft));
        root.right = buildTree1(inorder,rootIndex + 1,inRight,postorder,postLeft + (rootIndex - inLeft),postRight - 1);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}