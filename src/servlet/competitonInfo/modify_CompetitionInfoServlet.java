package servlet.competitonInfo;

import cn.competitonInfo.competitonInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.competitonInfo.competitonInfoSql;
import domain.competitonInfo.modifyCompetitionInfoSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/modify_CompetitionInfoServlet")
public class modify_CompetitionInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String id=(String)request.getServletContext().getAttribute("teamId");


        modifyCompetitionInfoSql info=new modifyCompetitionInfoSql();
        List<competitonInfo> Info=info.modifyCompetitionInfo(id);


        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),Info);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }


}
