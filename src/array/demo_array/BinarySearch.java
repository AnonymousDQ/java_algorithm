package array.demo_array;

/**
 * @ClassName: BinarySearch
 * @Description: 二分查找--数组有序
 * @Author: VictorDan
 * @Date: 19-6-30 上午12:22
 * @Version: 1.0
 **/
public class BinarySearch {
    public static void main(String[] args) {
        //目标数组有序
        int[] arr=new int[]{1,2,3,5,6,7,9,12};
        //目标元素
        int target=9;
        //记录开始位置
        int begin=0;
        //记录结束位置
        int end=arr.length-1;
        //记录中间位置
        int mid=(begin+end)/2;
        //记录目标位置
        int index=-1;
        //循环查找
        while(true){
            //什么情况下没有这个元素？
            //开始位置在结束位置之后
            if(begin>end){
                break;
            }

            //判断中间的这个元素是不是要查找的元素
            if(arr[mid]==target){
                index=mid;
                break;
                //中间这个元素不是要查找的元素
            }else{
                //判断中间这个元素是不是比目标元素大
                if(arr[mid]>target){
                    //把结束位置调整到中间位置前一个位置
                    end=mid-1;
                    //中间元素比目标元素小
                }else{
                    //把开始位置调整到中间位置的后一个位置
                    begin=mid+1;
                }
                //取出新的中间位置
                mid=(begin+end)/2;
            }
        }
        System.out.println("index:"+index+" value:"+arr[index]);
    }
}
