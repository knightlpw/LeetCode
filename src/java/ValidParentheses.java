import java.util.Stack;

/**
 * @author linpeiwen
 * @version 1.0  2020/8/15
 * @since 1.8
 *
 * 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 * 用栈解决的问题：具有最近相关性的问题
 */
public class ValidParentheses {

    /**
     * 一个栈匹配成对括号
     * 时间O(n) 空间O(n)
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if((s.length()&1) == 1){
            return false;
        }

        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                stack.push(')');
            } else if ('{' == c) {
                stack.push('}');
            } else if ('[' == c){
                stack.push(']');

            }else if(stack.isEmpty()||!stack.pop().equals(c)){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
