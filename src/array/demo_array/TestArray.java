package array.demo_array;

import java.util.Random;

/**
 * @ClassName: TestArray
 * @Description: Java的数组简单使用
 * @Author: VictorDan
 * @Date: 19-6-29 下午8:39
 * @Version: 1.0
 **/
public class TestArray {
    public static void main(String[] args) {
        //创建一个数组
        int[] arr=new int[10];
        //获取数组的长度
        int length=arr.length;
        System.out.println(length);
        //访问数组中的元素：数组名[下表]  注意：下表从0开始
        int element0=arr[0];
        System.out.println("element0:"+element0);
        //为数组中的元素赋值
        arr[0]=10;
        System.out.println("element0:"+arr[0]);

        Random rd=new Random();
        //遍历数组
        for (int i = 0; i <length ; i++) {
           arr[i]=rd.nextInt(100)+1;
            System.out.println("arr element"+i+":"+arr[i]);
        }
        //创建数组并初始化
        int[] a=new int[]{1,3,5,2,5};
    }
}
