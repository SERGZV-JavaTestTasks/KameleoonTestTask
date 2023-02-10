package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.entities.User;
import project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user)
    {
        userService.createUser(user);
        return "user/created";
    }

    @PostMapping("/createQuote")
    public String createQuote(@RequestParam String quote, @RequestParam Long userId)
    {
        var user = userService.getUser(userId);
        userService.createQuote(quote, user);

        return "quote/created";
    }
}
