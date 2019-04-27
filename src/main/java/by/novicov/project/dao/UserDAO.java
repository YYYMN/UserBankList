package by.novicov.project.dao;

import by.novicov.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    @Query("SELECT u from User u inner join u.account ac WHERE u.account.account = " +
            "(SELECT MAX(ac.account) FROM Account ac)")
    List<User> getRichestUser();
}


