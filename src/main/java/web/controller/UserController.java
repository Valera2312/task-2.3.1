package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import web.models.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController  {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getUser(ModelMap model) {
        model.addAttribute("users",userService.listUsers());
        return "users";
    }
    @GetMapping(value = "delete/{id}" )
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping(value = "/new" )
    public String deleteUser() {
        return "new";
    }

    @PostMapping(path = "add" )
    public String addUser(@ModelAttribute("user") User user) {

        userService.addUser(user);
        return "redirect:/";
    }
}
