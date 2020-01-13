package servlet.playerInformation;

import cn.playerInformation.playerLevel;
import cn.playerInformation.playerLevelsingle;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.playerInformation.playerLevelSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/playerLevelServlet")
public class playerLevelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        playerLevelSql kilogramclass=new playerLevelSql();
        List<playerLevelsingle> Level= kilogramclass.PInfoFindplayerLevel();

        List<playerLevelsingle> newlevel=new ArrayList<>();

        newlevel.add(Level.get(0));
        for(int i=0;i<Level.size();i++)
        {
            int flag=0;
            playerLevelsingle single=new playerLevelsingle();
            single=Level.get(i);
            for(int j=0;j<newlevel.size();j++)
            {
                if (newlevel.get(j).getLevel().equals(single.getLevel()))
                {
                    flag=1;
                }
            }
            if(flag==0)
            {
                newlevel.add(single);
            }
        }
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),newlevel);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }

    @Test
    public void test()
    {
        playerLevelSql kilogramclass=new playerLevelSql();
        List<playerLevelsingle> Level= kilogramclass.PInfoFindplayerLevel();

        List<playerLevelsingle> newlevel=new ArrayList<>();
        newlevel.add(Level.get(0));
        System.out.println(newlevel.size());
        for(int i=0;i<Level.size();i++)
        {
            int flag=0;
            playerLevelsingle single=new playerLevelsingle();
            single=Level.get(i);
            for(int j=0;j<newlevel.size();j++)
            {
                if (newlevel.get(j).getLevel().equals(single.getLevel()))
                {
                    flag=1;
                }
            }
            if(flag==0)
            {
                newlevel.add(single);
            }
        }
        System.out.println(newlevel.size());
        System.out.println(newlevel);
    }
}
