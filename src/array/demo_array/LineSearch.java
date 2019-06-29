package array.demo_array;

/**
 * @ClassName: LineSearch
 * @Description: 线性查找
 * @Author: VictorDan
 * @Date: 19-6-30 上午12:19
 * @Version: 1.0
 **/
public class LineSearch {
    private int[] arr;
    public int lineSearch(int target){
        for (int i = 0; i <arr.length ; i++) {

        }
        return -1;
    }
    public static void main(String[] args) {
        //目标数组
        int[] arr=new int[]{2,3,5,1,6,34,23,63};
        //目标元素
        int target=23;
        //目标元素所在的下标
        int index=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                index=i;
                break;
            }
        }
        //打印下标
        System.out.println("index:"+index);
    }
}
