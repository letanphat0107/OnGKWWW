package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.services.CandidateService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/controller")
public class Servlet extends HttpServlet {
    private final CandidateService candidateService;

    public Servlet() {
        candidateService = new CandidateService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);

        if(action.equalsIgnoreCase("lstCandidate")){
            session.setAttribute("lstCan", candidateService.findAll());
            req.getRequestDispatcher("candidates.jsp").forward(req, resp);
        }else if(action.equalsIgnoreCase("moreInfo")){
            Candidate candidate = candidateService.findById(Integer.parseInt(req.getParameter("idCan")));
            session.setAttribute("can", candidate);
            req.getRequestDispatcher("cand_details.jsp").forward(req, resp);
        }else if(action.equalsIgnoreCase("report1")){
            session.setAttribute("lstCan", null);
            req.getRequestDispatcher("report1.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);

        if(action.equalsIgnoreCase("timKiem")){
            String companyName = req.getParameter("companyName");
            List<Candidate> lstCan = candidateService.findDevByCompany(companyName);
            System.out.println(companyName);
            session.setAttribute("lstCan", lstCan);
            req.getRequestDispatcher("report1.jsp").forward(req, resp);
        }
    }
}
