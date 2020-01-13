package servlet.RefereeScore;

import cn.RefereeScore.teamTypeRefereeScore;
import domain.RefereeScore.teamTypeRefereeScoreSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teamTypeRefereeScoreServlet")
public class teamTypeRefereeScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }

    @Test
    public void test()
    {
        teamTypeRefereeScoreSql info=new teamTypeRefereeScoreSql();
        List<teamTypeRefereeScore> Info=info.findteamTypeRefereeScore1();

        System.out.println(Info);
    }
}
