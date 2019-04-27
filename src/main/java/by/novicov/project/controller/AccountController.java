package by.novicov.project.controller;

import by.novicov.project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("sumAccounts")
    public String accountMain(Map<String, Object> model) {
        int sumAccounts = accountService.getSumAccounts();
        model.put("sumAccounts", sumAccounts);
        return "sumAccounts";
    }
}
