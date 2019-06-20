package stack;

import java.util.Random;

/**
 * @Description: 基于链表实现的栈
 * @Author: victordan
 * @CreateDate: 2019/6/20 00:02
 * @UpdateUser: victordan
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class StackUseLinkList<T> {
    /**
     * 使用top表示当前栈
     */
    private Node<T> top=null;

    /**
     * 入栈操作
     * @param value
     */
    public void push(T value){
        Node newNode=new Node(value,null);
        /**
         * 如果栈顶为空的话，就直接让top移动到新的结点newNode
         */
        if(top==null){
            top=newNode;
        }
        /**
         * top不为空，则先把newNode连到top上面，然后top移动到newNode节点处，成为新的栈顶top
         */
        else{
            newNode.next=top;
            top=newNode;
        }
    }

    /**
     * 出栈，用-1表示栈为空
     * @return
     */
    public T pop(){
        if(top==null){
            return null;
        }
        /**
         * 先把栈顶的值赋给value
         */
        T value=top.data;
        /**
         * 然后栈顶top向下移动到top.next位置。
         */
        top=top.next;
        return value;
    }

    /**
     * 打印栈
     */
    public void printAll(){
        Node p=top;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUseLinkList<Integer> stack=new StackUseLinkList<Integer>();
        int[] arr=new int[10];
        Random random=new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(100)+1;
            stack.push(arr[i]);
        }
        stack.printAll();
        /**
         * 出栈
         */
        stack.pop();
        stack.printAll();
    }
}
