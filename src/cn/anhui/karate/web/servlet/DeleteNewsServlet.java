package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.service.NewsBeanService;
import cn.anhui.karate.service.impl.NewsBeanServiceImpl;
import cn.anhui.karate.util.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteNewsServlet")
public class DeleteNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        NewsBeanService service=new NewsBeanServiceImpl();
        if(idStr!=null && !idStr.equals("")){
            int id = Integer.parseInt(idStr);
            NewsBean bean=service.findNewsInfo(id);
            FileUtils.delete(bean.getFilepath());
            service.findNewsById(id);
            request.setAttribute("msg","文件删除成功");
            request.getRequestDispatcher("/newsUpload.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
