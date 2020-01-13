package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.service.NewsBeanService;
import cn.anhui.karate.service.impl.NewsBeanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateAssociationServlet")
public class UpdateAssociationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取id
        String id= request.getParameter("id");
        //调用service完成查询
        NewsBeanService service=new NewsBeanServiceImpl();
        NewsBean bean= service.findAssociationInfoById(id);
        request.setAttribute("bean",bean);
        request.getRequestDispatcher("/updateAssociation.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
