package servlet.adminSetting;

import cn.adminSetting.adminSetting;
import domain.adminSetting.adminSettingSql;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import cn.adminSetting.utils;

@WebServlet("/addAdminServlet")
public class adminSettingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String,String[]> map= request.getParameterMap();
        adminSetting admin=new adminSetting();
        try {
            BeanUtils.populate(admin, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        utils.setPq(admin);

        adminSettingSql adminSetting=new adminSettingSql();
        adminSetting.ASettingAdd();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
