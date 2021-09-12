1.**题目意思**
每棵树只有1个水果。
找出连续子数组，一共2种水果，子数组长度最长。

2.**思路**
求最长子数组长度，直滑动窗口模板。

    最长窗口模板
    for(枚举选择)
        右边界
        while(不符合条件)
            左边界
        更新结果


**细节**
如何处理“不符合条件”？

本题中符合条件指窗口中水果种类是2。
用HashMap记录，Map<水果种类，出现频次>，
延伸右边界时，增加频次。缩进左边界时，减少频次。
频次为0时，从map删除。
map的大小为2时，正好符合条件。
```
class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        int n = tree.length;

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int i = 0; i < n; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);  // 右边界
            while (map.size() > 2) {  // 不符合条件：水果种类大于2
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0) map.remove(tree[left]); 
                left++;  // 左边界
            }
            maxLen = Math.max(maxLen, i - left + 1); // 更新结果
        }
        return maxLen;
    }
}
```
