public class StringTest {
    public static void main(String[] args) {

        String ss=new String("asdasd");



        //获取字符串长度
        System.out.print("字符串长度：");
        System.out.println(ss.length());

        //判断字符串是否为空
        System.out.print("字符串是否为空");
        System.out.println(ss.isEmpty());

        //判断字符串是否为null
        System.out.print("字符串是否为null");
        System.out.println(ss==null);

        //获得某个下标的元素
        System.out.print("获得某个下标的元素");
        System.out.println(ss.charAt(2));

        //获得某下标所在的元素的ascii
        System.out.print("获得某下标所在的元素的ascii");
        System.out.println(ss.codePointAt(2));

        //获得字符串的某段char数组
        System.out.print("获得字符串的某段char数组");
        char[] chars=new char[100];
        ss.getChars(0,3,chars,0);

        // 获取字符串的bytes数组
        System.out.print("获取字符串的bytes数组");
        byte[] bytes=ss.getBytes();
        for(byte b :bytes){
            System.out.println(b);
        }

        // 判断2个字符串是否相等 ??
        //比较引用
        System.out.print("判断2个字符串是否相等");
        System.out.println(ss=="asdasd");

        //判断2个字符串的值是否相等 ??
        //比较值
        System.out.print("判断2个字符串的值是否相等");
        System.out.println(ss.equals("asdasd"));

        //连接字符串，不使用+符号
        System.out.print("连接字符串，不使用+符号");
        System.out.println(ss.concat("23"));

        //判断字符串是否匹配正则表达式
        System.out.print("判断字符串是否匹配正则表达式");
        System.out.println(ss.matches("//"));

        //将旧字符代替为新字符
        System.out.print("将旧字符代替为新字符");
        System.out.println(ss.replace('a','A'));

        //判断字符串是否包含某元素
        //错误：参数是string
        System.out.print("判断字符串是否包含某元素");
        System.out.println(ss.contains("a"));

        //以正则表达式分割字符串
        System.out.print("以正则表达式分割字符串");
        String[] chars1=ss.split("a");
        System.out.println(chars1.toString());

        //将某个元素插入到字符串数组中，并合成一个新字符串
        //第一个参数是分隔符，第二个是被插的string数组
        System.out.print("将某个元素插入到字符串数组中，并合成一个新字符串");
        String[] aas={"1","2"};
        System.out.println(String.join("=",aas));
    }
}
