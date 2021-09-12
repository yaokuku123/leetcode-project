package leetcode.editor.cn;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 857 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：螺旋矩阵
public class SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 可以模拟螺旋矩阵的路径。初始位置是矩阵的左上角，初始方向是向右，
     * 当路径超出界限或者进入之前访问过的位置时，顺时针旋转，进入下一个方向。
     * 判断路径是否进入之前访问过的位置需要使用一个与输入矩阵大小相同的辅助矩阵 ，其中的每个元素表示该位置是否被访问过
     * 路径的长度即为矩阵中的元素数量，当路径的长度达到矩阵中的元素数量时即为完整路径，将该路径返回
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int newRow = row + directions[directionIndex][0], newColumn = column + directions[directionIndex][1];
            if (newRow < 0 || newRow >= rows || newColumn < 0 || newColumn >= columns || visited[newRow][newColumn]){
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}