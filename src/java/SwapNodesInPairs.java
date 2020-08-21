/**
 * @author linpeiwen
 * @version 1.0  2020/8/19
 * @since 1.8
 * 两两交换链表中的节点 https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {


    /**
     * 递归法
     * 时间O(n) 空间O(n)——栈调用
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        //确定终止条件
        if(head == null || head.next == null){
            return head;
        }

        //准备第一第二节点
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        //开始交换节点
        // 1 第一节点连接到交换顺序后的链表前，后续待交换顺序的链表 的头结点是secondNode.next
        firstNode.next = swapPairs(secondNode.next);

        // 2 第二节点连接到第一节点后面 完成链表交换
        secondNode.next = firstNode;

        // 返回第二节点（变成新链表的头结点）用于连接
        return secondNode;

    }


    /**
     * 迭代法-哨兵节点法
     * 时间O(n) 空间O(1)
     *
     * 交换链表的关键 ：区分清楚变量指针和节点指针，
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //头结点的前驱节点
        ListNode pre = dummy;

        while (head !=null && head.next != null){

            ListNode firseNode = head;
            ListNode secondNode = head.next;

            //交换节点三部曲
            // 1 修改前驱节点指针
            pre.next = secondNode;

            //修改原第一节点指针
            firseNode.next = secondNode.next;

            //修改原第二节点指针
            secondNode.next = firseNode;

            // 交换完成 重置前驱节点和第一节点
            pre = firseNode;
            head = firseNode.next;

        }

        return dummy.next;

    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
