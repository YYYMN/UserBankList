package by.novicov.project.service;

import by.novicov.project.dao.AccountDAO;
import by.novicov.project.dao.AccountDAOImpl;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public int sumOfAllBankAccounts() {
        return accountDAO.sumOfAllBankAccounts();
    }
}
