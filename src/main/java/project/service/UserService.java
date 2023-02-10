package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entities.Quote;
import project.entities.User;
import project.repository.QuoteRepository;
import project.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class UserService
{
    @PersistenceContext
    EntityManager entityManager;
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
}
