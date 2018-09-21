
import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;
import java.util.function.UnaryOperator;

public class SortTest {
    public static void main(String[] args) {
//        ArrayList<Integer> s1=new ArrayList<>();
//        s1.add(1);
//        s1.add(2);
//        s1.add(3);
//
//        ArrayList<Integer> s2 =new ArrayList<>();
//        s2.add(2);
//
//        s1.removeAll(s2);
//        for(Integer i : s1){
//            System.out.println(i);
//        }
//        System.out.println(s1.retainAll(s2));
//
//        ListIterator<Integer> ls=s1.listIterator();
//        Iterator<Integer> ii=s1.iterator();
//
//        ArrayList<Integer> s3=(ArrayList<Integer>) s1.subList(1,2);
//
//        s1.removeIf(Integer -> Integer>3);
//
//        s1.forEach(Integer -> System.out.println(Integer));
//
//        s1.sort(new MyComparator());
//        for(Integer i:s1){
//            System.out.println(i);
//        }

        //插入排序
//        int []a ={2,3,1,5,2};
//        insertsort(a);&& a[min]<a[j]
//        show(a);


        //快速排序
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
            for(int j=0;j<a.length-1;j++){
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
            while(left<right && key<=a[right]){
                right--;
            }
            if(key>=a[right]){
                a[left]=a[right];
            }
            while(left<right && key >=a[left]){
                left++;
            }
            if(key <=a[left]){
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
            while(leftindex>=0 && temp<=a[leftindex]){
                a[leftindex+1]=a[leftindex];
                leftindex--;
            }
            a[leftindex+1]=temp;
        }

    }

    //4:selectionsort:min
    //错误：移动指针应该不在if判断中
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
            if(min !=i){
                int temp=a[i];
                a[i]=a[min];
                a[min]=temp;
            }

        }
    }
}







/*
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        int result;
        if (o1 > o2) {
            result = -1;
        } else if (o1 == o2) {
            result = 0;
        } else {
            result = 1;
        }
        return result;
    }
}*/
