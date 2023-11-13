package org.nikolausus;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;


@WebServlet("/test")
public class DataManager extends HttpServlet{

    @EJB
    UpravBob upravBob;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ResOfHitEntity resOfHit = new ResOfHitEntity();
//        resOfHit.setX(1);
//        resOfHit.setY(2);
//        resOfHit.setR(3);
//        resOfHit.setRes(true);
//        resOfHit.setEx_at(new Timestamp(new java.util.Date().getTime()));
//        resOfHit.setEx_ti(6);
//
//        upravBob.saveResOfHit(resOfHit);

//        for (Iterator<ResOfHitEntity> it = upravBob.getListResOfHitEntity().iterator(); it.hasNext();) {
//            ResOfHitEntity resOfHit = (ResOfHitEntity) it.next();
//            resp.getWriter().println(resOfHit.getX() + " " + resOfHit.getY() + " " + resOfHit.getR() + " " + resOfHit.isRes() + " " + resOfHit.getEx_at() + " " + resOfHit.getEx_ti());
//        }
        req.getServletContext().setAttribute("data", upravBob.getListResOfHitEntity());
    }
}