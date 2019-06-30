package tree.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
    /**
      *@Description 辅助方法
      *@Author victor
      *@return 
      *@Date 19-6-30 下午1:55
    */
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
    /**
      *@Description 辅助方法
      *@Author victor
      *@return 
      *@Date 19-6-30 下午5:59
    */
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
        System.out.println("二叉树的查找的value：");
        return this.findKey(value,root);
    }
    /**
      *@Description 辅助方法
      *@Author victor
      *@return
      *@Date 19-6-30 下午12:12
    */
    private Node findKey(int value,Node root){
        if(root==null){//递归条件1：如果树为空，则返回为null
            return null;
        }else if(root!=null&&root.value==value){//递归条件2：可能是二叉树的根节点
            return root;
        }else{//递归体
            //左子树递归查找
            Node leftNode=this.findKey(value,root.leftChild);
            //右子树递归查找
            Node rightNode=this.findKey(value,root.rightChild);
            if(leftNode!=null&&leftNode.value==value){
                return leftNode;
            }else if(rightNode!=null&&rightNode.value==value){
                return rightNode;
            }else{
                return null;
            }
        }
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
    public void preOrderByStack() {
        System.out.println("先序遍历非递归（借助栈）:");
        this.preOrderByStack(root);
        System.out.println();
    }
    /**
      *@Description 辅助方法
      *@Author victor
      *@return 
      *@Date 19-6-30 下午1:54
    */
    private void preOrderByStack(Node root){
        if(root==null){
            return;
        }else{
            //Stack<Node> stack= new Stack<Node>();
            //创建栈，Deque双端队列在java中可以作为栈来使用的，栈操作建议使用它
            Deque<Node> stack=new LinkedList<Node>();
            Node current=root;//用临时操作变量current指向根节点1
            Node temp=null;
            while(current!=null||!stack.isEmpty()){//现在current指向root结点不为空，但是此时stack是等于空的，所以是或者
                stack.push(current);//先把current存起来，根节点1入栈
                current=current.leftChild;//4先出栈
                while(current==null&&!stack.isEmpty()){
                    current=stack.peek();//current每次指向栈顶元素，peek不出栈，只是读取
                    temp=stack.pop();
                    System.out.print(temp.value+" ");
                    current=current.rightChild;
                }
            }
        }
    }
    @Override
    public void inOrderByStack() {
        System.out.println("中序遍历非递归（借助栈）:");
        this.inOrderByStack(root);
        System.out.println();
    }
    /**
      *@Description 辅助方法
     *                          1
     *                         / \
     *                        4   2
     *                        \  / \
     *                         5 3  6
     *                               \
     *                                7
      *@Author victor
      *@return
      *@Date 19-6-30 下午12:50
    */
    private void inOrderByStack(Node root){
        if(root==null){
            return;
        }else{
            //Stack<Node> stack= new Stack<Node>();
            //创建栈，Deque双端队列在java中可以作为栈来使用的，栈操作建议使用它
            Deque<Node> stack=new LinkedList<Node>();
            Node current=root;//用临时操作变量current指向根节点1
            while(current!=null||!stack.isEmpty()){//现在current指向root结点不为空，但是此时stack是等于空的，所以是或者
                while(current!=null){//current不为空
                    stack.push(current);//先把current存起来，根节点1入栈
                    current=current.leftChild;//在把current的左孩子4付给current，此时current指向4
                }//然后在while循环，此时current是4不为空，再把4入栈，也就是左孩子一直找，4没有左孩子了，则执行if判断
                if(!stack.isEmpty()){//此时栈中有4,1
                    current=stack.pop();//4先出栈
                    System.out.print(current.value+" ");
                    current=current.rightChild;//然后在把current的右孩子付给current,此时current指向结点5，然后又到while循环。
                }
            }
        }
    }
    
    @Override
    public void postOrderByStack() {
        System.out.println("后序遍历非递归(借助栈)：");
        this.postOrderByStack(root);
        System.out.println();
    }
    /**
      *@Description 辅助方法
      *@Author victor
      *@return 
      *@Date 19-6-30 下午1:34
    */
    private void postOrderByStack(Node root) {
        if (root == null) {
            return;
        } else {
            //Stack<Node> stack= new Stack<Node>();
            //创建栈，Deque双端队列在java中可以作为栈来使用的，栈操作建议使用它
            Deque<Node> stack = new LinkedList<Node>();
            stack.push(root);
            Node current = null;
            while(!stack.isEmpty()){
                current=stack.peek();//让当前current当前结点，获取栈顶元素但是不出栈
                if(current.leftChild!=null&&root!=current.leftChild&&root!=current.rightChild){
                    stack.push(current.leftChild);//一直让左孩子入栈
                }else if(current.rightChild !=null&&root!=current.rightChild){
                    stack.push(current.rightChild);//一直让右孩子入栈
                }else{
                    System.out.print(stack.pop().value+" ");//最后入栈的一定是根节点，然后每次打印栈顶元素就行
                    root=current;
                }
            }
        }
    }

    @Override
    public void levelOrderByQueue() {
        System.out.println("层次遍历二叉树（借助队列）：");
        this.levelOrderByQueue(root);
        System.out.println();
    }
    /**
      *@Description 辅助方法
     *                                 1
     *      *                         / \
     *      *                        4   2
     *      *                        \  / \
     *      *                         5 3  6
     *      *                               \
     *      *                                7
      *@Author victor
      *@return
      *@Date 19-6-30 下午12:31
    */
    private void levelOrderByQueue(Node root){
        if(root==null){//递归条件1：如果root是一个空树，则结束
            return;
        }else{//循环体
            //使用一个辅助队列，是一个链表结构
            Queue<Node> queue=new LinkedList<Node>();
            queue.add(root);//先让根节点root入队,也就是先把1加进来了，
            while(queue.size()!=0){//把根节点1加进来后，此时队列的size是1，不等于0
                int len=queue.size();//获取这个队列的长度
                for (int i = 0; i < len; i++) {//然后开始循环
                    Node temp=queue.poll();//然后结点出队，付给一个临时的变量temp
                    System.out.print(temp.value+" ");//输出以下temp的值，此时根节点1已经出去了
                    if(temp.leftChild!=null){//如果结点的左孩子不为空，就把左孩子入队
                        queue.add(temp.leftChild);//1的左孩子是4,入队
                    }
                    if(temp.rightChild!=null){//如果结点的右孩子不为空，就把右孩子入队
                        queue.add(temp.rightChild);//1的右孩子是2，入队
                    }
                }
            }
        }
    }
}
