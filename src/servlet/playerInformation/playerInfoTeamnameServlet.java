package servlet.playerInformation;

import cn.playerInformation.playerInfoTeamname;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.playerInformation.playerInfoTeamnameSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/playerInfoTeamnameServlet")
public class playerInfoTeamnameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        playerInfoTeamnameSql teamname=new playerInfoTeamnameSql();
        List<playerInfoTeamname> Tname=teamname.PInfoFindteamname();

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),Tname);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }


    @Test
    public void test()
    {
        playerInfoTeamnameSql teamname=new playerInfoTeamnameSql();
        List<playerInfoTeamname> Tname=teamname.PInfoFindteamname();

        System.out.println(Tname);
    }
}
