package queue;

/**
 * @Description: 链表的结点
 * @Author: victordan
 * @CreateDate: 2019/6/20 10:15
 * @UpdateUser: victordan
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Node<T> {
    public T data;
    public Node next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
    }

    public T getData() {
        return data;
    }
}
