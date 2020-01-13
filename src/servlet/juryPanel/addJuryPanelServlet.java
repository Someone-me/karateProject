package servlet.juryPanel;

import cn.juryPanel.juryPanel;
import domain.juryPanel.addRefereePanelSql;
import domain.juryPanel.juryPanelSql;
import domain.juryPanel.setPanelStatusSql;
import org.junit.Test;
import service.juryPanelService.juryPanelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addJuryPanelServlet")
public class addJuryPanelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String position=request.getParameter("position");
    String refereenumber=request.getParameter("refereeNumber");


    int number=Integer.parseInt(refereenumber);
    int flag;
    juryPanelSql allinfo=new juryPanelSql();
    List<juryPanel> panel =new ArrayList<>();
    //找出所有的裁判信息
        panel=allinfo.JPanelFindJuryPanel();
        int n=0;
        for (int i=0;i<panel.size();i++)
        {
            if(panel.get(i).getStatus()==0)
            {
                n++;
            }
        }
        //判断待分组的裁判数量是否够需求
        if(n>number)
        {
            //把小组信息存入并找到该小组的唯一id值
            addRefereePanelSql info=new addRefereePanelSql();
            int id=info.addRefereePanel(position,refereenumber);


            //给小组设置状态位为1，为了在前端判断该小组裁判是否时忙碌。
            setPanelStatusSql set=new setPanelStatusSql();
            set.setPanelStatus(id,1);

            //根据id值在裁判表，把要求数量的裁判和裁判小组连接起来
            juryPanelService add=new juryPanelService();
            add.addJuryPanel(id,refereenumber);
            flag=1;
        }else {
            flag=0;
        }


        PrintWriter out=response.getWriter();
        out.println(flag);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }

    @Test
    public void test()
    {

        int n=12;
        //给小组设置状态位为1，为了在前端判断该小组裁判是否时忙碌。
        setPanelStatusSql set=new setPanelStatusSql();
        set.setPanelStatus(n,1);

//        String position="aaaaaa";
//        String refereenumber="5";
//
//        addRefereePanelSql info=new addRefereePanelSql();
//        int n=info.addRefereePanel(position,refereenumber);
//
////        juryPanelService add=new juryPanelService();
////        add.addJuryPanel(1,refereenumber);
//        System.out.println(n);
    }

    @Test
    public void clearing()
    {
        juryPanelService clear=new juryPanelService();
        clear.clearing(1);
    }
}
