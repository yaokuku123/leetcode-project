# [904.水果成篮](https://leetcode-cn.com/problems/fruit-into-baskets/solution/904shui-guo-cheng-lan-pythonhua-dong-chu-018q/)

> https://leetcode-cn.com/problems/fruit-into-baskets/solution/904shui-guo-cheng-lan-pythonhua-dong-chu-018q/
>
> 难度：中等

## 题目：

在一排树中，第 i 棵树产生 tree[i] 型的水果。 你可以从你选择的任何树开始，然后重复执行以下步骤：

把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤
2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。

你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。

用这个程序你能收集的水果树的最大总量是多少？

提示：

- 1 <= tree.length <= 40000
- 0 <= tree[i] < tree.length

## 示例：

```
示例 1：
输入：[1,2,1]
输出：3
解释：我们可以收集 [1,2,1]。

示例 2：
输入：[0,1,2,2]
输出：3
解释：我们可以收集 [1,2,2]
如果我们从第一棵树开始，我们将只能收集到 [0, 1]。

示例 3：
输入：[1,2,3,2,2]
输出：4
解释：我们可以收集 [2,3,2,2]
如果我们从第一棵树开始，我们将只能收集到 [1, 2]。

示例 4：
输入：[3,3,3,1,2,1,1,2,3,3,4]
输出：5
解释：我们可以收集 [1,2,1,1,2]
如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
```

## 分析

使用哈希表，走滑动窗口的方法相信大家都能想到。

1. 创建一个空的哈希表，并设置左指针为0
2. 然后遍历数组，将数组一次添加至哈希表中
3. 当哈希表的长度大于2时，右移左指针，在过程中删除哈希表中的对应内容，直至长度为2停止
4. 循环2、3，并持续计算满足要求后的最大长度即可。

另外想了下用模拟的方式完成了下这道题：

1. 我们构造l，r两个空数组。
2. 然后遍历数组
3. 每次获取到数字时，如果l为空或l[-1]的值与该数字相同，这append加入l，continue
4. 同理，当r不存在或者r[-1]与数字相同时，append加入r
5. 若不满足3、4场景，先更新ret=max(ret,i-l[0])
6. 定义一个comp函数，判断若l[-1]大于r[-1]，则交换l与r
7. 循环r，将所有r中大于l[-1]的数字添组成为一个新的数组赋值给l，将r变为当前的[i]
8. 最终判断特殊场景全部为同一元素时，ret=max(ret, len - l[0])即可。

## 哈希表解题：
![image.png](https://pic.leetcode-cn.com/1626334735-EaoOru-image.png)

```python
from collections import Counter


class Solution:
    def totalFruit(self, fruits):
        dic = Counter()
        ret = left = 0
        for i, j in enumerate(fruits):
            dic[j] += 1
            while len(dic) > 2:
                dic[fruits[left]] -= 1
                if dic[fruits[left]] == 0:
                    del dic[fruits[left]]
                left += 1
            ret = max(ret, i - left + 1)
        return ret
```

## 模拟解题：
![image.png](https://pic.leetcode-cn.com/1626334697-izODVr-image.png)

```python
class Solution:
    def totalFruit(self, fruits):
        l, r, ret, lg = [], [], 0, len(fruits)

        def comp(li1, li2):
            if li1[-1] > li2[-1]:
                li1, li2 = li2, li1
            return [index for index in li2 if index > li1[-1]]

        for i, j in enumerate(fruits):
            if not l or fruits[i] == fruits[l[-1]]:
                l.append(i)
                continue
            if r and fruits[i] != fruits[r[-1]]:
                ret = max(i - l[0], ret)
                l, r = comp(l, r), [i]
            else:
                r.append(i)
        return max(ret, lg - l[0])
```

欢迎关注我的公众号: **清风Python**，带你每日学习Python算法刷题的同时，了解更多python小知识。

有喜欢力扣刷题的小伙伴可以加我微信（King_Uranus）互相鼓励，共同进步，一起玩转超级码力！

我的个人博客：[https://qingfengpython.cn](https://qingfengpython.cn)

力扣解题合集：[https://github.com/BreezePython/AlgorithmMarkdown](https://github.com/BreezePython/AlgorithmMarkdown)
