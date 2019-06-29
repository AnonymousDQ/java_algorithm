package list.link_list;

/**
 * @Description: 链表结点
 * @Author: victordan
 * @CreateDate: 2019/6/19 22:21
 * @UpdateUser: victordan
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Node {
    public int data;
    public Node next;
    public Node() {
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public int getData() {
        return data;
    }
}
