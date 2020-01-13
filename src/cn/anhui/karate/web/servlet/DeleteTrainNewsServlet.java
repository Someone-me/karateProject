package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.service.NotificationBeanService;
import cn.anhui.karate.service.impl.NotificationBeanServiceImpl;
import cn.anhui.karate.util.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteTrainNewsServlet")
public class DeleteTrainNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        NotificationBeanService service=new NotificationBeanServiceImpl();
        if(idStr!=null && !idStr.equals("")){
            int id = Integer.parseInt(idStr);
            NotificationBean bean=service.findTrainNewsInfo(id);
            FileUtils.delete(bean.getFilepath());
            service.findTrainNewsById(id);
            request.setAttribute("msg","文件删除成功");
            request.getRequestDispatcher("/trainNewsUpload.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
