package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping(value = "/edit/{id}" )
    public String updateUser(@PathVariable Long id, Model model) {
        model.addAttribute("id",id);
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "update";
    }

    @PostMapping(path = "add" )
    public String addUser(@RequestParam("name") String name, @RequestParam("lastName") String lastName,
                @RequestParam("age") int age) {

        userService.addUser(name,lastName,age);

        return "redirect:/";
    }
    @PostMapping(path = "/update" )
    public String editUser(@RequestParam("name") String name, @RequestParam("lastName") String lastName,
                          @RequestParam("age") int age,@RequestParam("id") Long id) {

        userService.editUser(name,lastName,age,id);

        return "redirect:/";
    }
}
