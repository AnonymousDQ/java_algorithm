package array;

import java.util.Random;

/**
 * @Description: 数组的插入、删除，按照下标随机访问操作
 * 数组中的数据是int类型的
 * @Author: victordan
 * @CreateDate: 2019/6/19 22:06
 * @UpdateUser: victordan
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Array {
    /**
     * 定义int型数组data保存数据
     */
    public int[] data;
    /**
     * 定义数组的长度
     */
    private int n;
    /**
     * 定义数组中实际的元素个数
     */
    private int count;

    public Array(int capacity){
        this.data=new int[capacity];
        this.n=capacity;
        /**
         * 开始数组一个数也没有添加，所以为0
         */
        this.count=0;
    }

    /**
     * 根据索引index，找到数据元素并返回
     * @param index
     * @return
     */
    public int find(int index){
        if(index<0||index>=count){
            return -1;
        }
        return data[index];
    }

    /**
     * 把value插入到指定index的位置
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index,int value){
        if(count==n){
            System.out.println("数组空间已满，没有可插入的位置！");
            return false;
        }
        if(index<0||index>count){
            System.out.println("插入的位置不合法！");
            return false;
        }
        /**
         * 总共count个数，从count位开始，往后移动1位
         */
        for (int i = count; i >index ; i--) {
            data[i]=data[i-1];
        }
        data[index]=value;
        ++count;
        return true;
    }

    /**
     * 删除指定位置index的元素
     * @param index
     * @return
     */
    public boolean delete(int index){
        if(index<0||index>=count){
            return false;
        }
        /**
         * 从删除的位置index开始，将后面的元素向前移动1位
         */
        for (int i = index+1; i < count; i++) {
            data[i-1]=data[i];
        }
        --count;
        return true;
    }
    public void printAll(){
        for (int i = 0; i < count; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array=new Array(10);
        array.printAll();
        Random rd=new Random();
        for (int i = 0; i < 10; i++) {
            array.insert(i,rd.nextInt(100)+2);
        }
        array.printAll();
    }

}
