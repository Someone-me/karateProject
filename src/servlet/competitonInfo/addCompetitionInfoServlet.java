package servlet.competitonInfo;

import cn.competitonInfo.competitonInfo;
import cn.competitonInfo.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.competitonInfo.addCompetitionInfoSql;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addCompetitionInfoServlet")
public class addCompetitionInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> map=request.getParameterMap();
        competitonInfo info=new competitonInfo();
        try {
            BeanUtils.populate(info,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        utils.setPq(info);
        addCompetitionInfoSql insert=new addCompetitionInfoSql();
        insert.addCompetitionInfo();

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
