package by.novicov.project.servlet;

import by.novicov.project.entity.User;
import by.novicov.project.service.AccountService;
import by.novicov.project.service.AccountServiceImpl;
import by.novicov.project.service.UserService;
import by.novicov.project.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserBankListServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("richest user".equals(req.getParameter("richestUser"))) {
            User richestUser = userService.getRichestUser();
            req.setAttribute("richestUser", richestUser);
            req.getRequestDispatcher("/richestUser.jsp").forward(req, resp);
        } else if ("accounts sum".equals(req.getParameter("accountsSum"))) {
            int sumOfAllBankAccounts = accountService.sumOfAllBankAccounts();
            req.setAttribute("sumOfAllBankAccounts", sumOfAllBankAccounts);
            req.getRequestDispatcher("/sumOfAllBankAccounts.jsp").forward(req, resp);
        }
    }
}
