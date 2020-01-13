package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.FileBean;
import cn.anhui.karate.service.FileBeanService;
import cn.anhui.karate.service.impl.FileBeanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdatePictureServlet")
public class UpdatePictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
       String id= request.getParameter("id");
        //调用service完成查询
        FileBeanService service= new FileBeanServiceImpl();
       FileBean bean= service.findPictureById(id);
       request.setAttribute("bean",bean);
       request.getRequestDispatcher("/updatePicture.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
