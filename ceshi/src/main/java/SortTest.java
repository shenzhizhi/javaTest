
import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;
import java.util.function.UnaryOperator;

public class SortTest {
    public static void main(String[] args) {

        int[] a = {5, 2, 6,4,1,8,7};
//        bubblesort(a);
//        quicksort(a, 0, a.length - 1);
//        insertsort(a);
        selectionsort(a);

        show(a);
    }

    public static void show(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    //1:bubblesort :i j
    //错误：j的范围写错了，j+1的时候超出范围
    public static void bubblesort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

    //2:quicksort : left right
    //错误：left应该右移++，而不是左移--
    //错误2：递归结束条件写反了。。
    //错误3：key值得赋值应该在判断left right的合法性之后，否则有可能溢出
    public static void quicksort(int[] a, int low, int high) {
        int left=low;
        int right=high;
        if(left>=right)return;
        int key=a[left];

        while(left<right){
            while(left<right && a[right]>=key){
                right--;
            }
            if(key>=a[right]){
                a[left]=a[right];
            }
            while(left<right && a[left]<=key){
                left++;
            }
            if(key<=a[left]){
                a[right]=a[left];
            }
        }
        a[left]=key;
        quicksort(a,low,left-1);
        quicksort(a,left+1,high);
    }

    //3:insertsort : leftindex
    //错误：忘记排序原理，忘记双层循环
    public static void insertsort(int[] a) {
        for(int index=1;index<a.length;index++){
            int leftindex=index-1;
            int temp=a[index];
            while(leftindex>=0 && a[leftindex]>temp){
                a[leftindex+1]=a[leftindex];
                leftindex--;
            }
            a[leftindex+1]=temp;
        }
    }

    //4:selectionsort:min
    //错误：移动指针应该不在if判断中
    //min是跟i交换而不是跟j交换，每次都把一个最小的交换到最左边，如果刚好i就是min，就不用交换
    public static void selectionsort(int[] a) {
        for(int i=0;i<a.length;i++){
            int min=i;
            int j=i+1;
            while(j<a.length){
                if(a[j]<a[min]){
                    min=j;
                }
                j++;
            }
            if(min!=i){
                int temp=a[i];
                a[i]=a[min];
                a[min]=temp;
            }

        }
    }
}

