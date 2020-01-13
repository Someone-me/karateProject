package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.FileBean;
import cn.anhui.karate.service.FileBeanService;
import cn.anhui.karate.service.impl.FileBeanServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/UpdatePictureInforServlet")
public class UpdatePictureInforServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取map
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        FileBean bean=new FileBean();
        try {
            BeanUtils.populate(bean,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service修改
        FileBeanService service=new FileBeanServiceImpl();
        service.updatePicture(bean);
        response.sendRedirect(request.getContextPath()+"/PictureListServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
