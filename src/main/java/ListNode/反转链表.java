package ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class 反转链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);

        reverseList(head).display();
    }

    /**
     * 1. 定义两个指针:prev和curr。prev初始化为null,curr初始化为头节点head。
     * 2. 在循环中,首先保存curr的下一个节点next。
     * 3. 然后改变curr的next指向prev。prev指向curr前面的节点,开始为null。
     * 4. prev向前移动一位,现在指向curr。curr向前移动一位,现在指向next。
     * 5. 重复步骤2-4,直到curr变为null,遍历完链表。
     * 6. 此时prev指向反转后链表的头节点,直接返回prev。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 1. 终止条件:当head为空或只有一个节点时,直接返回head。
     * 2. 递归调用:递归调用reverseList来反转后续链表,结果为反转后链表的新的头节点newHead。
     * 3. 改变节点指向:让原头节点head的next指针指向null,新的头节点newHead的next指针指向原头节点head,实现一个节点的反转。
     * 4. 返回新头节点:返回反转后的头节点newHead。
     *
     * 第一轮出栈，head为5，head.next为空，返回5
     *             第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
     *                       把当前节点的子节点的子节点指向当前节点
     *                       此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
     *                       此时链表为1->2->3->4<-5
     *                       返回节点5
     *             第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
     *                       此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
     *                       此时链表为1->2->3<-4<-5
     *                       返回节点5
     *             第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
     *                       此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
     *                       此时链表为1->2<-3<-4<-5
     *                       返回节点5
     *             第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
     *                       此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
     *                       此时链表为1<-2<-3<-4<-5
     *                       返回节点5
     *             出栈完成，最终头节点5->4->3->2->1
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
