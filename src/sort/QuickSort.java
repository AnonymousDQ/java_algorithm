package sort;

import java.util.Random;

/**
 * @ClassName: QuickSort
 * @Description: 快速排序
 * @Author: VictorDan
 * @Date: 19-6-29 下午7:58
 * @Version: 1.0
 **/
/***
 * 需求：快速排序法
 *
 * 步骤：
 * 1、数组第一个值为【基准数】，设置【哨兵i】和【哨兵j】
 * 2、【哨兵j】从左往右找一个大于【基准数】的数，【哨兵i】从右往左找一个小于【哨兵】的数，然后交换他们
 * 3、【基准数】将整个序列分为两组，左边一组小于【基准数】，右边一组大于【基准数】
 * 4、、使用【递归】继续设置【基准数】
 * 5、循环步骤1、步骤2、步骤3、步骤4
 */

import java.util.*;


public class QuickSort
{
    static int process = 0;
    static int data[]=new int[10];
    static int size = data.length;

    public static void main(String args[])
    {
        System.out.println("原始数据是："+Arrays.toString(data)+"\n");
        Random rd=new Random();
        for (int i = 0; i <size ; i++) {
            data[i]=rd.nextInt(100)-1;
        }
        quick(data,size,0,size-1);
        System.out.println("\n排序结果："+Arrays.toString(data));
    }

    //排序
    public static void quick(int d[],int size,int left,int right)
    {
        int i,j,tmp;
        int lf_idx;
        int rg_idx;
        int t;
        //1:第一个键值为d[lf]
        if(left<right)
        {
            lf_idx=left+1;
            rg_idx=right;

            //单次循环内排序
            while(true)
            {

                System.out.print("[处理过程"+(++process)+"]=> "+Arrays.toString(data)+"\n");

                for(i=left+1;i<=right;i++)  //2:由左向右找出一个键值大于d[lf]者
                {
                    if(d[i]>=d[left])
                    {
                        lf_idx=i;
                        break;
                    }
                    lf_idx++;
                }

                for(j=right;j>=left+1;j--)   //3:由右向左找出一个键值小于d[lf]者
                {
                    if(d[j]<=d[left])
                    {
                        rg_idx=j;
                        break;
                    }
                    rg_idx--;
                }

                if(lf_idx<rg_idx)        //4-1:若lf_idx<rg_idx
                {
                    tmp = d[lf_idx];
                    d[lf_idx] = d[rg_idx]; //则d[lf_idx]和d[rg_idx]互换
                    d[rg_idx] = tmp;       //然后继续排序
                }else{
                    break;             //否则跳出排序过程
                }
            }

            //重新设定哨兵，通过递归先将左边排好，再将右边排好
            if(lf_idx>=rg_idx)              //5-1:若lf_idx大于等于rg_idx
            {                               //则将d[lf]和d[rg_idx]互换
                tmp = d[left];
                d[left] = d[rg_idx];
                d[rg_idx] = tmp;
                //5-2:并以rg_idx为基准点分成左右两半
                quick(d,size,left,rg_idx-1); //以递归方式分别为左右两半进行排序
                quick(d,size,rg_idx+1,right); //直至完成排序
            }
        }
    }
}