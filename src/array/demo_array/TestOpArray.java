package array.demo_array;

import java.util.Arrays;

/**
 * @ClassName: TestOpArray
 * @Description: 数组扩容问题
 * @Author: VictorDan
 * @Date: 19-6-29 下午8:47
 * @Version: 1.0
 **/
public class TestOpArray {
    public static void main(String[] args) {
        //解决数组的长度不可变的问题
        int[] arr=new int[]{9,8,2,1};
        //快速查看数组中的元素
        System.out.println(Arrays.toString(arr));

        int target=6;
        //创建一个新的数组，长度是元素组长度+1
        int[] newArr=new int[arr.length+1];
        //把原来数组中的数据全部复制到新数组中
        for (int i = 0; i < arr.length; i++) {
            newArr[i]=arr[i];
        }
        System.out.println(Arrays.toString(newArr));
        //把目标元素放入新数组的最后
        newArr[arr.length]=target;
        //新数组替换原数组
        arr=newArr;
        System.out.println(Arrays.toString(arr));
    }
}
