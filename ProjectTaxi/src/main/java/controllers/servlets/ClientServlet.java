package controllers.servlets;

import models.daos.CarDAO;
import models.pojos.Car;
import models.pojos.Client;
import models.pojos.Driver;
import models.pojos.Order;
import org.apache.log4j.Logger;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

/**
 * Created by Yerlan on 27.02.2017.
 */
@WebServlet(name = "ClientServlet")
public class ClientServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(ClientServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("user_object");
        logger.warn("in do Post type = "+type);

        if (type == null) {} else
        if (type.equals("new_order")){
            Order order = generateOrder(request);
            Long id = OrderService.insert(order);
            logger.error("in new order = "+order.toString());
            client.setOrder(id);
            ClientService.updateOrder(client.getId(),id);

        } else if (type.equals("cancel_order")) {
            logger.trace(client.getId());
            ClientService.updateOrder(client.getId(),(long)0);
            OrderService.delete(client.getOrder());
            client.setOrder((long)0);
        }

        session.setAttribute("user_object",client);
        generateUserPage(request,response, client);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("user_object");
        generateUserPage(request,response,client);
    }

    private void generateUserPage(HttpServletRequest request, HttpServletResponse response,Client client) throws ServletException, IOException {
        request.setAttribute("login",client.getFirstname());
        Long orderId = client.getOrder();
        if ( (orderId == 0)||(orderId == null) ) {
            request.setAttribute("ordered",null);
            request.getRequestDispatcher("/user_account.jsp").forward(request,response);
        } else {
            request.setAttribute("ordered","true");
            Order order = OrderService.getOrder(client.getOrder());
            request.setAttribute("from",order.getFrom());
            request.setAttribute("to",order.getTo());
            long i = order.getPrice_per_km();
            String str = ""+i+" Rubles/km";
            if (i==16) {
                str+=" (Economy)";
            } else
            if (i==25) {
                str+=" (Comfort)";
            } else {
                str+=" (Business)";
            }
            request.setAttribute("price", str);
            request.setAttribute("id",order.getId());
            i=order.getDriver();
            String str2;
            if (i>0) {
                Driver driver = DriverService.getDriver(i);
                str=driver.toString();
                Car car = CarService.getCar(driver.getCar());
                str2=car.toString();
            } else {
                str="not assigned yet";
                str2="not assigned yet";
            }
            request.setAttribute("driver",str);
            request.setAttribute("car",str2);
            i=order.getStatus();
            if (i==0) {
                request.setAttribute("status","waiting for a driver");
            } else if (i==1) {
                request.setAttribute("status","driver assigned");
            } else if (i==2) {
                request.setAttribute("status","order fulfilled");
            }
            request.getRequestDispatcher("/user_account.jsp").forward(request,response);
        }
    }

    private Order generateOrder(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("user_object");
        Order order = new Order();
        order.setFrom(request.getParameter("from"));
        order.setTo(request.getParameter("to"));
        order.setPickup_time(Time.valueOf(request.getParameter("pickup_time")+":00"));
        order.setStatus((long)0);
        order.setClient(client.getId());
        String str = request.getParameter("plan");
        if ( str.equals("economy") ) {
            order.setPrice_per_km((long) 16);
        } else if ( str.equals("comfort") ) {
            order.setPrice_per_km((long) 25);
        } else order.setPrice_per_km((long) 40);
        return order;
    }
}
