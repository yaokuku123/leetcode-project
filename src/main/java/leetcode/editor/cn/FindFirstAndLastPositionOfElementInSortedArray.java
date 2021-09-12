package leetcode.editor.cn;//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1108 👎 0

//Java：在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[]{-1,-1};
            // 分别二分查找开始和结束位置下标，true表示查找左下标，false表示查找右下标
            res[0] = binarySearch(nums,target,true);
            res[1] = binarySearch(nums,target,false);
            return res;
        }

        private int binarySearch(int[] nums, int target, boolean leftOrRight){
            int res = -1;
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int mid = left + ((right - left)>>2);
                if (nums[mid] < target){
                    left = mid + 1;
                } else if(nums[mid] > target){
                    right = mid - 1;
                } else{
                    res = mid;
                    if(leftOrRight){ // 左下标
                        right = mid - 1;
                    }else{ // 右下标
                        left = mid + 1;
                    }
                }
            }
            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}