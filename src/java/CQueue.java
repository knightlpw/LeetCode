import java.util.Stack;

/**
 * @author linpeiwen
 * @version 1.0  2020/9/9
 * @since 1.8
 * <p>
 * 用两个栈实现队列 https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {

    private Stack<Integer> appendStack;
    private Stack<Integer> deleteStack;

    public CQueue() {
        appendStack = new Stack<>();
        deleteStack = new Stack<>();
    }

    /**
     * 插入直接入栈
     * 时间 O(1)
     * 空间 O(n)
     * @param value
     */
    public void appendTail(int value) {
        appendStack.add(value);
    }

    /**
     * 删除时deleteStack栈顶出栈，没有则把appendStack的栈全部压入deleteStack后再出栈，都没有则返回-1
     * 平均时间 O(1)
     * 空间 O(n)
     * @return
     */
    public int deleteHead() {

        if(!deleteStack.empty()){
            return deleteStack.pop();
        }

        if (appendStack.empty()) {
            return -1;
        }

        while (!appendStack.empty()){
            deleteStack.push(appendStack.pop());
        }

        return deleteStack.pop();
    }

}
