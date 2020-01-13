package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.service.NewsBeanService;
import cn.anhui.karate.service.NotificationBeanService;
import cn.anhui.karate.service.impl.NewsBeanServiceImpl;
import cn.anhui.karate.service.impl.NotificationBeanServiceImpl;
import cn.anhui.karate.util.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteMatchNewsServlet")
public class DeleteMatchNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        NotificationBeanService service=new NotificationBeanServiceImpl();
        if(idStr!=null && !idStr.equals("")){
            int id = Integer.parseInt(idStr);
            NotificationBean bean=service.findMatchNewsInfo(id);
            FileUtils.delete(bean.getFilepath());
            service.findMatchNewsById(id);
            request.setAttribute("msg","文件删除成功");
            request.getRequestDispatcher("/matchNewsUpload.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
