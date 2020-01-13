package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.FileBean;
import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.service.FileBeanService;
import cn.anhui.karate.service.impl.FileBeanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/FileListServlet")
public class FileListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileBeanService service=new FileBeanServiceImpl();
        //模拟当前是第一页
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage=Integer.parseInt(currentPageStr);
        //每页显示10条
        int currentCount=10;
        Map<String, String[]> condition = request.getParameterMap();
        PageBean<FileBean> pageBean= service.findPageBean(currentPage,currentCount,condition);

        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/fileList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
