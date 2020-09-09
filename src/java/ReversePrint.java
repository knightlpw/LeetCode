/**
 * @author linpeiwen
 * @version 1.0  2020/9/9
 * @since 1.8
 *
 * 从尾到头打印链表 https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {

    /**
     *
     * 时间 O(n)
     * 空间 O(n)
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {

        // 移动指针指向首位
        ListNode node = head;

        int count = 0;

        // 计算链表长度
        while(node!=null){
            count++;
            // 移动指针往后移动
            node = node.next;
        }

        int[] res = new int[count];

        // 移动指针回到首位
        node = head;

        // 顺序扫描链表，倒序插入数组中
        for (int i = count-1; i >=0; i--) {
            res[i] = node.val;
            node = node.next;
        }

        return res;


    }



    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
}
