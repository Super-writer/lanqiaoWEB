package LX.seviver;

import LX.bean.BY.BY_PageBean;
import LX.bean.BY.zj;
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

@WebServlet("/BY_Servlet")
public class BY_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            Ser ser=new Ser();
            List<zj> zjs=ser.BYLook();

            BY_PageBean pageBean=new BY_PageBean();
            pageBean.setData(zjs);
            ObjectMapper mapper=new ObjectMapper();
            String response1 = mapper.writeValueAsString(pageBean);
            System.out.println(response1);
            response.getWriter().write(response1);
            System.out.println(156);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
