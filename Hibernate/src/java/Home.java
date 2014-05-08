
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jx3
 */
@WebServlet(urlPatterns = {"/Home"})
public class Home extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       
        
        System.out.println("run");
        
        //configureer connectie
        Configuration cfg = new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        //maak een employee 
        Scoutslid scouts = new Scoutslid();
        scouts.setNaam(request.getParameter("Naam"));
        scouts.setScoutsnaam(request.getParameter("Scoutsnaam"));
        scouts.setEmailadres(request.getParameter("Emailadres"));

        //bereid voor om weg te schrijven naar db
        s.save(scouts);  
        s.flush();

        //schrijf weg
        tx.commit();

        //sluit connectie
        s.close();

        //haal de employees op
        //open een sessie
        s = sf.openSession();


        //Haal alle scoutsleden op
        List scoutsleden = s.createCriteria(Scoutslid.class).list();
        ArrayList<Scoutslid> aScout = new ArrayList();
        for (Iterator it1 = scoutsleden.iterator(); it1.hasNext();) {
            Scoutslid Sc = (Scoutslid) it1.next();
            aScout.add(Sc);

        }

        request.getSession().setAttribute("Scoutslid", aScout);

        //sluit de connectie
        s.close();

        request.getRequestDispatcher("results.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
