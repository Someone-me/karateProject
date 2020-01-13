package servlet.juryPanel;

import cn.juryPanel.juryPanel;
import cn.juryPanel.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.juryPanel.addRefereeSql;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addRefereeServlet")
public class addRefereeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> map=request.getParameterMap();
        juryPanel juryPanel=new juryPanel();
        try {
            BeanUtils.populate(juryPanel,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        utils.setPq(juryPanel);

        addRefereeSql addRefereeSql=new addRefereeSql();
        addRefereeSql.addReferee();

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),juryPanel);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
