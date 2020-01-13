package servlet.playerInformation;

import cn.playerInformation.playerInfoLookup;
import cn.playerInformation.playerInformation;
import cn.playerInformation.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.playerInformation.playerInfoLookupSql;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/playerInfoLookupServlet")
public class playerInfoLookupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String,String[]> map=request.getParameterMap();
        playerInfoLookup player=new playerInfoLookup();
        try {
            BeanUtils.populate(player,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        utils.setLp(player);

        playerInfoLookupSql info=new playerInfoLookupSql();
        List<playerInformation> pInfo=info.playerInfoLookup();

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),pInfo);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Test
    public void test()
    {
        playerInfoLookup player=new playerInfoLookup();
        player.setName("陈");
        utils.setLp(player);

        playerInfoLookupSql info=new playerInfoLookupSql();
        List<playerInformation> pInfo=info.playerInfoLookup();

        System.out.println(pInfo);

    }
}
