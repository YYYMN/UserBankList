package by.novicov.project.service;

import by.novicov.project.model.User;
import by.novicov.project.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getRichestUser() {

        return userDAO.getRichestUser();
    }

    @Override
    public User getById(Long id) {
        return userDAO.getOne(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }
}
