package by.novicov.project.service;

import by.novicov.project.dao.UserDAO;
import by.novicov.project.dao.UserDAOImpl;
import by.novicov.project.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getRichestUser() {
        return userDAO.getRichestUser();
    }
}
