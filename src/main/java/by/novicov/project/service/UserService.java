package by.novicov.project.service;

import by.novicov.project.entity.User;

import java.util.List;

public interface UserService {
    User getById(int id);
    List<User> getAllUsers();
    User getRichestUser();
}
