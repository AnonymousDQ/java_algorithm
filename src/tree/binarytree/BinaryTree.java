package tree.binarytree;

/**
 * @ClassName: BinaryTree
 * @Description: 二叉树的方法
 * @Author: VictorDan
 * @Date: 19-6-30 上午2:40
 * @Version: 1.0
 **/
public class BinaryTree implements IBinaryTree{
    private Node root;//根节点

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public int size() {
        System.out.println("二叉树的节点数是：");
        return this.size(root);
    }
    private int size(Node root){
        if(root==null){
            return 0;
        }else{
            //获取左子树的size
            int leftSize=this.size(root.leftChild );
            //获取右子树的size
            int rightSize=this.size(root.rightChild );
            //返回左子树，右子树，再加1根节点
            return leftSize+rightSize+1;
        }
    }

    @Override
    public int getHeight() {
        System.out.println("二叉树的高度是：");
        return this.getHeight(root);
    }
    private int getHeight(Node root){
        if(root==null){
            return 0;
        }else{
            //获取左子树的高度
            int leftHeight=this.getHeight(root.leftChild);
            //获取右子树的高度
            int rightHeight=this.getHeight(root.rightChild);
            return leftHeight>rightHeight?leftHeight+1:rightHeight+1;//加1是root的高度
        }
    }

    @Override
    public Node findKey(int value) {
        return null;
    }

    @Override
    public void preOrderTraverse() {
        System.out.println("先序遍历递归：");
        this.preOrderTraverse(root);
        System.out.println();
    }
    /**
      *@Description 辅助方法，用来执行遍历
      *@Author victor
      *@return
      *@Date 19-6-30 上午3:16
    */
    private void preOrderTraverse(Node root){
        if(root!=null){
            //输出根节点的值
            System.out.print(root.value+" ");
            //遍历左子树
            this.preOrderTraverse(root.leftChild);
            //遍历右子树
            this.preOrderTraverse(root.rightChild);
        }
    }
    @Override
    public void inOrderTraverse() {
        System.out.println("中序遍历递归：");
        this.inOrderTraverse(root);
        System.out.println();
    }
    /**
     *@Description 辅助方法，用来执行遍历
     *@Author victor
     *@return
     *@Date 19-6-30 上午3:16
     */
    private  void inOrderTraverse(Node root) {
        if(root!=null){
            //遍历左子树
            this.inOrderTraverse(root.leftChild);
            //输出根节点的值
            System.out.print(root.value+" ");
            //遍历右子树
            this.inOrderTraverse(root.rightChild);
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.println("后序遍历递归：");
        this.postOrderTraverse(root);
        System.out.println();
    }
    /**
     *@Description 辅助方法，用来执行遍历
     *@Author victor
     *@return
     *@Date 19-6-30 上午3:16
     */
    private void postOrderTraverse(Node root) {
        if(root!=null){
            //遍历左子树
            this.postOrderTraverse(root.leftChild);
            //遍历右子树
            this.postOrderTraverse(root.rightChild);
            //输出根节点的值
            System.out.print(root.value+" ");
        }
    }

    @Override
    public void inOrderByStack() {

    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void levelOrderByQueue() {

    }
}
