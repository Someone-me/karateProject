package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.service.NewsBeanService;
import cn.anhui.karate.service.NotificationBeanService;
import cn.anhui.karate.service.impl.NewsBeanServiceImpl;
import cn.anhui.karate.service.impl.NotificationBeanServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MatchNewsInfoServlet")
public class MatchNewsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = (String) request.getServletContext().getAttribute("id");
        //  String idStr=request.getParameter("id");
        NotificationBeanService service = new NotificationBeanServiceImpl();
        if (idStr != null && !idStr.equals("")) {
            int id = Integer.parseInt(idStr);

            List<NotificationBean> bean = service.findSingleMatchNewsInfo(id);

            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), bean);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
