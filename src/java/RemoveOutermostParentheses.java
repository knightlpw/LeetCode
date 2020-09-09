/**
 * @author linpeiwen
 * @version 1.0  2020/9/3
 * @since 1.8
 *
 * 删除最外层的括号 https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
public class RemoveOutermostParentheses {


    /**
     * 单指针计数法
     * 时间O(n) 空间O(n)
     *
     * 理解这道题的难点在于如何识别最外层括号，分解为如何识别最外层左括号和最外层右括号
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {

            //最外层左括号在累加前level=0
            if (c == '(' && level++ > 0) {
                //只拼接非最外层括号
                sb.append(c);
            }

            //最外层右括号在累减后=0
            if (c == ')' && --level > 0) {
                //只拼接非最外层括号
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
