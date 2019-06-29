package tree.binarytree;

/**
 * @ClassName: Node
 * @Description: 二叉链表的结点
 * @Author: VictorDan
 * @Date: 19-6-30 上午2:04
 * @Version: 1.0
 **/
public class Node {
    /**
      *@Author victor
      *@Description 直接去掉属性的private，也就不用写getter,setter方法，直接调用属性
      *@CreateDate 上午2:06 19-6-30
    */
    int value;//结点值
    Node leftChild;//左子树的引用
    Node rightChild;//右子树的引用

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
