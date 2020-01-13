package servlet.loginJudgement;

import cn.loginJudgement.loginJudgement;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.loginJudgement.loginJudgementSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginJudgementServlet")
public class loginJudgementServlet extends HttpServlet {
    private int flag=0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        loginJudgementSql loginsql=new loginJudgementSql();
        List<loginJudgement> login=loginsql.loginJudgement();
        ObjectMapper mapper=new ObjectMapper();
        for(int i=0;i<login.size();i++)
        {
            if(login.get(i).getFlag()==1){
                flag=1;
                mapper.writeValue(response.getOutputStream(),login.get(i));
                break;
            }
        }
        if (flag==0)
        {
            mapper.writeValue(response.getOutputStream(),null);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Test
    public  void test()
    {
        loginJudgementSql loginsql=new loginJudgementSql();
        List<loginJudgement> login=loginsql.loginJudgement();

        for(int i=0;i<login.size();i++)
        {
            System.out.println(login.get(i).getFlag());
        }
        System.out.println(login);
    }
}
