package servlet.playerInformation;

import cn.playerInformation.playerInfoMatchtype;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.playerInformation.playerInfoMatchtypeSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/playerInfoMatchtypeServlet")
public class playerInfoMatchtypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        playerInfoMatchtypeSql matchtype=new playerInfoMatchtypeSql();
        List<playerInfoMatchtype> Mtype=matchtype.PInfoFindMatchtype();

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),Mtype);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Test
    public void test()
    {
        playerInfoMatchtypeSql matchtype=new playerInfoMatchtypeSql();
        List<playerInfoMatchtype> Mtype=matchtype.PInfoFindMatchtype();

        System.out.println(Mtype);

    }
}
