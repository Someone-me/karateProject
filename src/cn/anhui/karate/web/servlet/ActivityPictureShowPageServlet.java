package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.domain.PictureBean;
import cn.anhui.karate.service.PictureBeanService;
import cn.anhui.karate.service.impl.PictureBeanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/ActivityPictureShowPageServlet")
public class ActivityPictureShowPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PictureBeanService service= new PictureBeanServiceImpl();
        //模拟当前是第一页
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage=Integer.parseInt(currentPageStr);
        //每页显示10条
        int currentCount=10;
        Map<String, String[]> condition = request.getParameterMap();
        PageBean<PictureBean> pageBean= service.activityPictureSearchPageBean(currentPage,currentCount,condition);

        request.setAttribute("pageBean",pageBean);
        //request.setAttribute("list",list);
        request.getRequestDispatcher("/activityPictureCenter.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
