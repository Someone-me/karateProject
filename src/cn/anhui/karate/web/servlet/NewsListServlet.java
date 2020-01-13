package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.service.NewsBeanService;
import cn.anhui.karate.service.impl.NewsBeanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/NewsListServlet")
public class NewsListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsBeanService service=new NewsBeanServiceImpl();
        //模拟当前是第一页
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage=Integer.parseInt(currentPageStr);
        //每页显示5条
        int currentCount=5;
        Map<String, String[]> condition = request.getParameterMap();
        PageBean<NewsBean> pageBean = service.newsCenterSearchPageBean(currentPage,currentCount,condition);

        request.setAttribute("pageBean",pageBean);
        //request.setAttribute("list",list);
        request.getRequestDispatcher("/newsList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
