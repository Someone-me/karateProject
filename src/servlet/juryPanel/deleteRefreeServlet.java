package servlet.juryPanel;

import domain.juryPanel.deleteRefereeSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteRefreeServlet")
public class deleteRefreeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        deleteRefereeSql delete=new deleteRefereeSql();
        delete.deleteRefree(id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
    @Test
    public void test()
    {
        String id="10";
        deleteRefereeSql delete=new deleteRefereeSql();
        delete.deleteRefree(id);
    }
}
