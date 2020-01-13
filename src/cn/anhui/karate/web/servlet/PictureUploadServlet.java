package cn.anhui.karate.web.servlet;

import cn.anhui.karate.domain.FileBean;
import cn.anhui.karate.service.FileBeanService;
import cn.anhui.karate.service.impl.FileBeanServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
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
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/PictureUploadServlet")
public class PictureUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //创建工厂类
            DiskFileItemFactory factory=new DiskFileItemFactory(10*1024,new File("f:/temp"));
            //创建解析器
            ServletFileUpload upload=new ServletFileUpload(factory);
            //文件名称中文问题
            upload.setHeaderEncoding("utf-8");
            //限制文件大小
            upload.setFileSizeMax(2*1024*1024);//每个文件
            upload.setSizeMax(8*1024*1024);//总文件
            //解析文件
            List<FileItem> list=upload.parseRequest(request);

            FileBeanService service=new FileBeanServiceImpl();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            ArrayList<FileBean> fileList = new ArrayList<FileBean>();

            if(list!=null){
                FileBean bean=null;
                //遍历每一个文件
                for(FileItem item:list){
                    //判断是普通组件还是文件域
                    if(item.isFormField()){
                        //设置普通组件信息描述
                        bean.setInformation(item.getString("utf-8"));
                        fileList.add(bean);
                        //保存到数据库
                        service.savePicture(bean);
                    }else {
                        //封装FileBean对象
                        bean=new FileBean();
                        //利用UUID生成伪随机字符串
                       /* String uuid= UUID.randomUUID().toString();*/
                        String fileName=item.getName();
                        //产生随机文件名，防止文件名重复
                        /*fileName=uuid+fileName.substring(fileName.lastIndexOf("."));*/
                        /*fileName=fileName+fileName.substring(fileName.lastIndexOf("."));*/
                        //得到web应用中的某个目录的决定路径
                        String baseDir="F:/文件/newKarate/karate/web/images";
                        /*String baseDir=request.getSession().getServletContext().getRealPath("E:/IdeaWork/karate/web/images");*/
                        String subDir=makeDirectory(fileName);
                        String finalDir=baseDir+"/"+subDir;

                        //获取文件的大小
                        long size=item.getSize();
                        //获取文件的类型
                        String contentType=item.getContentType();
                        FileUtils.copyInputStreamToFile(item.getInputStream(),new File(finalDir+fileName));
                        //删除临时文件
                        item.delete();

                        //把文件信息保存到数据库中
                        bean.setName(fileName);
                        //计算文件大小
                        String sizeStr="";
                        if (size >= 1024 && size < 1024 * 1024) {
                            sizeStr = (size / 1024.0) + "KB";
                        } else if (size >= 1024 * 1024 && size <= 1024 * 1024 * 1024) {
                            sizeStr = (size / (1024.0 * 1024)) + "MB";
                        } else if (size >= 1024 * 1024 * 1024) {
                            sizeStr = (size / (1024.0 * 1024 * 1024)) + "GB";
                        } else {
                            sizeStr = size + "Byte";
                        }
                        bean.setSize(sizeStr);
                        bean.setType(contentType);
                        bean.setUploadTime(sdf.format(new Date()));
                        bean.setFilepath("/images"+"/"+subDir+fileName);
                    }
                }
                //把完成的文件信息转发到jsp页面显示
                request.setAttribute("fileList",fileList);
                request.getRequestDispatcher("/pictureSuccess.jsp").forward(request,response);
                /*response.sendRedirect("index.html");*/

            }


        }catch (FileUploadBase.FileSizeLimitExceededException e){
            request.setAttribute("msg", "单个文件超过设定的大小：2MB");
            request.getRequestDispatcher("/pictureUpload.jsp").forward(request, response);
        }catch (FileUploadBase.SizeLimitExceededException e){
            request.setAttribute("msg", "超过总文件大小：8MB");
            request.getRequestDispatcher("/pictureUpload.jsp").forward(request, response);
        }
        catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
    private String makeDirectory(String fileName){
    /*//得到文件名的hashCode值
    int code=fileName.hashCode();
    //算出第一层目录名称
    int first=code& 0xF;
    //算出第二层目录名称
    int second=code & (0xF>>1);*/
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
