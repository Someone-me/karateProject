package cn.anhui.karate.web.servlet;



import cn.anhui.karate.domain.PictureBean;
import cn.anhui.karate.service.PictureBeanService;
import cn.anhui.karate.service.impl.PictureBeanServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@WebServlet("/MatchPictureUploadServlet")
public class MatchPictureUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*PictureBeanService service=new PictureBeanServiceImpl();*/
        try {
            //创建工厂类
            DiskFileItemFactory factory=new DiskFileItemFactory(10*1024,new File("f:/temp"));
            //创建解析器
            ServletFileUpload upload=new ServletFileUpload(factory);
            //文件名称中文问题
            upload.setHeaderEncoding("utf-8");

            //解析文件
            List<FileItem> list=upload.parseRequest(request);

            PictureBeanService service=new PictureBeanServiceImpl();

            ArrayList<PictureBean> fileList = new ArrayList<PictureBean>();

            if(list!=null){
                PictureBean bean=null;
                //遍历每一个文件
                for(FileItem item:list){
                    //判断是普通组件还是文件域
                    if(item.isFormField()){
                        //设置普通组件信息描述
                        bean.setTitle(item.getString("utf-8"));
                        fileList.add(bean);
                        //保存到数据库
                        service.saveMatchPicture(bean);
                    }else {
                        //封装FileBean对象
                        bean=new PictureBean();
                        //利用UUID生成伪随机字符串
                         String uuid= UUID.randomUUID().toString();
                        String fileName=item.getName();
                        //产生随机文件名，防止文件名重复
                        fileName=uuid+fileName.substring(fileName.lastIndexOf("."));
                        /*fileName=fileName+fileName.substring(fileName.lastIndexOf("."));*/
                        //得到web应用中的某个目录的决定路径
                        String baseDir="F:/文件/newKarate/karate/web/picture/image";
                        /*String baseDir=request.getSession().getServletContext().getRealPath("E:/IdeaWork/karate/web/images");*/
                        String subDir=makeDirectory(fileName);
                        String finalDir=baseDir+"/"+subDir;

                        FileUtils.copyInputStreamToFile(item.getInputStream(),new File(finalDir+fileName));
                        //删除临时文件
                        item.delete();

                        //把文件信息保存到数据库中
                        bean.setName(fileName);
                        bean.setFilepath("picture/image"+"/"+subDir+fileName);
                    }
                }
                //把完成的文件信息转发到jsp页面显示
                request.setAttribute("fileList",fileList);
                request.getRequestDispatcher("/matchPictureUploadSuccess.jsp").forward(request,response);

            }

        }
        catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
    private String makeDirectory(String fileName){
        Calendar now= Calendar.getInstance();
        //获取年月日
        int year=now.get(Calendar.YEAR);
        int month=now.get(Calendar.MONTH)+1;
        int day=now.get(Calendar.DAY_OF_MONTH);
        return year+"/"+month+"/"+day+"/";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
