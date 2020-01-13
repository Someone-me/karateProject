package Util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutil {

    private static DataSource sp;


    static {

        try {
            Properties pro=new Properties();
            InputStream is= JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            pro.load(is);
            sp= DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getdatasource(){
        return sp;
    }

    public static Connection getconnection() throws SQLException {
        return sp.getConnection();
    }
}
