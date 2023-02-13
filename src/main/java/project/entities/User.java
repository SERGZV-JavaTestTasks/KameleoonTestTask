package project.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class User implements Comparable<User>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Date dateOfCreation = new Date();
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Quote> quotes = new TreeSet<>();

    public Long getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public Set<Quote> getQuotes() { return quotes; }

    public User() {}

    public User(String name, String email, String password, Date dateOfCreation, Set<Quote> quotes)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfCreation = dateOfCreation;
        this.quotes = quotes;
    }

    public void addQuote(Quote quote)
    {
        quotes.add(quote);
    }

    public TreeSet<Quote> getSetBestQuotes(int numberOfQuotes)
    {
        TreeSet<Quote> returnedQuotes = new TreeSet<>();

        var iteration = 0;
        var quotesSize = quotes.size();
        for (var quote : quotes)
        {
            if (iteration < quotesSize && iteration < numberOfQuotes)
            {
                returnedQuotes.add(quote);
            }
            else break;

            iteration ++;
        }

        return returnedQuotes;
    }

    public TreeSet<Quote> getSetWorstQuotes(int numberOfQuotes)
    {
        TreeSet<Quote> returnedQuotes = new TreeSet<>((o1, o2) ->
        {
            if ((o1.getQuoteRating() - o2.getQuoteRating()) != 0) return o1.getQuoteRating() - o2.getQuoteRating();
            return (int)(o1.getId() - o2.getId());
        });

        TreeSet<Quote> bufferedQuotes = new TreeSet<>((o1, o2) ->
        {
            if ((o1.getQuoteRating() - o2.getQuoteRating()) != 0) return o1.getQuoteRating() - o2.getQuoteRating();
            return (int)(o1.getId() - o2.getId());
        });
        bufferedQuotes.addAll(quotes);

        var iteration = 0;
        var quotesSize = quotes.size();
        for (var bufferedQuote : bufferedQuotes)
        {
            if (iteration < quotesSize && iteration < numberOfQuotes)
            {
                returnedQuotes.add(bufferedQuote);
            }
            else break;

            iteration ++;
        }

        return returnedQuotes;
    }

    public void deleteQuote(Long quoteId)
    {
        quotes.removeIf(quote -> quote.getId() == quoteId);
    }

    @Override
    public int compareTo(User o)
    {
        return (int)(this.id - o.id);
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", quotes=" + quotes +
                '}';
    }
}
