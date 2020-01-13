package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.service.NewsBeanService;
import cn.anhui.karate.service.impl.NewsBeanServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/HomeAssociationNewsServlet")
public class HomeAssociationNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        NewsBeanService service=new NewsBeanServiceImpl();
        //模拟当前是第一页
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage=Integer.parseInt(currentPageStr);
        //int currentPage=1;
        //每页显示10条
        int currentCount=10;
        Map<String, String[]> condition = request.getParameterMap();

        PageBean<NewsBean> pageBean = service.associationNewsSearchPageBean(currentPage,currentCount,condition);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),pageBean);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
