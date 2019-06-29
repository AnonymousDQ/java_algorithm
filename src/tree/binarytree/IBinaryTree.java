package tree.binarytree;

/**
 * @ClassName: IBinaryTree
 * @Description: 二叉树的方法接口，可以有不同的实现类，每个类可使用不同的存储结构，比如是：顺序存储，链式结构
 * @Author: VictorDan
 * @Date: 19-6-30 上午2:22
 * @Version: 1.0
 **/
public interface IBinaryTree {
    /**
      *@Description 是否为空红
      *@Author victor
      *@return 
      *@Date 19-6-30 上午2:24
    */
    public boolean isEmpty();
    /**
      *@Description 树结点数量
      *@Author victor
      *@return 
      *@Date 19-6-30 上午2:24
    */
    public int size();
    /**
      *@Description 获取二叉树高度
      *@Author victor
      *@return 
      *@Date 19-6-30 上午2:24
    */
    public int getHeight();
    /**
      *@Description 查询指定值的结点
      *@Author victor
      *@return 
      *@Date 19-6-30 上午2:25
    */
    public Node findKey(int value);
    /**
      *@Description 前序递归遍历
      *@Author victor
      *@return 
      *@Date 19-6-30 上午2:26
    */
    public void preOrderTraverse();
    /**
      *@Description 中序递归遍历
      *@Author victor
      *@return 
      *@Date 19-6-30 上午2:27
    */
    public void inOrderTraverse();
    /**
      *@Description 后序递归遍历
      *@Author victor
      *@return 
      *@Date 19-6-30 上午2:27
    */
    public void postOrderTraverse();
    /**
      *@Description 中序遍历非递归操作
     * 1、对于任意结点current,如果该节点不为空，则将该节点压入栈，并将左子树结点置为current，重复此操作
     * 2、如果左子树为空,栈顶结点出栈，将该节点的右子树结点置为current
     * 3、重复1,2操作，直到current为空且栈内结点为空
      *@Author victor
      *@return
      *@Date 19-6-30 上午2:28
    */
    public void inOrderByStack();
    /**
      *@Description 前序遍历非递归操作
     * 1、对于任意结点current，如果该结点不为空则访问该节点后再将结点压入栈中，并将左子树结点置为current，重复此操作
     * 2、如果左子树为空，取栈顶结点的右子树置为current
     * 3、重复1,2步骤，直到current为空且栈内结点为空
      *@Author victor
      *@return
      *@Date 19-6-30 上午2:32
    */
    public void preOrderByStack();
    /**
      *@Description 后序遍历非递归
     * 1、对于任意结点current，如果该结点不为空，则访问该节点再将结点压入栈，并将左子树结点置为current，重复此操作
     * 2、如果左子树为空，取栈顶结点的右子树则。如果右子树为空或者右子树刚访问过，则访问该结点，然后将preNode置为该节点
     * 3、重复1,2步骤，直到current为空且栈内结点为空
      *@Author victor
      *@return
      *@Date 19-6-30 上午2:36
    */
    public void postOrderByStack();
    /**
      *@Description 层次遍历借助队列实现
      *@Author victor
      *@return 
      *@Date 19-6-30 上午2:40
    */
    public void levelOrderByQueue();
}
