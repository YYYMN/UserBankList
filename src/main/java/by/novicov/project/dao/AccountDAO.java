package by.novicov.project.dao;

import by.novicov.project.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountDAO extends JpaRepository<Account, Long> {

    @Query("SELECT SUM(ac.account) FROM Account ac")
    int getSumAccounts();
}
