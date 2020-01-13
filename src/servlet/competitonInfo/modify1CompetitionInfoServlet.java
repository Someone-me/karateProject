package servlet.competitonInfo;

import cn.competitonInfo.competitonInfo;
import cn.competitonInfo.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.competitonInfo.modify1CompetitionInfoSql;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/modify1CompetitionInfoServlet")
public class modify1CompetitionInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=(String)request.getServletContext().getAttribute("teamId");

//        System.out.println("更新的地方"+id);
        Map<String,String[]> mapper=request.getParameterMap();
        competitonInfo info=new competitonInfo();
        try {
            BeanUtils.populate(info,mapper);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        utils.setP(info);
        modify1CompetitionInfoSql modify=new modify1CompetitionInfoSql();
        modify.addCompetitionInfo(id);

        ObjectMapper map=new ObjectMapper();
        map.writeValue(response.getOutputStream(),info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
