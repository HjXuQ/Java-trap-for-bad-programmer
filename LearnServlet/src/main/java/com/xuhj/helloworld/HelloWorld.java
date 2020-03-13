package com.xuhj.helloworld;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.net.URLEncoder;

public class HelloWorld implements Servlet {
    /**
     * 1. 加载Servlet。当Tomcat第一次访问Servlet的时候，Tomcat会负责创建Servlet的实例
     * 2. 初始化。当Servlet被实例化后，Tomcat会调用init()方法初始化这个对象
     * 3. 处理服务。当浏览器访问Servlet的时候，Servlet 会调用service()方法处理请求
     * 4. 销毁。当Tomcat关闭时或者检测到Servlet要从Tomcat删除的时候会自动调用destroy()方法，让该
     * 实例释放掉所占的资源。一个Servlet如果⻓时间不被使用的话，也会被Tomcat自动销毁
     * 5. 卸载。当Servlet调用完destroy()方法后，等待垃圾回收。如果有需要再次使用这个Servlet，会重
     * 新调用init()方法进行初始化操作。
     * 简单总结:只要访问Servlet，service()就会被调用。init()只有第一次访问Servlet的时候才会被调 用。
     * destroy()只有在Tomcat关闭的时候才会被调用。
     * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
                System.out.println("我被初始化了");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //设置IDea全局的编码格式也就是控制台的编码格式为UTF-8，那么单个文件设置成GBK的话，输出到控制台的乱码的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            //servletRequest.setCharacterEncoding("UTF-8");
           // servletResponse.setCharacterEncoding("UTF-8");
            //servletResponse.setContentType("text/html;charset=UTF-8");
           // servletResponse.getWriter().write("我被访问了啊");
        String name = servletRequest.getParameter("test");
        servletResponse.getWriter().write(name);
        System.out.println(name);
        System.out.println("我被访问了");
        //    转发 /代表的是整个项目名称
        servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest,servletResponse);
        //    重定向 /代表的是webapps目录，需要写项目名称  /LearnServlet/index.jsp
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
            System.out.println("我被销毁了");
    }
}
