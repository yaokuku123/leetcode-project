package leetcode.editor.cn;//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 717 👎 0

//Java：x 的平方根
public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        //二分查找的下界为 0，上界可以粗略地设定为 x。在二分查找的每一步中，
        // 我们只需要比较中间元素 mid  的平方与 x 的大小关系，并通过比较的结果调整上下界的范围
        int left = 0, right = x, res = -1;
        while (left <= right){
            int mid = left + ((right - left) >> 2);
            if ((long) mid * mid <= x){
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}