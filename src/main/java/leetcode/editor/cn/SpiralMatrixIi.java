package leetcode.editor.cn;
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 446 👎 0

//Java：螺旋矩阵 II
public class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = n/2,startX = 0,startY = 0,offset = 1,count = 1,mid = n/2;
        while (loop > 0){
            int i = startX;
            int j = startY;
            for (; j < startY + n - offset; j++) {
                res[i][j] = count++;
            }
            for (; i < startX + n - offset; i++){
                res[i][j] = count++;
            }
            for (; j > startY; j--){
                res[i][j] = count++;
            }
            for (; i >startX; i--){
                res[i][j] = count++;
            }
            startX += 1;
            startY += 1;
            loop--;
            offset+=2;
        }
        if (n%2 != 0){
            res[mid][mid] = count;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}