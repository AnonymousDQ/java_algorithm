package list.loop_node;

/**
 * @ClassName: LoopNode
 * @Description: 循环链表
 * @Author: VictorDan
 * @Date: 19-6-30 上午1:39
 * @Version: 1.0
 **/
public class LoopNode {
    //结点内容
    int data;
    //下一个结点，也就是它自己
    LoopNode next=this;

    public LoopNode(int data) {
        this.data = data;
    }
    /**
      *@Author victor
      *@Description 插入一个结点作为当前结点的下一个结点
      *@CreateDate 上午1:41 19-6-30
    */
    public void after(LoopNode node){
        //取出下一个结点，作为下下一个结点
        LoopNode nextNode=next;
        //把新节点作为当前结点的下一个结点
        this.next=node;
        //把下下一个结点设置为新节点的下一个结点
        node.next=nextNode;
    }
    /**
      *@Author victor
      *@Description 结点的删除
      *@CreateDate 上午1:46 19-6-30
    */
    public void removeNext(){
        //先取出下下一个结点
        LoopNode newNext=next.next;
        //把下下一个结点设置为当前结点的下一个结点
        this.next=newNext;
    }
    /**
      *@Author victor
      *@Description 控制台打印
      *@CreateDate 上午1:49 19-6-30
    */
    public void show(){
        LoopNode currentNode=this;
        while(true){
            System.out.println(currentNode.data+" ");
            //取出下一个结点
            currentNode=currentNode.next;
            //如果是最后一个结点
            if(currentNode==null){
                break;
            }
        }
    }
}
