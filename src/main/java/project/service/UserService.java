package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entities.Quote;
import project.entities.User;
import project.repository.QuoteRepository;
import project.repository.UserRepository;

@Service
public class UserService
{
    UserRepository userRepository;
    QuoteRepository quoteRepository;

    @Autowired
    public UserService(UserRepository userRepository, QuoteRepository quoteRepository)
    {
        this.userRepository = userRepository;
        this.quoteRepository = quoteRepository;
    }

    public void createUser(User user)
    {
        userRepository.save(user);
        System.out.println("user created: " + user);
    }

    public User getUser(Long id)
    {
        return userRepository.getById(id);
    }

    public void createQuote(String quoteString, User user)
    {
        Quote quote = new Quote(quoteString, user);
        user.addQuote(quote);
        userRepository.save(user);
    }

    public Quote getQuote(Long quoteId)
    {
        return quoteRepository.getById(quoteId);
    }

    public Quote getRandomQuote()
    {
        var quote = quoteRepository.getRandomQuote();
        return quote;
    }

    public void editQuote(String newQuoteContent, Long quoteId)
    {
        var quote = quoteRepository.getById(quoteId);
        quote.setContent(newQuoteContent);
        quoteRepository.save(quote);
    }

    public void voteForAQuote(Long userVoterId, Long votedQuoteId, boolean voteFor)
    {
        var userVoter = userRepository.getById(userVoterId);
        var quote = quoteRepository.getById(votedQuoteId);
        quote.vote(userVoter, voteFor);
        quoteRepository.save(quote);
    }

    public void deleteQuote(Long UserId, Long quoteId)
    {
        var user = userRepository.getById(UserId);
        user.deleteQuote(quoteId);
        userRepository.save(user);
    }
}
