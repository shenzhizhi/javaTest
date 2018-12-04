package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//继承HttpServlet类，就会把这个类变成Servlet
public class servlet extends HttpServlet  {
//    servlet的生命周期分为3个步骤
//    init()进行初始化，在该servlet第一次被调用时被创建
// service()处理客户端请求，destory()终止，最后由jvm回收

    private  String message;

    public void init() throws ServletException{
        message="我是余健芝";
    }

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        //获取页面中name=name的
        request.getParameter("name");

        out.println("<h1>"+message+"</h1>");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        System.out.println(request.getProtocol());
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("password"));
        //getParameterValues获取多选框数据等
        String []strings=request.getParameterValues("select");
        //https://www.w3cschool.cn/servlet/servlet-client-request.html
        //servlet学习
    }
    public void destory(){
        //asd
    }
}
