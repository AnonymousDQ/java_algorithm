package queue;

import java.util.Random;

/**
 * @Description: 环形队列
 * @Author: victordan
 * @CreateDate: 2019/6/20 10:31
 * @UpdateUser: victordan
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CircleQueue {
    private int[] data;
    private int n=0;
    /**
     * head表示队头下标
     */
    private int head=0;
    /**
     * tail表示队尾下标
     */
    private int tail=0;

    /**
     * 申请一个大小为capacity的数组
     * @param capacity
     */
    public CircleQueue(int capacity){
        data=new int[capacity];
        n=capacity;
    }

    /**
     * 入队
     * @param value
     * @return
     */
    public boolean enqueue(int value){
        /**
         * 如果队头head等于队尾，说明环形队列已满，无法入地
         */
        if((tail+1)%n==head){
            System.out.println("队列已满，无法入队！");
            return false;
        }
        /**
         * 入队，是从队尾进行操作，然后队尾移动下一位
         */
        else{
            data[tail]=value;
            tail=(tail+1)%n;
            return true;
        }
    }

    /**
     * 出队
     * @return
     */
    public int dequeue(){
        /**
         * 循环队列，如果head==tail说明队列为空，返回-1
         */
        if(head==tail){
            return -1;
        }
        /**
         * 循环队列，出队是从队头操作，然后队头指针移动1位。
         */
        else{
            int value=data[head];
            head=(head+1)%n;
            return value;
        }
    }

    public void printAll(){
        if(n==0){
            System.out.println("队列为空");
            return;
        }
        for (int i = head; i %n!=tail ; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircleQueue circleQueue=new CircleQueue(10);
        int[] arr=new int[12];
        Random random=new Random();
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=random.nextInt(100)+1;
            if(!circleQueue.enqueue(arr[i])){
                break;
            }
        }
        circleQueue.printAll();
        circleQueue.dequeue();
        circleQueue.printAll();
    }
}
