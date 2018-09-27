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
        linkedList.add("zxc");

        //linkedlist转换成数组，需要一个string数组作为参数，才会调用正确的toArray方法，
        //为什么要让这个数组大小是0，因为不确定多大才能装得下，所以这个方法会自己进行比较，不够创建一个新的，所以给个0强制进行新建
        String[] strings=linkedList.toArray(new String[0]);

        //插入元素
        linkedList.add("zxc");
        //删除元素
        linkedList.remove(2);


        //peek poll offer pop push分别是什么意思
        /**
         * peek/element:都可以返回队头，在队列为空时，peek返回null，element抛异常
         * poll/remove/pop：都是返回队头并删除，在队列为空时，poll返回null，remove抛异常,pop跟remove是相同的实现
         * offer/add：新增元素到队尾，当队列为空时，offer返回false，add抛异常
         * push：新增元素到队头
         */
        //返回队头
        System.out.println(linkedList.peek());
        System.out.println(linkedList.element());

        //返回队头并删除
        System.out.println(linkedList.poll());

        //新增元素到队尾
        System.out.println(linkedList.add("123"));
        System.out.println(linkedList.offer("234"));

        //新增元素到队头
        linkedList.push("345");

        /**
         *如何遍历linkedList，有哪些方法:4种
         * 一般4种遍历都是：
         * 普通for循环
         * 增强for循环
         * 普通Iterator
         * ListIterator
         */
        for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
        for(String s : linkedList){
            System.out.println(s);
        }
        Iterator<String> iterator=linkedList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        ListIterator<String> listIterator=linkedList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

    }
}
