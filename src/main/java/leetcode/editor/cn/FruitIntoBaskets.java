package leetcode.editor.cn;
//在一排树中，第 i 棵树产生 tree[i] 型的水果。
//你可以从你选择的任何树开始，然后重复执行以下步骤： 
//
// 
// 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。 
// 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。 
// 
//
// 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。 
//
// 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。 
//
// 用这个程序你能收集的水果树的最大总量是多少？ 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,1]
//输出：3
//解释：我们可以收集 [1,2,1]。
// 
//
// 示例 2： 
//
// 输入：[0,1,2,2]
//输出：3
//解释：我们可以收集 [1,2,2]
//如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
// 
//
// 示例 3： 
//
// 输入：[1,2,3,2,2]
//输出：4
//解释：我们可以收集 [2,3,2,2]
//如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
// 
//
// 示例 4： 
//
// 输入：[3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：我们可以收集 [1,2,1,1,2]
//如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tree.length <= 40000 
// 0 <= tree[i] < tree.length 
// 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 96 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：水果成篮
public class FruitIntoBaskets{
    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalFruit(int[] fruits) {
        //本题中符合条件指窗口中水果种类是2。 用HashMap记录，Map<水果种类，出现频次>，
        // 延伸右边界时，增加频次。缩进左边界时，减少频次。 频次为0时，从map删除。 map的大小为2时，正好符合条件。
        if (fruits == null || fruits.length == 0){
            return 0;
        }
        int maxLen = 0,left = 0,right = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (; right < fruits.length ; right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while (map.size() > 2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if (map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen,right - left + 1);
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}