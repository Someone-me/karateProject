package servlet.playerInformation;

import cn.playerInformation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.playerInformation.playInfomationSql;
import domain.playerInformation.playerInfoQuerySql;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static sun.audio.AudioPlayer.player;

@WebServlet("/playInfoQueryServlet")
public class playInfoQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String teamname = request.getParameter("teamname");
        String type = request.getParameter("type");
        String level = request.getParameter("level");

        System.out.println(level+"aaaa");
        playInfomationSql find = new playInfomationSql();
        List<playerInfoCombine> all = find.PInfoFindPlayer();

        List<playerInfoCombine> info = new ArrayList<>();

        if (!teamname.equals("队名") && !type.equals("比赛类型") && !level.equals("比赛级别")) {
            for (int i = 0; i < all.size(); i++) {
                if (teamname.equals(all.get(i).getPlayerGroup()) && type.equals(all.get(i).getLevelType()) && level.equals(all.get(i).getLevel())) {
                    info.add(all.get(i));
                }
            }
        } else if (teamname.equals("队名") && !type.equals("比赛类型") && !level.equals("比赛级别")) {
            for (int i = 0; i < all.size(); i++) {
                if (type.equals(all.get(i).getLevelType()) && level.equals(all.get(i).getLevel())) {
                    info.add(all.get(i));
                }
            }
        } else if (!teamname.equals("队名") && type.equals("比赛类型") && !level.equals("比赛级别")) {
            for (int i = 0; i < all.size(); i++) {
                if (teamname.equals(all.get(i).getPlayerGroup()) && level.equals(all.get(i).getLevel())) {
                    info.add(all.get(i));
                }
            }
        } else if (!teamname.equals("队名") && !type.equals("比赛类型") && level.equals("比赛级别")) {
            for (int i = 0; i < all.size(); i++) {
                if (teamname.equals(all.get(i).getPlayerGroup()) && type.equals(all.get(i).getLevelType())) {
                    info.add(all.get(i));
                }
            }
        } else if (teamname.equals("队名") && type.equals("比赛类型") && !level.equals("比赛级别")) {
            for (int i = 0; i < all.size(); i++) {
                if (level.equals(all.get(i).getLevel())) {
                    info.add(all.get(i));
                }
            }
        } else if (!teamname.equals("队名") && type.equals("比赛类型") && level.equals("比赛级别")) {
            for (int i = 0; i < all.size(); i++) {
                if (teamname.equals(all.get(i).getPlayerGroup())) {
                    info.add(all.get(i));

                }
            }
        } else if (teamname.equals("队名") && !type.equals("比赛类型") && level.equals("比赛级别")) {
            for (int i = 0; i < all.size(); i++) {
                if (type.equals(all.get(i).getLevelType())) {
                    info.add(all.get(i));
                }
            }
        }
        else
        {
            info = null;
        }
        if(info.size()==0)
        {
            info=null;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), info);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Test
    public void test() {
        String teamname="队名";
        String type="个人组手";
        String level="比赛级别";
        playInfomationSql find = new playInfomationSql();
        List<playerInfoCombine> all = find.PInfoFindPlayer();

        String Tname="队名";
        String Type="比赛类型";
        String Level="比赛级别";

        System.out.println(all);
        List<playerInfoCombine> info = new ArrayList<>();

        if (!teamname.equals(Tname) && !type.equals(Type) && !level.equals(Level)) {
            System.out.println("1111111111111111");
            for (int i = 0; i < all.size(); i++) {
                System.out.println("aaaaaaaaaaaaaa");
                if (teamname.equals(all.get(i).getPlayerGroup()) && type.equals(all.get(i).getLevelType()) && level.equals(all.get(i).getLevel())) {
                    info.add(all.get(i));
                    System.out.println("1111111111111111");
                }
            }
        } else if (teamname.equals("队名") && !type.equals("比赛类型") && !level.equals("比赛级别")) {
            System.out.println("22222222222222222");
            for (int i = 0; i < all.size(); i++) {
                if (type.equals(all.get(i).getLevelType()) && level.equals(all.get(i).getLevel())) {
                    info.add(all.get(i));
                    System.out.println("22222222222222222");
                }
            }
        } else if (!teamname.equals("队名") && type.equals("比赛类型") && !level.equals("比赛级别")) {
            System.out.println("333333333333333333");
            for (int i = 0; i < all.size(); i++) {
                if (teamname.equals(all.get(i).getPlayerGroup()) && level.equals(all.get(i).getLevel())) {
                    info.add(all.get(i));
                    System.out.println("333333333333333333");
                }
            }
        } else if (!teamname.equals("队名") && !type.equals("比赛类型") && level.equals("比赛级别")) {
            System.out.println("4444444444444444444444");
            for (int i = 0; i < all.size(); i++) {
                if (teamname.equals(all.get(i).getPlayerGroup()) && type.equals(all.get(i).getLevelType())) {
                    info.add(all.get(i));
                    System.out.println("4444444444444444444444");
                }
            }
        } else if (teamname.equals("队名") && type.equals("比赛类型") && !level.equals("比赛级别")) {
            System.out.println("555555555555555555555");
            for (int i = 0; i < all.size(); i++) {
                if (level.equals(all.get(i).getLevel())) {
                    info.add(all.get(i));
                    System.out.println("555555555555555555555");
                }
            }
        } else if (!teamname.equals("队名") && type.equals("比赛类型") && level.equals("比赛级别")) {
            System.out.println("6666666666666666666");
            for (int i = 0; i < all.size(); i++) {
                if (teamname.equals(all.get(i).getPlayerGroup())) {
                    info.add(all.get(i));
                    System.out.println("6666666666666666666");
                }
            }
        } else if (teamname.equals("队名") && !type.equals("比赛类型") && level.equals("比赛级别")) {
            System.out.println("777777777777777777777");
            for (int i = 0; i < all.size(); i++) {
                if (type.equals(all.get(i).getLevelType())) {
                    info.add(all.get(i));
                    System.out.println("777777777777777777777");
                }
            }
        }
        else
        {
            info = null;
            System.out.println("88888888888888888888888888");
        }
        System.out.println(info);
    }

}
