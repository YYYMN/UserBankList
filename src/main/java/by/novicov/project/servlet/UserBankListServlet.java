package by.novicov.project.servlet;

import by.novicov.project.entity.User;
import by.novicov.project.service.AccountDAOImpl;
import by.novicov.project.service.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserBankListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("richest user".equals(req.getParameter("richestUser"))) {
            UserDAOImpl userDAO = new UserDAOImpl();
            User richestUser = userDAO.getRichestUser();
            req.setAttribute("richestUser", richestUser);
            req.getRequestDispatcher("/richestUser.jsp").forward(req, resp);
        } else if ("accounts sum".equals(req.getParameter("accountsSum"))) {
            AccountDAOImpl accountDAO = new AccountDAOImpl();
            int sumOfAllBankAccounts = accountDAO.sumOfAllBankAccounts();
            req.setAttribute("sumOfAllBankAccounts", sumOfAllBankAccounts);
            req.getRequestDispatcher("/sumOfAllBankAccounts.jsp").forward(req, resp);
        }
    }
}
