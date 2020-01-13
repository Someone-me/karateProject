package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.domain.VideoBean;
import cn.anhui.karate.service.NotificationBeanService;
import cn.anhui.karate.service.VideoBeanService;
import cn.anhui.karate.service.impl.NotificationBeanServiceImpl;
import cn.anhui.karate.service.impl.VideoBeanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/VideoInfoListServlet")
public class VideoInfoListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        VideoBeanService service=new VideoBeanServiceImpl();
        //模拟当前是第一页
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage=Integer.parseInt(currentPageStr);
        //每页显示10条
        int currentCount=10;
        Map<String, String[]> condition = request.getParameterMap();

        PageBean<VideoBean>  pageBean = service.findVideoPageBean(currentPage,currentCount,condition);

        request.setAttribute("pageBean",pageBean);
        //request.setAttribute("list",list);
        request.getRequestDispatcher("/videoList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
