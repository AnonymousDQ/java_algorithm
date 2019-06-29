package stack.line_stack;

import java.util.Arrays;

/**
 * @ClassName: LineStack
 * @Description: 使用数组来实现栈
 * @Author: VictorDan
 * @Date: 19-6-30 上午12:44
 * @Version: 1.0
 **/
public class LineStack {
    //栈的底层使用数组来存储数据
    int[] elements;

    public LineStack() {
        elements=new int[0];
    }
    /**
      *@Author victor
      *@Description 压入元素
      *@CreateDate 上午12:47 19-6-30
    */
    public void push(int element){
        //创建一个新的数组
        int[] newArr=new int[elements.length+1];
        //把原数组中的元素复制到新数组中
        for (int i = 0; i <elements.length ; i++) {
            newArr[i]=elements[i];
        }
        //把添加的元素放入新数组最后一个中
        newArr[elements.length]=element;
        //使用新数组替换旧数组
        elements=newArr;
    }
    /**
      *@Author victor
      *@Description 取出栈顶元素
      *@CreateDate 上午12:49 19-6-30
    */
    public int pop(){
        //栈中没哟元素
        if(elements.length==0){
            throw new RuntimeException("stack is empty");
        }
        //取出数组的最后一个元素
        int element=elements[elements.length-1];
        //创建一个新的数组
        int[] newArr=new int[elements.length-1];
        //原数组中除了最后一个元素的其他元素都放入到新的数组中
        for (int i = 0; i < elements.length-1; i++) {
            newArr[i]=elements[i];
        }
        //替换数组
        elements =newArr;
        return element;
    }
    /**
      *@Author victor
      *@Description 查看栈顶元素，并不是取出
      *@CreateDate 上午12:57 19-6-30
    */
    public int peek(){
        return elements[elements.length-1];
    }
    /**
      *@Author victor
      *@Description 栈是否为空
      *@CreateDate 上午12:58 19-6-30
    */
    public boolean isEmpty(){
        return elements.length==0;
    }
    /**
      *@Author victor
      *@Description 打印所有元素到控制台
      *@CreateDate 上午12:52 19-6-30
    */
    public void show(){
        System.out.println(Arrays.toString(elements));
    }

    public static void main(String[] args) {
        //创建一个栈
        LineStack stack=new LineStack();
        //判断栈是否为空
        System.out.println(stack.isEmpty());
        //压入数据
        stack.push(8);
        stack.push(3);
        stack.push(9);
        stack.show();
        //查看栈顶元素
        stack.peek();
        System.out.println(stack.peek());
        //栈顶元素出栈
        stack.pop();
        stack.show();
        System.out.println(stack.peek());
    }
}
