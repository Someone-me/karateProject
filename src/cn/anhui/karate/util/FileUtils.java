package cn.anhui.karate.util;

import cn.anhui.karate.domain.FileBean;

import java.io.File;

public class FileUtils {
    public static boolean delete(String filepath){
        File file = new File(filepath);
        if(!file.isFile()){
            System.out.println("删除失败，文件不存在！");
            return false;
        }

        file.delete();

        return true;
    }
}
