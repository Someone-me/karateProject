package servlet.loginJudgement;

import cn.adminLogin.adminLogin;
import cn.adminSetting.adminSetting;
import domain.loginJudgement.logoutSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname=request.getParameter("adminname");
        adminSetting admin=new adminSetting();
        admin.setAdminname(adminname);

        logoutSql logout=new logoutSql();
        logout.setflag(admin);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }

    @Test
    public void test()
    {
        String adminname="周超超";
        adminSetting admin=new adminSetting();
        admin.setAdminname(adminname);

        logoutSql logout=new logoutSql();
        logout.setflag(admin);
    }
}
