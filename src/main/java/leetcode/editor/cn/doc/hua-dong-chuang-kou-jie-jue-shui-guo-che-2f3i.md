### 解题思路
**求只包含两种元素的最长连续子序列**
给定一个数组，数组中存在着不同值的数字，每种数字代表一种类型的水果，不是数量，比如tree[i] = [1,2,1] 1 代表 1 种水果，2代表1种水果，数组中数字的频率代表该类型水果的数量

**最长窗口模板**
for(枚举选择)
    右边界
    while(不符合条件)
        左边界
    更新结果

用HashMap记录，Map<水果种类，出现频次>，
如果集合中没有tree[i]类水果，就是用默认值0然后次数+1，如果集合中有tree[i]类水果，就是用这个键对应的值+1
当集合的长度大于2表示水果种类大于2，利用集合的键找值的方法
延伸右边界时，增加频次。缩进左边界时，减少频次。
频次为0时，从map删除。
map的大小为2时，正好符合条件。
当数组到达最后一个元素，即遍历结束
### 代码

```java
class Solution {
    public int totalFruit(int[] tree) {
 if (tree == null || tree.length == 0) return 0;
        int n = tree.length;

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, 记录水果数
        left = 0;
        for (int i = 0; i < n; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);  // 右边界
    //getOrDefault(Object key, V defaultValue)
当Map集合中有这个key时，就使用这个key对应的value值，如果没有就使用默认值defaultValue
            while (map.size() > 2) {  // 不符合条件：水果种类大于2
                map.put(tree[left], map.get(tree[left]) - 1);//缩进左边界时，减少频次。
                if (map.get(tree[left]) == 0) map.remove(tree[left]); //如果值为0直接移除这个元素
                left++;  // 左边界
            }
            maxLen = Math.max(maxLen, i - left + 1); // 更新结果
        }
        return maxLen;
    }
}
```