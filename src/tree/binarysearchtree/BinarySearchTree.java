package tree.binarysearchtree;

/**
 * @ClassName: BinarySearchTree
 * @Description: 二叉搜索树
 * @Author: VictorDan
 * @Date: 19-6-29 下午7:09
 * @Version: 1.0
 **/
public class BinarySearchTree {
    private Node tree;
    
    /**
      *@Author victor
      *@Description 查找算法---使用递归方式
      *@CreateDate 下午7:15 19-6-29
    */
    public Node find(int data){
        Node p=tree;
        while(p!=null){
            if(data<p.data){
                p=p.left;
            }else if(data>p.data){
                p=p.right;
            }else{
                return p;
            }
        }
        return null;
    }
    /**
      *@Author victor
      *@Description 插入元素---递归
      *@CreateDate 下午7:19 19-6-29
    */
    public void insert(int data){
        /***
         * 如果tree为空，则新建一个结点Node，让它为根节点tree
         */
        if(tree==null){
            tree=new Node(data);
            return;
        }else{
            /***
             * 如果tree不空，然后用临时变量去操作tree
             */
            Node p=tree;
            while(p!=null){
                /***
                 * 如果data大于根节点p的data域名，且根节点的右子树为空，则新建一个结点称为右子树
                 * 如果右子树不为空，则把p移动到p.right。去递归
                 */
                if(data>p.data){
                    if(p.right==null){
                        p.right=new Node(data);
                        return;
                    }else{
                        p=p.right;
                    }
                }else{
                    if(p.left==null){
                        p.left=new Node(data);
                        return;
                    }else{
                        p=p.left;
                    }
                }
            }
        }
    }
    /**
      *@Author victor
      *@Description 删除--递归
      *@CreateDate 下午7:35 19-6-29
    */
    public void delete(int data){
        /***
         * 用临时变量p指向要删除的结点，首先是指向根节点tree
         */
        Node p=tree;
        /***
         * 用parent来记录p移动过程中的父节点
         */
        Node parent=null;
        /***
         * 如果树不为空，且根节点data不为查找的数据，则循环遍历，移动到指定位置。
         */
        while(p!=null&&p.data!=data){
            parent=p;
            if(data>p.data){
                p=p.right;
            }else{
                p=p.left;
            }
        }
        /***
         * 如果p为null也就是没找到
         */
        if(p==null){
            return;
        }else{
            /***
             * 要删除的结点有两个子结点，也就是它的左右子结点都存在
             */
            if(p.left!=null&&p.right!=null){
                Node minP=p.right;
                //用minparent来表示minP的父节点
                Node minParent=p;
                while(minP.left!=null){
                    minParent=minP;
                    minP=minP.left;
                }
                /***
                 * 将minP的数据替换到p中
                 */
                p.data=minP.data;
                /***
                 * 然后让p移动到minP的位置。然后把minP删除就行
                 */
                p=minP;
                parent=minParent;
            }
            /***
             * 删除的结点是叶子结点，或者只有一个子结点的时候
             */
            Node child;
            if(p.left!=null){
                child=p.left;
            }else if(p.right!=null){
                child=p.right;
            }else{
                child=null;
            }
            /***
             * 删除的是根节点
             */
            if(parent==null){
                tree=child;
            }else if(parent.left==p){
                parent.left=child;
            }else{
                parent.right=child;
            }
        }
    }

    public void display(Node p){
        while(p!=null){
            display(p.left);
            visit(p);
            display(p.right);
        }
        System.out.print(" ");
    }
    public void visit(Node p){
        System.out.print(p.data);
    }
    /**
      *@Author victor
      *@Description 查找最小结点
      *@CreateDate 下午7:36 19-6-29
    */
    public Node findMin(){
        /***
         * 如果tree为空的，就返回空
         */
        if(tree==null){
            return null;
        }else{
            /***
             * 用临时变量指向根节点，然后让p移动到最左子节点，直到它没有左子树为止
             */
            Node p=tree;
            while(p.left!=null){
                p=p.left;
            }
            return p;
        }
    }
    /**
      *@Author victor
      *@Description 查找最大的结点
      *@CreateDate 下午7:41 19-6-29
    */
    public Node findMax(){
        if(tree==null){
            return null;
        }else{
            Node p=tree;
            while(p.right!=null){
                p=p.right;
            }
            return p;
        }
    }

}
