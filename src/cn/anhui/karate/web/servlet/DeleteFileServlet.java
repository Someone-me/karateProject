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

@WebServlet("/DeleteFileServlet")
public class DeleteFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        FileBeanService service=new FileBeanServiceImpl();
        if(idStr!=null && !idStr.equals("")) {
            int id = Integer.parseInt(idStr);
            FileBean bean=service.findFileInfo(id);
            FileUtils.delete(bean.getFilepath());
            service.findFileById(id);
            request.setAttribute("msg","文件删除成功");
            request.getRequestDispatcher("/fileUpload.jsp").forward(request,response);
           /* response.sendRedirect("fileSuccess.jsp");*/
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
