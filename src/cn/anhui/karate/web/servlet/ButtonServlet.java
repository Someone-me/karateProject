package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.service.NotificationBeanService;
import cn.anhui.karate.service.impl.NotificationBeanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ButtonServlet")
public class ButtonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        NotificationBeanService service=new NotificationBeanServiceImpl();

        /*String condition = request.getParameter("第二届全国青年");*/

        List<NotificationBean> pageBean = service.buttonNews();
        System.out.println(pageBean);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/buttonNewsCenter.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
