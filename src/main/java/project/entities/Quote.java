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
    private int quoteRating;
    @ManyToOne
    private User messageAuthor;
    @ManyToMany
    private Set<User> voters = new TreeSet<>();

    public Long getId() { return id; }
    public void setContent(String content) { this.content = content; }
    public String getContent() { return content; }
    public Date getDateOfUpdate() { return dateOfUpdate; }
    public int getQuoteRating() { return quoteRating; }
    public User getMessageAuthor() { return messageAuthor; }
    public Set<User> getVoters() { return voters; }

    public Quote() {}

    public Quote(String content, User messageAuthor)
    {
        this.content = content;
        this.messageAuthor = messageAuthor;
    }

    public void vote(User userVoter, boolean voteFor)
    {
        for (var voter : voters)
        {
            if (voter.getId().equals(userVoter.getId()))
            {
                return;
            }
        }

        voters.add(userVoter);
        quoteRating = (voteFor) ? 1 : -1;
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
