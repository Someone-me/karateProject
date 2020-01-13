package servlet.adminSetting;

import domain.adminSetting.deleteAdminInfoSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteInfoServlet")
public class deleteAdminInfoServlet extends HttpServlet {
    private String id;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        id=request.getParameter("id");

        deleteAdminInfoSql deleteAdmin=new deleteAdminInfoSql();
        deleteAdmin.deleteAdminInfo(id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Test
    public void test()
    {
        String id="1";
        deleteAdminInfoSql deleteAdmin=new deleteAdminInfoSql();
        deleteAdmin.deleteAdminInfo(id);
    }
}
