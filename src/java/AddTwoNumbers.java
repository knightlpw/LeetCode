/**
 * @author linpeiwen
 * @version 1.0  2020/9/3
 * @since 1.8
 *
 * 两数相加 https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    /**
     * 初等数学法
     * 时间O(max(m,n)) 最长的链表
     * 空间O(max(m,n)) 最长的链表
     *
     * 本题不能转换为数字再相加的原因是防止溢出，通过这种算法可以实现任意大小的整数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //哨兵节点-指向计算结果链表
        ListNode dummy = new ListNode(0);
        //移动指针
        ListNode pre = dummy;
        //进位标识
        int cur = 0;

        //指导两个链表都到头才停止循环
        while (l1 != null || l2 != null) {

            //为空的节点填0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            //计算对位节点的总和，包括进位标识
            int sum = x + y + cur;

            //根据总和重新计算下一位的进位标识
            cur = sum / 10;

            //总和取余即为新节点的数值
            pre.next = new ListNode(sum % 10);

            //获取当前节点数值后，指针往高位移动继续下轮计算
            pre = pre.next;

            //不为空的节点继续移动
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //最后还有进位的高位补充1
        if (cur > 0) {
            pre.next = new ListNode(1);
        }

        return dummy.next;


    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
