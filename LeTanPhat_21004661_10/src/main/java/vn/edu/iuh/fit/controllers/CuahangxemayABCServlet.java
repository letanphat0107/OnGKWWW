package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.dtos.XeDTO;
import vn.edu.iuh.fit.services.XeService;
import vn.edu.iuh.fit.services.impl.XeServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CuahangxemayABCServlet", value = "/controller")
public class CuahangxemayABCServlet extends HttpServlet {
    private final XeService xeService;

    public CuahangxemayABCServlet() {
        this.xeService = new XeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);

        if (action.equalsIgnoreCase("dsxe")){
            List<XeDTO> xeDTOS = xeService.getXeDTOs();
            session.setAttribute("xeDTOs", xeDTOS);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("themXe")){
            session.setAttribute(("hangXeList"), xeService.getAllHangXe());
            session.setAttribute("xeDTO", new XeDTO());
            req.getRequestDispatcher("formAddXe.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(true);
        String action = req.getParameter("action");

        long id = Long.parseLong(req.getParameter("maXe"));
        String tenXe = req.getParameter("tenXe");
        String giaXe = req.getParameter("giaXe");
        String namSX = req.getParameter("namSX");
        String hangXe = req.getParameter("hangXe");
        if(action.equalsIgnoreCase("timKiem")) {
            String tenXeTimKiem = req.getParameter("tenTimKiem");
            List<XeDTO> xeDTOs = xeService.getXeDTOByTen(tenXeTimKiem);
            session.setAttribute("xeDTOs", xeDTOs);
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("themXe"))
        {
            XeDTO xeDTO = new XeDTO(tenXe, Double.parseDouble(giaXe), Integer.parseInt(namSX), hangXe);
            boolean result= xeService.save(xeDTO);

            if(result)
                resp.sendRedirect("controller?action=dsXe");
        }
    }

}
