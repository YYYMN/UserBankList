package by.novicov.project.service;

import by.novicov.project.model.Account;
import by.novicov.project.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> getAll() {
        return accountDAO.findAll();
    }

    @Override
    public int getSumAccounts() {
        return accountDAO.getSumAccounts();
    }
}
