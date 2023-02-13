package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/getQuote")
    public String getQuote(@RequestParam Long quoteId, Model model)
    {
        var quote = userService.getQuote(quoteId);
        model.addAttribute("quote", quote);

        return "quote/show";
    }

    @GetMapping("/getRandomQuote")
    public String getRandomQuote(Model model)
    {
        var quote = userService.getRandomQuote();
        model.addAttribute("quote", quote);

        return "quote/show";
    }

    @PatchMapping("/editQuote")
    public String editQuote(@RequestParam String newQuoteContent, @RequestParam Long quoteId)
    {
        userService.editQuote(newQuoteContent, quoteId);
        return "quote/show";
    }

    @PatchMapping("/voteForAQuote")
    public String voteForAQuote
    (
        @RequestParam Long userVoterId,
        @RequestParam Long votedQuoteId,
        @RequestParam boolean voteFor
    )
    {
        userService.voteForAQuote(userVoterId, votedQuoteId, voteFor);
        return "quote/show";
    }

    @DeleteMapping("/deleteQuote")
    public String deleteQuote(@RequestParam Long userId, @RequestParam Long quoteId, Model model)
    {
        userService.deleteQuote(userId, quoteId);
        model.addAttribute("deletedQuoteId", quoteId);

        return "quote/deleted";
    }
}
