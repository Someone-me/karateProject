package servlet.competitonInfo;

import cn.competitonInfo.saveId;
import cn.competitonInfo.utils;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyCompetitionInfoServlet")
public class modifyCompetitionInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        request.getServletContext().setAttribute("teamId",id);
        request.getRequestDispatcher("modify_CompetitionInfoServlet").forward(request,response);
        request.getRequestDispatcher("modify1CompetitionInfoServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
