package by.novicov.project.dao;

import by.novicov.project.entity.User;

import java.util.List;

public interface UserDAO {
    User getById(int id);
    List<User> getAllUsers();
    User getRichestUser();
}
