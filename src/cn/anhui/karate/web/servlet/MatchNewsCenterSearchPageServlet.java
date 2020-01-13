package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.service.NewsBeanService;
import cn.anhui.karate.service.NotificationBeanService;
import cn.anhui.karate.service.impl.NewsBeanServiceImpl;
import cn.anhui.karate.service.impl.NotificationBeanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/MatchNewsCenterSearchPageServlet")
public class MatchNewsCenterSearchPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        NotificationBeanService service=new NotificationBeanServiceImpl();
        //模拟当前是第一页
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage=Integer.parseInt(currentPageStr);
        //int currentPage=1;
        //每页显示10条
        int currentCount=10;
        Map<String, String[]> condition = request.getParameterMap();

        PageBean<NotificationBean> pageBean = service.matchNewsCenterSearchPageBean(currentPage,currentCount,condition);

        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/matchNewsCenter.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
