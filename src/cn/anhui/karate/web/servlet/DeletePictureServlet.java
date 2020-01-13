package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.FileBean;
import cn.anhui.karate.service.FileBeanService;
import cn.anhui.karate.service.impl.FileBeanServiceImpl;
import cn.anhui.karate.util.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeletePictureServlet")
public class DeletePictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*FileBean bean=new FileBean();*/
        String idStr=request.getParameter("id");
        FileBeanService service=new FileBeanServiceImpl();
        if(idStr!=null && !idStr.equals("")) {
            int id = Integer.parseInt(idStr);
            FileBean bean=service.findPictureInfo(id);
            FileUtils.delete(bean.getFilepath());
             service.findById(id);
             request.setAttribute("msg","图片删除成功");
             request.getRequestDispatcher("/pictureUpload.jsp").forward(request,response);
           /* response.sendRedirect("pictureSuccess.jsp");*/
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
