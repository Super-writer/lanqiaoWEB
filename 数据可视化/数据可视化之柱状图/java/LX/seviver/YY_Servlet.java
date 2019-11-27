package LX.seviver;

import LX.bean.PageBean;
import LX.bean.yy;
import LX.servlet.Ser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/YY_Servlet")
public class YY_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println(11);
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            //调servlet层
            Ser ser=new Ser();
            //yy表示一个对象的bean类
            List<yy> y=ser.Look();

            //把从数据库查到的东西有一个PageBean对象封装，PageBean对象里有json对象的格式
            PageBean pageBean=new PageBean();
            pageBean.setData(y);
            ObjectMapper mapper=new ObjectMapper();
            String response1 = mapper.writeValueAsString(pageBean);
            System.out.println(response1);
            response.getWriter().write(response1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
