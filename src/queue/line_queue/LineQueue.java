package queue.line_queue;

import java.util.Arrays;

/**
 * @ClassName: LineQueue
 * @Description: 用数组实现队列
 * @Author: VictorDan
 * @Date: 19-6-30 上午1:04
 * @Version: 1.0
 **/
public class LineQueue {
    int[] elements;

    public LineQueue() {
        elements = new int[0];
    }
    /**
      *@Author victor
      *@Description 入队
      *@CreateDate 上午1:07 19-6-30
    */
    public void add(int element){
        //创建一个新的数组
        int[] newArr=new int[elements.length+1];
        //把原数组中的元素复制到新数组中
        for (int i = 0; i <elements.length ; i++) {
            newArr[i]=elements[i];
        }
        //把添加的元素放入新数组中
        newArr[elements.length]=element;
        //使用新数组替换旧数组
        elements=newArr;
    }
    /**
      *@Author victor
      *@Description 出队
      *@CreateDate 上午1:08 19-6-30
    */
    public int poll(){
        //把数组中第0个元素取出来
        int element=elements[0];
        //创建一个新的数组
        int[] newArr=new int[elements.length-1];
        //复制原数组中的元素到新数组中
        for (int i = 0; i < newArr.length; i++) {
            newArr[i]=elements[i];
        }
        //用新数组替换旧数组
        elements=newArr;
        return element;
    }
    /**
      *@Author victor
      *@Description 判断队列是否为空
      *@CreateDate 上午1:14 19-6-30
    */
    public boolean isEmpty(){
        return elements.length==0;
    }
    /**
      *@Author victor
      *@Description 打印控制台输出
      *@CreateDate 上午1:14 19-6-30
    */
    public void show(){
        System.out.println(Arrays.toString(elements));
    }
    public static void main(String[] args) {
        LineQueue queue=new LineQueue();
        //判断队列是否为空
        System.out.println(queue.isEmpty());
        //入队
        queue.add(9);
        queue.add(19);
        queue.add(2);
        queue.add(23);
        queue.show();
        //出队
        System.out.println(queue.poll());
        queue.add(6);
        queue.show();
    }
}
