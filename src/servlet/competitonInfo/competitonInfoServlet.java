package servlet.competitonInfo;

import cn.competitonInfo.competitonInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.competitonInfo.competitonInfoSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/competitonInfoServlet")
public class competitonInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        competitonInfoSql competitonInfoSql=new competitonInfoSql();
        List<competitonInfo> competitonInfo=competitonInfoSql.FindcompetitonInfo();

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(),competitonInfo);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Test
    public void test()
    {
        competitonInfoSql competitonInfoSql=new competitonInfoSql();
        List<competitonInfo> competitonInfo=competitonInfoSql.FindcompetitonInfo();

        System.out.println(competitonInfo);
    }
}
