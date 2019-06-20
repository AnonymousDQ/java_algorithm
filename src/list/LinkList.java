package list;

/**
 * @Description: 单链表的插入、删除、查找操作
 * 链表里存储的int类型的数据
 * @Author: victordan
 * @CreateDate: 2019/6/19 22:23
 * @UpdateUser: victordan
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class LinkList {
    /**
     * 用head表示当前链表
     */
    private Node head=null;

    /**
     * 单链表的查找操作
     * @param value
     * @return
     */
    public Node findByValue(int value){
        /**
         * 建立一个临时变量p,为了不改变头指针
         */
        Node p=head;
        while(p!=null&&p.data!=value){
            p=p.next;
        }
        return p;
    }

    /**
     * 查找index位置的结点
     * @param index
     * @return
     */
    public Node findByIndex(int index){
        Node p=head;
        int flag=0;
        while(p!=null&&flag!=index){
            p=p.next;
            flag++;
        }
        return p;
    }

    /**
     * 插入结点，没有头结点的
     * 表头插入，操作额输入顺序是逆序的
     * @param newNode
     */
    public void  insertToHead(Node newNode){
        /**
         * 用head表示链表，如果链表为空，则把当前的结点赋给链表
         */
        if(head==null){
            head=newNode;
        }
        /**
         * 如果链表不为空，头插入法，则让要插入的结点，连到头结点，然后再把头结点移动到新插入的结点位置
         */
        else{
            newNode.next=head;
            head=newNode;
        }
    }
    public void insertToHead(int value){
        Node newNode=new Node(value,null);
        insertToHead(newNode);
    }

    public void insertTail(int value){
        Node newNode=new Node(value,null);
        /**
         * 如果链表head为空，则把新插入的结点连到head上，不做操作
         */
        if(head==null){
            head=newNode;
        }
        /**
         * 如果不为空，先用一个临时变量p，让它移动到链表的末尾，因为末尾的节点域肯定是null的
         * 所以while循环只要不为null就一直p=p.next
         */
        else{
            Node p=head;
            while(p.next!=null){
                p=p.next;
            }
            p.next=newNode;
            p=newNode;
            p.next=null;
        }
    }

    /**
     * 删除结点p
     * @param p
     */
    public void deletebyNode(Node p){
        if(p==null||head==null){
            return;
        }
        /**
         * 如果p为头结点，也就是链表中只有一个节点的时候，
         * 直接让head指向head.next，因为head.next为null
         */
        if(p==head){
            head=head.next;
            return;
        }
        /**
         * 临时变量q，然后q不为null且q的next域不等于p的时候，一直遍历下去，直到q.next存的是p的结点信息退出
         */
        Node q=head;
        while(q!=null&&q.next!=p){
            q=q.next;
        }
        if(q==null){
            return;
        }
        /**
         * 原来q的next存的是p的信息，现在让q指向p的下一个结点的，p的下一个结点就是q.next.next
         */
        q.next=q.next.next;
    }

    /**
     * 根据value来查找特定的结点，并删除
     * @param value
     */
    public void deleteByValue(int value){
        if(head==null){
            return;
        }
        /**
         * 用两个变量p，q，p比q快一步
         */
        Node p=head;
        Node q=null;
        while(p!=null&&p.data!=value){
            /**
             * 此时q为head，p已经是head.next了
             */
            q=p;
            p=p.next;
        }
        if(p==null){
            return;
        }
        /**
         * 如果q为空说明，此时q=head.next为null，也就是只有head这一个结点
         */
        if(q==null){
            head=head.next;
        }else{
            q.next=q.next.next;
        }
    }

    /**
     * 打印链表
     */
    public void printAll(){
        Node p=head;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList linkList=new LinkList();
        LinkList linkList1=new LinkList();
        int[] data={1,3,2,5,32,12};
        for (int i = 0; i < data.length; i++) {
            linkList.insertToHead(data[i]);
        }
        linkList.printAll();
        for (int i = 0; i < data.length; i++) {
            linkList1.insertTail(data[i]);
        }
        linkList1.printAll();
        Node p=new Node();
        linkList1.deleteByValue(32);
        linkList1.printAll();
    }
}
