import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkListTest {
    public static void main(String[] args) {

        //linkedlist先加进来的是队头，后加进来的是队尾
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("asd");
        linkedList.add("qwe");

        //linkedlist转换成数组，需要一个string数组作为参数，才会调用正确的toArray方法，
        //为什么要让这个数组大小是0，因为不确定多大才能装得下，所以这个方法会自己进行比较，不够创建一个新的，所以给个0强制进行新建


        //插入元素

        //删除元素

        //peek poll offer pop push分别是什么意思
        /**
         * peek:
         * poll：
         * offer：
         * pop：
         * push：
         */
        /**
         *如何遍历linkedList，有哪些方法:4种
         * 一般4种遍历都是：
         * 普通for循环
         * 增强for循环
         * 普通Iterator
         * ListIterator
         */


    }
}
