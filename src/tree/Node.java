package tree;

/**
 * @ClassName: Node
 * @Description: 二叉树的结点
 * @Author: VictorDan
 * @Date: 19-6-29 下午7:09
 * @Version: 1.0
 **/
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
}
