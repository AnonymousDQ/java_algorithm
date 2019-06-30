package array;

/**
 * @ClassName: BinarySearch
 * @Description: 二分查找
 * @Author: VictorDan
 * @Date: 19-6-30 下午5:51
 * @Version: 1.0
 **/
public class BinarySearch {
    /**
      *@Description 不用递归的方式实现二分查找
     * T(n)=O(logN)时间复杂度
     * S(n)=O(1)空间复杂度
      *@Author victor
      *@return 
      *@Date 19-6-30 下午5:55
    */
    public static int binarySearch(int[] array,int key){
        //指定low和high
        int low=0;
        int high=array.length-1;
        //折半查找
        while(low<=high){
            //求得mid
            int mid=(low+high)/2;
            if(key==array[mid]){
                return mid;
            }else if(key>array[mid]){
                low=mid+1;
            }else{//key<array[mid]
                high=mid-1;
            }
        }
        return -1;
    }
    /**
      *@Description 使用递归的方式二分查找
     * T(n)=O(logN)
     * s(n)=O(logN)
      *@Author victor
      *@return
      *@Date 19-6-30 下午6:02
    */
    public static int binarySearch(int[] array,int key,int low,int high){
        //递归的结束条件
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(key==array[mid]){
            return mid;
        }else if(key<array[mid]){
            return binarySearch(array,key,low,mid-1);
        }else{//key>array[mid]
            return binarySearch(array,key,mid+1,high);
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10};
        int key=10;
        int index=binarySearch(arr,key);
        if(index==-1){
            System.out.println("非递归二分查找的不存在！");
        }else{
            System.out.println("非递归二分查找的数据位置为:"+index);
        }

        int index1=binarySearch(arr,key,0,arr.length);
        if(index1==-1){
            System.out.println("递归二分查找的不存在！");
        }else{
            System.out.println("递归二分查找的数据位置为:"+index);
        }
    }
}
