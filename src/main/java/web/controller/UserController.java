package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;


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

    @GetMapping(value = "/edit/{id}" )
    public String updateUser(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "update";
    }

    @PostMapping(path = "add" )
    public String addUser(@ModelAttribute("user") User user) {

        userService.addUser(user);

        return "redirect:/";
    }
    @PostMapping(path = "/update" )
    public String editUser( @ModelAttribute("user") User user, @RequestParam("id") Long id) {

        userService.editUser(user);
        return "redirect:/";
    }
    @ModelAttribute(value = "user")
    public User newUser()
    {
        return new User();
    }

}
