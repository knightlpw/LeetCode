
/**
 * @author linpeiwen
 * @version 1.0  2020/8/31
 * @since 1.8
 * 删除字符串中的所有相邻重复项 https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveAllAdjacentDuplicatesInString {


    /**
     * 双指针法
     * 时间O(n)
     * 空间O(n)
     * @param S
     * @return
     */
    public static String removeDuplicates(String S) {

        StringBuilder bu = new StringBuilder(S);

        int i = 0;
        while (i<bu.length()-1){
            //相等则删除
            if(bu.charAt(i) == bu.charAt(i+1)){
                bu.delete(i, i + 2);

                //指针往后退一位 继续验证
                if(i>0){
                    i = i - 1;
                }
            }else {
                //不等则往前
                i++;
            }

        }
        return bu.toString();
    }


    /**
     * 栈
     * 时间O(n)
     * 空间O(n)
     * @param S
     * @return
     */
    public static String removeDuplicates2(String S) {

        //char[]数组模拟栈
        StringBuilder builder = new StringBuilder();

        int length = 0;
        for (char c : S.toCharArray()) {

            //首个元素或者不与栈顶匹配则入栈
            if(length == 0||builder.charAt(length-1) != c){
                builder.append(c);
                length++;
            }else {
                //与栈顶匹配则出栈
                builder.deleteCharAt(length-1);
                length--;
            }
        }

        return builder.toString();
    }
}
