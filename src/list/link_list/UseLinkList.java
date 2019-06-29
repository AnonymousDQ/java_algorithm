package list.link_list;

import java.util.Random;

/**
 * @Description:
 * 1、单链表反转
 * 2、链表中环的检测
 * 3、两个有序的链表合并
 * 4、删除链表倒数第n个结点
 * 5、求链表的中间结点
 * @Author: victordan
 * @CreateDate: 2019/6/19 23:17
 * @UpdateUser: victordan
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class UseLinkList {
    /**
     * 单链表反转
     * @param head
     * @return
     */
    public Node reverse(Node head){
        Node rear=head,pre=null;
        while(rear!=null){
            Node next=rear.next;
            rear.next=pre;
            pre=rear;
            rear=next;
        }
        return pre;
    }

    /**
     * 校验链表是否有环
     * @param head
     * @return
     */
    public boolean checkCircle(Node head){
        if(head==null){
            return false;
        }
        /**
         * 利用快慢指针，fast比slow快一步
         */
        Node fast=head.next;
        Node slow=head;
        while(fast!=null&&fast.next!=null){
            /**
             * fast每次2个结点那样跨越
             */
            fast=fast.next.next;
            /**
             * slow每次访问1个结点
             */
            slow=slow.next;
            /**
             * 如果说slow==fast，说明fast走完了，slow才走了一半，等slow走完一圈，fast已经走完两圈。
             * slow和fast重和说明有环
             */
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 合并两个链表，让他们升序排列
     * @param headA
     * @param headB
     * @return
     */
    public Node mergetSortedList(Node headA,Node headB){
        if(headA==null){
            return headB;
        }
        if(headB==null){
            return headA;
        }
        /**
         * 用两个临时变量来标记A,B两个链表
         */
        Node p=headA;
        Node q=headB;
        Node head;
        if(p.data<q.data){
            head=p;
            p=p.next;
        }else{
            head=q;
            q=q.next;
        }
        /**
         * 让临时指针r指向head两个表之间的头结点。按照升序进行排列
         * 就是相当于，在新建一个链表，然后从小到大进行插入两个链表里的元素到r链表
         */
        Node r=head;
        while(p!=null&&q!=null){
            /**
             * 如果p的数据比q的小，则就是把r链接到p的结点，然后p继续往下一个结点进行判断
             */
            if(p.data<q.data){
                r.next=p;
                p=p.next;
            }else{
                r.next=q;
                q=q.next;
            }
            /**
             * r插入一个结点后，然后继续往下一个结点。
             */
            r=r.next;
        }
        if(p!=null){
            r.next=p;
        }else{
            r.next=q;
        }
        return head;
    }

    /**
     * 删除第k个结点
     * 思想：利用快慢指针
     * @param head
     * @param k
     * @return
     */
    public Node deleteLastKth(Node head,int k){
        /**
         * 首先声明一个临时变量fast让它先指向head链表，
         * 如果fast不为null且flag还没到第k个位置的话，就一直往下移动
         */
        Node fast=head;
        int flag=1;
        while(fast!=null&&flag<k){
            fast=fast.next;
            ++flag;
        }
        /**
         * 如果链表中只要一个结点的话，fast移动了一次之后就成了fast.next为null了
         * 就返回这个头结点head
         */
        if(fast==null){
            return head;
        }
        Node slow=head;
        Node p=null;
        /**
         * 如果fast.next不为null，也就是说fast已经到了第k个位置
         * 而且fast后面还有结点
         * 先让fast移动到第k+1个结点处
         * 然后用临时结点p先保存slow的值，为了就是保存slow移动之前的上一个结点
         * 然后slow进行移动
         */
        while(fast.next!=null){
            fast=fast.next;
            p=slow;
            slow=slow.next;
        }
        /**
         * 如果p等于null，也就是说p是slow移动之前的结点，也即是说当前链表只有一个结点
         * 自然把头结点head移动到head.next了，进行了删除。
         */
        if(p==null){
            head=head.next;
        }
        /**
         * 如果slow不为空，也就是说第k个结点存在，就把第p的结点直接指向下一个的下一个，达到删除第k个结点。
         */
        else{
            p.next=p.next.next;
        }
        return head;
    }

    public Node findMiddleNode(Node head){
        if(head==null){
            return null;
        }
        Node fast=head;
        Node slow=head;
        /**
         * 让fast和slow开始都指向头结点head，然后每次fast移动是slow的2倍
         * 也就是fast走完链表的时候，此时slow刚好走到一半。也就是中间结点
         * 返回slow就行。
         */
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        LinkList list=new LinkList();
        Random random=new Random();
        int[] arr=new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=random.nextInt(100)+1;
            list.insertTail(arr[i]);
        }
        list.printAll();
    }
}
