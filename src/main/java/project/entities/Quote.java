package project.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Quote
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date dateOfUpdate = new Date();
    @ManyToOne
    private User messageAuthor;
    @ManyToMany
    private Set<User> voters = new TreeSet<>();

    public Quote() {}

    public Quote(String content, User messageAuthor)
    {
        this.content = content;
        this.messageAuthor = messageAuthor;
    }

    @Override
    public String toString()
    {
        return "Quote{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", dateOfUpdate=" + dateOfUpdate +
                '}';
    }
}
