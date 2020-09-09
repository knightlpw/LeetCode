import java.util.*;

/**
 * @author linpeiwen
 * @version 1.0  2020/8/28
 * @since 1.8
 *
 * 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    /**
     * hash法
     * 时间O(kn): k是strs元素的最大长度，n是strs长度
     * 空间O(nk): k是strs元素的最大长度，n是strs长度
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null||strs.length == 0){
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = new char[26];

            // 将字符串散列到char数组中 字母异位词的散列数组结果相同
            // 相当于排序 【有限】字符排序（或去重，计数）可以用一个数组 将字符散列到数组中 字符便自然排序（或去重，计数）了
            for (char c : str.toCharArray()) {
                ch[c-'a']++;
            }

            // 散列后的char数组重新组合成字符串 用于接下来的比较
            String s = new String(ch);

            // 根据散列后的字符串分组
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
