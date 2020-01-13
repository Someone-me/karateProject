package servlet.adminLogin;

import cn.adminLogin.adminLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.adminLogin.adminLoginSql;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {


    private int flag=0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        adminLogin admin=new adminLogin();
        String phonenumber=request.getParameter("phonenumber");
        String password=request.getParameter("password");

        admin.setPhonenumber(phonenumber);

        adminLoginSql adm=new adminLoginSql();
        List<adminLogin> ad=adm.AdminPass();

        for (int i=0;i<ad.size();i++)
        {

            if (phonenumber.equals(ad.get(i).getPhonenumber())&&password.equals(ad.get(i).getPassword()))
            {
                flag=1;
                adm.setflag(admin);

                ObjectMapper mapper=new ObjectMapper();
                mapper.writeValue(response.getOutputStream(),ad);
                break;
            }
        }
        if(flag==0){
            ObjectMapper mapper=new ObjectMapper();
            mapper.writeValue(response.getOutputStream(),null);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Test
    public void test()
    {
        adminLoginSql adm=new adminLoginSql();
        List<adminLogin> ad=adm.AdminPass();
        adminLogin admin=new adminLogin();
        admin.setPhonenumber("13739233301");
        adm.setflag(admin);
    }
}
