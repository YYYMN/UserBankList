package by.novicov.project.controller;


import by.novicov.project.model.User;
import by.novicov.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userMain(Map<String, Object> model) {
        Iterable<User> users = userService.getAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("richestUser")
    public String getRichestUser(Map<String, Object> model) {
        Iterable<User> richestUser = userService.getRichestUser();
        model.put("users", richestUser);
        return "richestUser";
    }
}
