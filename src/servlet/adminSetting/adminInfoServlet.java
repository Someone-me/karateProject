package servlet.adminSetting;

import cn.adminSetting.adminSetting;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.adminSetting.adminInfoSql;
import domain.adminSetting.adminSettingSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminInfoServlet")
public class adminInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adminInfoSql adminset=new adminInfoSql();
        List<adminSetting> admin=adminset.AdminInfo();

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),admin);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Test
    public void test()
    {
        adminInfoSql adminset=new adminInfoSql();
        List<adminSetting> admin=adminset.AdminInfo();

        System.out.println(admin);
    }
}
