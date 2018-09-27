public class StringTest {
    public static void main(String[] args) {

        String ss=new String("asdasd");

        //获取字符串长度
        ss.length();

        //判断字符串是否为空
        ss.isEmpty();

        //判断字符串是否为null
        boolean b=ss==null;


        //获得某个下标的元素
        char c=ss.charAt(0);

        //获得某下标所在的元素的ascii
        int ascii=ss.codePointAt(0);

        //获得字符串的某段char数组??,参数顺序
        char[] chars=new char[10];
        ss.getChars(0,3,chars,0);

        // 获取字符串的bytes数组
        byte[] bytes=ss.getBytes();
        // 判断2个字符串是否相等 ??
        //比较引用
        boolean b1=ss=="asd";

        //判断2个字符串的值是否相等 ??
        //比较值
        boolean b2=ss.equals("asd");

        //连接字符串，不使用+符号
        String s=ss.concat("123");

        //判断字符串是否匹配正则表达式
        boolean b3=ss.matches("//");

        //将旧字符代替为新字符
        String s1=ss.replace('a','b');

        //判断字符串是否包含某元素
        //错误：参数是string
        boolean b4=ss.contains("asd");

        //以正则表达式分割字符串
        String[] strings=ss.split("//");

        //将某个元素插入到字符串数组中，并合成一个新字符串
        //第一个参数是分隔符，第二个是被插的string数组
        String[] strings1={"asd","asd","asd"};
        String s2=String .join("=",strings1);
        System.out.println(s2);
    }
}
