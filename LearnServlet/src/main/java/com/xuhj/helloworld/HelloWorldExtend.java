package com.xuhj.helloworld;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * Servlet是单例模式的
 * 浏览器多次对Servlet的请求，一般情况下，服务器只创建一个Servlet对象，也就是说，Servlet对象一 旦创建了，就会驻留在内存中，为后续的请求做服务，直到服务器关闭。
 * 2.3.2 每次访问请求对象和响应对象都是新的
 * 对于每次访问请求，Servlet引擎都会创建一个新的HttpServletRequest请求对象和一个新的 HttpServletResponse响应对象，然后将这两个对象作为参数传递给它调用的Servlet的service()方 法，service方法再根据请求方式分别调用doXXX方法。
 * 2.3.3 线程安全问题 当多个用户访问Servlet的时候，服务器会为每个用户创建一个线程。当多个用户并发访问Servlet共享
 * 资源的时候就会出现线程安全问题。 原则:
 * 1. 如果一个变量需要多个用户共享，则应当在访问该变量的时候，加同步机制synchronized (对象) {}
 * 2. 如果一个变量不需要共享，则直接在 doGet() 或者 doPost()定义.这样不会存在线程安全问题
 * <p>
 * 在web应用中，所有的请求都是访问的Servlet，动态资源也是，静态资源是怎么处理的呢？
 * 无论在web中访问什么资源【包括JSP】，都是在访问Servlet。没有手工配置缺省Servlet的时 候，你访问静态图片，静态网⻚，缺省Servlet会在你web站点中寻找该图片或网⻚，如果有就返回给 浏览器，没有就报404错误
 */
public class HelloWorldExtend extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletConfig 通过此对象可以获取web.xml中配置的参数
        //获取当前servlet的对象
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig.getInitParameter("xuhj"));
        //ServletContext对象
        //当Tomcat启动的时候，就会创建一个ServletContext对象。它代表着当前web站点 4.2 ServletContext有什么用?
        //1. ServletContext既然代表着当前web站点，那么所有Servlet都共享着一个ServletContext对象， 所以Servlet之间可以通过ServletContext实现通讯。
        //2. ServletConfig获取的是配置的是单个Servlet的参数信息，ServletContext可以获取的是配置整个 web站点的参数信息
        //3. 利用ServletContext读取web站点的资源文件
        //4. 实现Servlet的转发【用ServletContext转发不多，主要用request转发】
        ServletContext servletContext = this.getServletContext();
        //读取资源文件，
        // 注意的是这个路径要和web下的目录对应起来，这个适用的场景就是当图片和类在一个包下的时候，如果资源文件在web目录下，那么直接写文件名就可以
        //第二中方法就是用类加载器去加在，比如说我的文件放在了src目录之下，就得用类加载器了原则:如果文件太大，就不能用类装载器的方式去读取，会导致内存溢出
        /**
         * InputStream inputStream = servletContext.getResourceAsStream("/WEB- INF/classes/zhongfucheng/web/1.png");
         *         ClassLoader classLoader = HelloWorldExtend.class.getClassLoader();
         *         InputStream inputStream1  = classLoader.getResourceAsStream("包名路径+文件名称即可");
         * */
        /**
         * Cookie 不可跨域名特性
         * 服务器给浏览器的，然后浏览器会自动保存，发送的时候会带上Cookie给服务器
         *
         * */
        Cookie cookie = new Cookie("name", URLEncoder.encode("中文","utf-8"));
        cookie.setMaxAge(2000);
        response.addCookie(cookie);
        Cookie[] cookies = request.getCookies();
        for(Cookie coo : cookies){
            String name = coo.getName();
            String val = URLEncoder.encode(coo.getValue(),"utf-8");
        }



    }
}
