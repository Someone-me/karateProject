package servlet.juryPanel;

import domain.juryPanel.setPanelStatusSql;
import service.juryPanelService.juryPanelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recoveryStateServlet")
public class recoveryStateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Id=request.getParameter("id");
        //把裁判状态清零（该为待分组）
        juryPanelService clear=new juryPanelService();
        int id=Integer.parseInt(Id);
        clear.clear(id);

        //给小组设置状态位为1，为了在前端判断该小组裁判是否是忙碌。
        setPanelStatusSql set=new setPanelStatusSql();
        set.setPanelStatus(id,0);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
