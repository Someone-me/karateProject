package servlet.juryPanel;

import cn.juryPanel.juryPanel;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.juryPanel.viewListSql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/displayListServlet")
public class displayListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取名单的id值
        String id=(String)request.getServletContext().getAttribute("id");

        //显示该组的裁判名单
        viewListSql list=new viewListSql();
        List<juryPanel> info=list.viewlist(id);

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),info);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
