package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.domain.PictureBean;
import cn.anhui.karate.service.PictureBeanService;
import cn.anhui.karate.service.impl.PictureBeanServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.Map;

@WebServlet("/MatchPictureShowPageServlet")
public class MatchPictureShowPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PictureBeanService service= new PictureBeanServiceImpl();
        //模拟当前是第一页
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage=Integer.parseInt(currentPageStr);
        //每页显示12条
        int currentCount=4;
        Map<String, String[]> condition = request.getParameterMap();
        PageBean<PictureBean> pageBean= service.matchPictureSearchPageBean(currentPage,currentCount,condition);
        request.setAttribute("pageBean",pageBean);

        request.getRequestDispatcher("/matchPictureCenter.jsp").forward(request,response);
        /*ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),pageBean);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
