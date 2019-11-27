package LX.dao;

import LX.bean.BY.zj;
import LX.bean.yy;
import LX.utlis.JDBCGJL;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Dao {
    QueryRunner qr=new QueryRunner(JDBCGJL.getDS());

    public List<yy> Look() throws SQLException {
        //去数据库查询想要可视化数据的表里的数据
        String sql="SELECT dq,COUNT FROM yy";
        List<yy> list = qr.query(sql, new BeanListHandler<yy>(yy.class));
        System.out.println(list);
        return list;
    }

    public List<zj> BYLook() throws SQLException {
        String sql="SELECT yy.dq,zj.count,MONTH.month FROM MONTH,yy,zj WHERE yy.fid=zj.fid AND zj.yid=month.yid";
        List<zj> list = qr.query(sql, new BeanListHandler<zj>(zj.class));
        System.out.println(list);
        return list;
    }
}
