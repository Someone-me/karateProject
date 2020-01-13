package servlet.juryPanel;

import domain.juryPanel.deletePanelSql;
import org.junit.Test;
import service.juryPanelService.juryPanelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePanelServlet")
public class deletePanelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Id=request.getParameter("id");

        deletePanelSql delete=new deletePanelSql();
        delete.deletePanel(Id);
        //把裁判状态清零（该为待分组）
        juryPanelService clear=new juryPanelService();
        int id=Integer.parseInt(Id);
        clear.clearing(id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Test
    public void test()
    {
        juryPanelService clear=new juryPanelService();
//        int id=Integer.parseInt(Id);
        clear.clearing(15);
    }
}
