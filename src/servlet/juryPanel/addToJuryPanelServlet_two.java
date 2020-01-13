package servlet.juryPanel;

import cn.juryPanel.juryPanel;
import domain.juryPanel.addRefereePanelSql;
import domain.juryPanel.addToJuryPanelSql;
import domain.juryPanel.panelListSql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addToJuryPanelServlet_two")
public class addToJuryPanelServlet_two extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String position=request.getParameter("position");

        String[] id_array;
        id_array= (String[]) request.getServletContext().getAttribute("id_array");

        String refereenumber=String.valueOf(id_array.length);

            //把小组信息放到表中，并返回一个唯一的id值
            addRefereePanelSql info=new addRefereePanelSql();
            int id=info.addRefereePanel(position,refereenumber);

            System.out.println("11111111");
            //在裁判表中把组号存到选中的裁判相应的位置，给裁判状态设置为忙碌
            List<juryPanel> list=new ArrayList<>();
            addToJuryPanelSql add=new addToJuryPanelSql();
            list=add.addToJuryPanel(id_array,id);

            System.out.println("2222222222222");
            //把裁判放到refereelist_ed表中，为了查看名单用
            panelListSql insert=new panelListSql();
            insert.addpanelList(list,id);

            System.out.println("3333333333333");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
