
import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;
import java.util.function.UnaryOperator;

public class SortTest {
    public static void main(String[] args) {

        /**
         *无答案版本号
         * 60144538f6453faa5bf72540fef38b6773ad124b
         */



        int[] a = {5, 2, 6,4,1,8,7};
        bubblesort(a);
//        quicksort(a, 0, a.length - 1);
//        insertsort(a);
//        selectionsort(a);

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

    }

    //2:quicksort : left right
    //错误：left应该右移++，而不是左移--
    //错误2：递归结束条件写反了。。
    //错误3：key值得赋值应该在判断left right的合法性之后，否则有可能溢出
    public static void quicksort(int[] a, int low, int high) {


    }

    //3:insertsort : leftindex
    //错误：忘记排序原理，忘记双层循环
    public static void insertsort(int[] a) {

    }

    //4:selectionsort:min j=i+1
    //错误：移动指针应该不在if判断中
    //min是跟i交换而不是跟j交换，每次都把一个最小的交换到最左边，如果刚好i就是min，
    // 就不用交换，在进行判断大小的时候，如果相等的还进行赋值，那就不是稳定的排序
    //忘记：如果min跟j是同一个说明第一个刚好是最小，那就不用换，提高效率,一趟排序一个数，n个数一共需要排序n-1次
    public static void selectionsort(int[] a) {

    }
}

