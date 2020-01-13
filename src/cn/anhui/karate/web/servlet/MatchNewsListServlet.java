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

@WebServlet("/MatchNewsListServlet")
public class MatchNewsListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NotificationBeanService service=new NotificationBeanServiceImpl();
        //模拟当前是第一页
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage=Integer.parseInt(currentPageStr);
        //每页显示2条
        int currentCount=5;
        Map<String, String[]> condition = request.getParameterMap();
        PageBean<NotificationBean> pageBean= service.matchNewsCenterSearchPageBean(currentPage,currentCount,condition);

        request.setAttribute("pageBean",pageBean);
        //request.setAttribute("list",list);
        request.getRequestDispatcher("/matchNewsList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
