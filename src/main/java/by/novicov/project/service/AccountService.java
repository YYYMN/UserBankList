package by.novicov.project.service;

import by.novicov.project.model.Account;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountService {
    List<Account> getAll();

    int getSumAccounts();
}
