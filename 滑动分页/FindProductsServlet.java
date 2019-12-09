package org.lanqiao.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.lanqiao.bean.Housing;
import org.lanqiao.bean.Housings;
import org.lanqiao.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/FindProductsServlet")
public class FindProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("进入FindProductsServlet啦。。。");
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            String hname = request.getParameter("hname");//获取房源id
            System.out.println("地区："+hname);
            ProductService service = new ProductService();
            List<Housing> list=null;
            if(hname == ""){
                //查询所有的记录
                list = service.productsByCurrPage();
                for(Housing s :list){
                    System.out.print(s.getHid()+"---");
                }
            }else{
                //查询包含指定地区的内容
                list = service.productsByRegion(hname);
                for(Housing s :list){
                    System.out.print(s.getHid()+"---");
                }
            }

            Housings housings = new Housings();
            housings.setLists(list);

            //把查询到的数据编程json
            ObjectMapper mapper = new ObjectMapper();
            String res = mapper.writeValueAsString(housings);
            System.out.println("转换为json："+res);
            response.getWriter().write(res);
//            response.getWriter().write(res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
