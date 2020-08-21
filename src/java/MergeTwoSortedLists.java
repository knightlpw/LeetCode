/**
 * @author linpeiwen
 * @version 1.0  2020/8/17
 * @since 1.8
 *
 * 合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    /**
     * 递归法
     * 时间O(n+m) 空间O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1.val > l2.val){
            //在更小的节点后接续拼接节点
            l2.next = mergeTwoLists(l1, l2.next);
            //返回更小的一个节点作为连接点 此处是理解递归的关键，需要和递归终止条件结合起来看
            return l2;
        }else {
            //在更小的节点后接续拼接节点
            l1.next = mergeTwoLists(l1.next, l2);
            //返回更小的一个节点作为连接点 此处是理解递归的关键，需要和递归终止条件结合起来看
            return l1;
        }
    }


    /**
     * 双指针遍历法
     *
     * 时间O(n+m) 空间O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        //固定指针
        ListNode fixed = new ListNode();

        //移动指针 一开始两个指针都指向同一个链表的头指针
        ListNode move = fixed;

        while (l1!=null&&l2!=null){

            if(l1.val <= l2.val){
                //小节点拼接在动态指针后
                move.next = l1;
                //l1往前进一步
                l1 = l1.next;
            }else {
                move.next = l2;
                l2 = l2.next;
            }
            //动态指针进位
            move = move.next;

        }

        //动态指针移动到链表末尾
        //将剩余节点直接拼在最后
        move.next = l1 == null ? l2 : l1;

        //返回固定指针指向的完整链表
        return fixed.next;

    }



    private class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
