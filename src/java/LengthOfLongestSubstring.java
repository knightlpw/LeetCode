import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author linpeiwen
 * @version 1.0  2020/10/27
 * @since 1.8
 * <p>
 * 无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {


    /**
     * 滑动窗口
     * 时间 O(n)
     * 空间 O(m) m是字符串所属的字符集大小
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Object> set = new HashSet<>();
        int length = s.length();

        // 初始化右指针和最大长度
        int right = 0, ans = 0;

        // 左指针从0开始
        for (int i = 0; i < length; i++) {

            // 右指针向右移动，遇到尾部或重复则停止
            while (right < length && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }

            // 计算停止后的最大长度
            ans = Math.max(ans, right - i);

            //移除最左元素，左指针右移
            set.remove(s.charAt(i));

        }

        return ans;

    }
}
