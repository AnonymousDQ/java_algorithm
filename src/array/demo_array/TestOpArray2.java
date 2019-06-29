package array.demo_array;

import java.util.Arrays;

/**
 * @ClassName: TestOpArray2
 * @Description: 删除数组中的元素
 * @Author: VictorDan
 * @Date: 19-6-30 上午12:08
 * @Version: 1.0
 **/
public class TestOpArray2 {
    public static void main(String[] args) {
        //目标数组
        int[] arr=new int[]{2,5,3,1,7};
        System.out.println(Arrays.toString(arr));
        //要删除的第3个位置的元素
        int target=3;
        //创建一个新的数组，长度是原数组的长度-1
        int[] newArr=new int[arr.length-1];
        for (int i = 0; i <newArr.length ; i++) {
            //要删除的元素之前的元素
            if (i < target) {
                newArr[i]=arr[i];
             //要删除的元素之后的元素
            }else{
                newArr[i]=arr[i+1];
            }
        }
        //新数组替换为旧数组
        arr=newArr;
        System.out.println(Arrays.toString(arr));
    }
}
