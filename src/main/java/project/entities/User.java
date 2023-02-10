package project.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<Quote> quotes = new ArrayList<>();

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }

    public User() {}

    public User(String name, String email, String password, Date dateOfCreation, List<Quote> quotes)
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
        System.out.println("test");
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
