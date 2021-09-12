package leetcode.editor.cn;
//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1200 👎 0

//Java：从前序与中序遍历序列构造二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree1(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode buildTree1(int[] preorder,int preLeft,int preRight,
                                int[] inorder,int inLeft,int inRight) {
        if (preRight - preLeft < 1) {
            return null;
        }
        if (preRight - preLeft == 1) {
            return new TreeNode(preorder[preLeft]);
        }

        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = 0;
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree1(preorder,preLeft + 1,preLeft + 1 + (rootIndex - inLeft),
                                    inorder,inLeft,rootIndex);
        root.right = buildTree1(preorder,preLeft + 1 + (rootIndex - inLeft),preRight,
                                    inorder,rootIndex + 1,inRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}