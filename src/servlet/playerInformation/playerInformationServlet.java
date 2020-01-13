package servlet.playerInformation;

import cn.playerInformation.playerInfoCombine;
import cn.playerInformation.playerInfoQuery;
import cn.playerInformation.playerInformation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/playerInformationServlet")
public class playerInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



       domain.playerInformation.playInfomationSql Player= new domain.playerInformation.playInfomationSql();
       List<playerInfoCombine> playInfo=Player.PInfoFindPlayer();

        //将info序列化成json
        ObjectMapper mapper;
        mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),playInfo);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }

    @Test
    public void test()
    {
        domain.playerInformation.playInfomationSql Player= new domain.playerInformation.playInfomationSql();
        List<playerInfoCombine> playInfo=Player.PInfoFindPlayer();

        System.out.println(playInfo);
    }


}
