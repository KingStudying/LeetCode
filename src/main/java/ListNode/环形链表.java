package ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class 环形链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(1);
        //head.next.next.next.next= head.next;
        System.out.println(hasCycle1(head));
    }

    //哈希集合
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }

    //快慢指针
    public static boolean hasCycle1(ListNode head) {
        ListNode temp = head;
        ListNode temp1 = head;
        while (temp1 != null) {
            temp = temp.next;
            temp1 = temp1.next;
            if (temp1 != null) {
                temp1 = temp1.next;
            } else {
                return false;
            }
            if (temp == temp1) {
                return true;
            }
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        @Override
        public String toString() {
            return val + "";
        }
        public void display(){
            //代跑变量cur
            ListNode cur = this;
            while(cur!=null){
                System.out.print(cur.val+" ");
                cur=cur.next;
            }
            System.out.println();
        }
    }

}
