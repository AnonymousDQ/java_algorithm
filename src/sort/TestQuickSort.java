package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: TestQuickSort
 * @Description: 快速排序=冒泡+分治+递归
 *
 * @Author: VictorDan
 * @Date: 19-6-30 下午6:27
 * @Version: 1.0
 **/
public class TestQuickSort {
    /**
      *@Description 分区方法
      *@Author victor
      *@return 
      *@Date 19-6-30 下午6:55
    */
    private static int partition(int[] arr,int low,int high){
        //指定左指针i和右指针j
        int i=low;
        int j=high;
        //将第一个数作为基准值，挖坑,把最左边的坑挖了，当然是先动j从右向左移动
        int x=arr[low];
        //使用循环实现分区操作
        while(i<j){
            //1、从右向左移动j，找到第一个小于基准值x的值arr[j]
            while(arr[j]>=x&&i<j){
                j--;
            }
            //2、将右侧找到的小于基准值x加入到左边的位置，然后i++，向右边移动一个位置
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            //3、从左向右移动i，找到第一个大于等于基准值x的值arr[i]
            while(arr[i]<x&&i<j){//因为找的是第一个大于等于x的，所以arr[i]就小于x然后一直动
                i++;
            }
            //4、将左侧找到的大于等于基准值的值加入到右边的位置，右指针向左间移动一个位置j--
            if(i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        //使用基准值填坑，这就是基准值的最终位置
        arr[i]=x;//arr[j]=x;此时就是i，j位置索引重合的时候的位置
        //返回基准值的位置索引
        return i;//return j也可以
    }
    /**
      *@Description 快速排序
     * 快速排序在最坏的的情况下的T(n)=O(n^2)
     * T(n)=O(NlogN)
     * S(n)=O(logN),因为使用了递归
     * 如果序列中有相同的元素，则可能前面会跑到后边，快速排序不稳定
      *@Author victor
      *@return
      *@Date 19-6-30 下午6:56
    */
    private static void quickSort(int[] arr,int low,int high){
        if(low<high){//递归结束条件
            System.out.print("[处理过程"+"]=> "+Arrays.toString(arr)+"\n");
            //分区操作，将一个数组分成两个分区，返回分区界限索引
            int index=partition(arr,low,high);
            //对左分区进行快排
            quickSort(arr,low,index-1);
            //对右分区进行快排
            quickSort(arr,index+1,high);
        }
    }
    public static void quickSort(int[] arr){
        int low=0;
        int high=arr.length-1;
        quickSort(arr,low,high);
    }

    public static void main(String[] args) {
        int[] arr=new int[10];
        Random rd=new Random();
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=rd.nextInt(100)-1;
        }
        System.out.println("排序之前的数组顺序：");
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        //partition(arr,0,arr.length-1);//执行的分区操作
        System.out.println("快速排序之后的数组顺序：");
        System.out.println(Arrays.toString(arr));
    }
}
