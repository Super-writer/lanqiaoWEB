package LX.utlis;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCGJL {
    //    private static BasicDataSource ds=new BasicDataSource();
    private static DruidDataSource ds = new DruidDataSource();

    static {
        try {
            Properties po = new Properties();
            InputStream is = JDBCGJL.class.getClassLoader().getResourceAsStream("db.properties");
            po.load(is);
            String dr = po.getProperty("driver");
            String url = po.getProperty("url");
            String name = po.getProperty("name");
            String key = po.getProperty("key");
            ds.setDriverClassName(dr);
            ds.setUrl(url);
            ds.setUsername(name);
            ds.setPassword(key);
        } catch (IOException e) {
            System.out.println("连接失败");
        }

    }

    public static DataSource getDS() {
        return ds;

    }
}
