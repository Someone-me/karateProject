package servlet.communityInfo;

import cn.communityInfo.communityInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.communityInfo.communityInfoSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/communituInfoServlet")
public class communityInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        communityInfoSql info=new communityInfoSql();
        List<communityInfo> Info=info.FindcommunityInfo();

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),Info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }


    @Test
    public void test()
    {
        communityInfoSql info=new communityInfoSql();
        List<communityInfo> Info=info.FindcommunityInfo();

        System.out.println( Info);
    }
}
