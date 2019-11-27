package LX.servlet;

import LX.bean.BY.zj;
import LX.bean.yy;
import LX.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class Ser {
    //调dao层
    Dao dao=new Dao();

    public List<yy> Look() throws SQLException {
        return dao.Look();
    }

    public List<zj> BYLook() throws SQLException {
        return dao.BYLook();
    }
}
