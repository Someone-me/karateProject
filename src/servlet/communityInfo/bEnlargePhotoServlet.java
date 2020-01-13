package servlet.communityInfo;

import cn.communityInfo.AenlargePhoto;
import cn.communityInfo.BenlargePhoto;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.communityInfo.enlargePhotoSql;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bEnlargePhotoServlet")
public class bEnlargePhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=(String)request.getServletContext().getAttribute("Id");
        enlargePhotoSql find=new enlargePhotoSql();

        List<BenlargePhoto> aphoto=find.FindBenlagePhoto(id);

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),aphoto);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    @Test
    public void test()
    {
        String id="1";
        enlargePhotoSql find=new enlargePhotoSql();

        List<BenlargePhoto> aphoto=find.FindBenlagePhoto(id);

        System.out.println(aphoto);
    }
}
