package queue;

import java.util.Random;

/**
 * @Description: 基于链表实现的队列
 * @Author: victordan
 * @CreateDate: 2019/6/20 10:15
 * @UpdateUser: victordan
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class QueueUseLinkList<T> {
    /**
     * 队头：用来出队
     */
    private Node<T> head=null;
    /**
     * 队尾：用来进队
     */
    private Node<T> tail=null;

    /**
     * 入队
     * @param value
     */
    public void enqueue(T value){
        /**
         * 如果队列为空，创建一个新节点，然后让队头，队尾都指向这个结点
         */
        if(tail==null){
            Node newNode=new Node(value,null);
            head=newNode;
            tail=newNode;
        }
        /**
         * 如果队列不空，则让队尾连到新的结点
         * 然后再把队尾指针移动新的结点
         */
        else{
            tail.next=new Node(value,null);
            tail=tail.next;
        }
    }

    /**
     * 出队
     * @return
     */
    public T dequeue(){
        /**
         * 如果队头为空，说明队列里没有元素要出队。
         */
        if(head==null){
            return null;
        }
        /**
         * 如果队列不为空，出队是从队头开始，则把队头元素赋给value，然后队头移动到下一个
         */
        T value=head.data;
        head=head.next;
        /**
         * 队头移动到下一个后，如果此时为null了，说明队列中只有一个结点。
         * 则把队尾指针也置为null
         */
        if(head==null){
            tail=null;
        }
        return value;
    }

    public void printAll(){
        /**
         * 打印从队头元素开始，用临时变量p操作。
         */
        Node p=head;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random random=new Random();
        int[] arr=new int[10];
        QueueUseLinkList<Integer> queueUseLinkList=new QueueUseLinkList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(100)+1;
            queueUseLinkList.enqueue(arr[i]);
        }
        queueUseLinkList.printAll();
        queueUseLinkList.dequeue();
        queueUseLinkList.printAll();
    }

}
