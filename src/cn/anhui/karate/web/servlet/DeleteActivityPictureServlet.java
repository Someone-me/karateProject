package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.PictureBean;
import cn.anhui.karate.service.PictureBeanService;
import cn.anhui.karate.service.impl.PictureBeanServiceImpl;
import cn.anhui.karate.util.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteActivityPictureServlet")
public class DeleteActivityPictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        PictureBeanService service= new PictureBeanServiceImpl();
        if(idStr!=null && !idStr.equals("")){
            int id = Integer.parseInt(idStr);
            PictureBean bean=service.findActivityPictureInfo(id);
            FileUtils.delete(bean.getFilepath());
            service.findActivityPictureById(id);
            request.setAttribute("msg","文件删除成功");
            request.getRequestDispatcher("/activityPictureUpload.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
