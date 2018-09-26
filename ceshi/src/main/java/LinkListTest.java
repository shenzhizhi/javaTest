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
        String[] ss=linkedList.toArray(new String[0]);
        for(String s :ss){
            System.out.println(s);
        }
        //插入元素
//        linkedList.add("asd");
        //删除元素
//        linkedList.remove(1);
//        linkedList.remove("asd");
        //peek poll offer pop push分别是什么意思
        /**
         * peek:返回队头
         * poll：删除队头并返回
         * offer：add到队尾，就是单纯的add
         * pop：删除队头并返回
         * push：add到队头
         */
        /**
         *如何遍历linkedList，有哪些方法:4种
         * 一般4种遍历都是：
         * 普通for循环
         * 增强for循环
         * 普通Iterator
         * ListIterator
         */


       /* for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
        for(String s:linkedList){
            System.out.println(s);
        }
        Iterator<String> iterator=linkedList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        ListIterator<String> listIterator=linkedList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }*/
    }
}
