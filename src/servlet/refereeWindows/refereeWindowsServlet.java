package servlet.refereeWindows;

import cn.refereeWindows.refereeWindows;
import domain.refereeWindows.refereeWindowsSql;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/refereeWindowsServlet")
public class refereeWindowsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String,String[]> info=request.getParameterMap();
        refereeWindows score=new refereeWindows();
        try {
            BeanUtils.populate(score,info);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        refereeWindowsSql ad=new refereeWindowsSql();
        ad.addScoreInfo(score);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
