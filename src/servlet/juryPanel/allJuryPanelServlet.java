package servlet.juryPanel;

import cn.juryPanel.juryPanel;
import cn.juryPanel.refereePanel;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.juryPanel.juryPanelSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allJuryPanelServlet")
public class allJuryPanelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        juryPanelSql jPanel=new juryPanelSql();
        List<refereePanel> panel=jPanel.JPanelFindRefereePanel();

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),panel);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }

    @Test
    public void test()
    {
        juryPanelSql jPanel=new juryPanelSql();
        List<refereePanel> panel=jPanel.JPanelFindRefereePanel();

        System.out.println(panel);
    }
}
