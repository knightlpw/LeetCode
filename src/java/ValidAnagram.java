/**
 * @author linpeiwen
 * @version 1.0  2020/8/27
 * @since 1.8
 *
 * 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 */
public class ValidAnagram {


    /**
     * hash表法
     * 时间O(n) 空间O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        //长度不同则提前返回
        if(s.length() != t.length()){
            return false;
        }

        //装下26个字母的hash表
        int[] list = new int[26];

        for (int i = 0; i < s.length(); i++) {
            //将s字符串的每个字母hash后放入hash表中，然后加一，hash函数为 s.charAt(i)-'a'
            list[s.charAt(i)-'a']++;

        }

        for (int i = 0; i < t.length(); i++) {
            //将t字符串的每个字母hash后放入hash表中，然后减一
            //如果出现小于0的情况，则说明t里面包含s没有的字母，或者某字母数量与t不符
            if(--list[t.charAt(i)-'a'] < 0){
                return false;
            }
        }

        return true;
    }
}
