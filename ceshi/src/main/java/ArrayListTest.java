import java.util.*;

public class ArrayListTest {


    public static void main(String[] args) {

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Aasd");
        arrayList.add("Cc2wcc");
        arrayList.add("Bbasdb");
        //arraylist怎么转换成数组
        String[] aa=arrayList.toArray(new String[arrayList.size()]);
        //数组怎么转换成arraylist
        List<String> arrayList1= Arrays.asList(aa);
        //增加元素
        arrayList.add("d");
        //删除元素
        arrayList.remove("d");
        //返回2个arraylist的交集
        ArrayList<String> b=new ArrayList<>();
        b.add("a");
//        arrayList.retainAll(b);
        //获取一个无关联的子集,前包含，后不包含
        List<String> son=arrayList.subList(0,1);
        //遍历arraylist的几种方法
        /**
         * for循环，增强for循环，迭代器
         */
        /*for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        for(String s : arrayList){
            System.out.println(s);
        }
        Iterator<String> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        //使用外部比较器进行排序
        arrayList.sort(new ComparatorTest());
        for(String s : arrayList){
            System.out.println(s);
        }
        //synchronizedList虽然一个线程安全的类，但是他依然无法阻止其他线程使用其他方法
        //所以需要在可能导致线程不安全的方法外再套上一层syncharonized方法
        List<String> list=Collections.synchronizedList(arrayList);




    }

}

//外部比较器，<-1升序
class ComparatorTest implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if((int)o1.charAt(0)>(int)o2.charAt(0)){
            return 1;
        }else{
            return -1;
        }
    }
}