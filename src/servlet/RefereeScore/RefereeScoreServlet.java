package servlet.RefereeScore;

import cn.RefereeScore.RefereeScore;
import cn.RefereeScore.personalTypeRefereeScore;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.RefereeScore.RefereeScoreSql;
import domain.RefereeScore.personalTypeRefereeScoreSql;
import domain.groupInformation.addPlayerInfoSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/RefereeScoreServlet")
public class RefereeScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");
        String level=request.getParameter("level");
        String typenumber=request.getParameter("typenumber");

        personalTypeRefereeScoreSql info=new personalTypeRefereeScoreSql();
        List<personalTypeRefereeScore> Info=info.PInfoFindtypeRefereeScore(type,level,typenumber);

//        //降序排序
        sort(Info);

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),Info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }

    //降序排序
    public void sort(List<personalTypeRefereeScore> Info) {
        Collections.sort(Info, new Comparator<personalTypeRefereeScore>() {
            @Override
            public int compare(personalTypeRefereeScore o1, personalTypeRefereeScore o2) {

                if (o1.getStatus() > o2.getStatus()) {
                    return 1;
                }
                if (o1.getStatus() == o2.getStatus()) {
                    return 0;
                }
                return -1;
            }
        });

    }
    @Test
    public void test()
    {
        addPlayerInfoSql cinfo=new addPlayerInfoSql();
        cinfo.addPlayerInfo();

        String type="个人型";
        String level="男子成年组(18岁以上)";
        String typenumber="第一套型";
        personalTypeRefereeScoreSql info=new personalTypeRefereeScoreSql();
        List<personalTypeRefereeScore> Info=info.PInfoFindtypeRefereeScore(type,level,typenumber);

//        sort(Info);

        System.out.println(Info);
//        personalTypeRefereeScoreSql info=new personalTypeRefereeScoreSql();
//        List<personalTypeRefereeScore> Info=info.PInfoFindtypeRefereeScore();
//
//        //
//        Collections.sort(Info, new Comparator<personalTypeRefereeScore>() {
//
//            @Override
//            public int compare(personalTypeRefereeScore o1, personalTypeRefereeScore o2) {
//
//                if(o1.getResult()<o2.getResult())
//                {
//                    return 1;
//                }
//                if(o1.getResult()==o2.getResult())
//                {
//                    return 0;
//                }
//                return -1;
//            }
//        });


//        System.out.println(Info);
    }
}
