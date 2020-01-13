package servlet.juryPanel;

import cn.juryPanel.juryPanel;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.juryPanel.juryPanelSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/allRefereeInfoServlet")
public class allRefereeInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        juryPanelSql jPanel=new juryPanelSql();
        List<juryPanel> info=jPanel.JPanelFindJuryPanel();

        ObjectMapper mapper;
        mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),info);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Test
    public void test() {

        juryPanelSql jPanel=new juryPanelSql();
        List<juryPanel> info=jPanel.JPanelFindJuryPanel();

        System.out.println(info);
    }
}
