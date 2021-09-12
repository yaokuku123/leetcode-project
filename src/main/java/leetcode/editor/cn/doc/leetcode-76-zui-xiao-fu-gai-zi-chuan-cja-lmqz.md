 

### 1、思路

**(滑动窗口)**  *O(n)*

这道题要求我们返回字符串` s`中包含字符串 `t` 的全部字符的最小窗口，我们利用滑动窗口的思想解决这个问题。因此我们需要两个哈希表，`hs`哈希表维护的是`s`字符串中滑动窗口中各个字符出现多少次，`ht`哈希表维护的是`t`字符串各个字符出现多少次。如果`hs`哈希表中包含`ht`哈希表中的所有字符，并且对应的个数都不小于`ht`哈希表中各个字符的个数，那么说明当前的窗口是**可行**的，可行中的长度最短的滑动窗口就是答案。
![image.png](https://pic.leetcode-cn.com/1627392480-ABjwBs-image.png)


**过程如下：** 

1、遍历`t`字符串，用`ht`哈希表记录`t`字符串各个字符出现的次数。 

![<img src="力扣500题刷题笔记.assets/image-20210710122600263.png" alt="image-20210710122600263" style="zoom:67%;" />](https://pic.leetcode-cn.com/1626094551-vODlam-file_1626094550107)


2、定义两个指针`j`和`i`，`j`指针用于收缩窗口，`i`指针用于延伸窗口，则区间`[j,i]`表示当前滑动窗口。首先让`i`和`j`指针都指向字符串`s`开头，然后枚举整个字符串`s` ，枚举过程中，不断增加`i`使滑动窗口增大，相当于向右扩展滑动窗口。

![<img src="力扣500题刷题笔记.assets/image-20210710121027770.png" alt="image-20210710121027770" style="zoom:67%;" />](https://pic.leetcode-cn.com/1626094551-FNKtMc-file_1626094550122)


3、每次向右扩展滑动窗口一步，将`s[i]`加入滑动窗口中，而新加入了`s[i]`，相当于滑动窗口维护的字符数加一，即`hs[s[i]]++`。 

![<img src="力扣500题刷题笔记.assets/image-20210710122648338.png" alt="image-20210710122648338" style="zoom: 67%;" />](https://pic.leetcode-cn.com/1626094551-RbOYEW-file_1626094550125)


4、对于新加入的字符`s[i]`,如果`hs[s[i]] <= ht[s[i]]`，说明当前新加入的字符`s[i]`是必需的，且还未到达字符串`t`所要求的数量。我们还需要事先定义一个`cnt`变量， `cnt`维护的是`s`字符串`[j,i]`区间中满足`t`字符串的元素的个数，记录相对应字符的总数。新加入的字符`s[i]`必需，则`cnt++`。

5、我们向右扩展滑动窗口的同时也不能忘记收缩滑动窗口。因此当`hs[s[j]] > ht[s[j]`时，说明`hs`哈希表中`s[j]`的数量多于`ht`哈希表中`s[j]`的数量，此时我们就需要向右收缩滑动窗口，`j++`并使`hs[s[j]]--`，即`hs[s[j ++ ]] --`。

6、当`cnt == t.size`时，说明此时滑动窗口包含符串 `t` 的全部字符。我们重复上述过程找到最小窗口即为答案。


![image.png](https://pic.leetcode-cn.com/1627392545-pNYyEm-image.png)


### 2、c++代码

```cpp
class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> hs, ht;
        for (auto c: t) ht[c] ++ ;
        string res;
        int cnt = 0;
        for (int i = 0, j = 0; i < s.size(); i ++ ) {
            hs[s[i]] ++ ;
            if (hs[s[i]] <= ht[s[i]]) cnt ++ ;

            while (hs[s[j]] > ht[s[j]]) hs[s[j ++ ]] -- ;
            if (cnt == t.size()) {
                if (res.empty() || i - j + 1 < res.size())
                    res = s.substr(j, i - j + 1);
            }
        }
        return res;
    }
};
```

### 3、java代码

```java
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hs = new HashMap<Character,Integer>();
        HashMap<Character,Integer> ht = new HashMap<Character,Integer>();
        for(int i = 0;i < t.length();i ++)
        {
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        int len = 0x3f3f3f3f;
        int cnt = 0;//有多少个元素符合
        for(int i = 0,j = 0;i < s.length();i ++)
        {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            if(ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) cnt ++;

            //维护双指针
            while(j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j))))
            {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j ++;
            }

            if(cnt == t.length() && i - j + 1 < len)
            {
                len = i - j + 1;
                ans = s.substring(j,i + 1);
            }
        }
        return ans;
    }
}
```
**笔记链接：**  [精选力扣500题 第60题 LeetCode 76. 最小覆盖子串【c++/java详细题解】](https://blog.csdn.net/weixin_45629285/article/details/118674829)