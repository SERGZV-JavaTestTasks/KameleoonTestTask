package project.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Quote
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date dateOfUpdate;
    @ManyToOne
    private User messageAuthor;
    @ManyToMany
    private Set<User> voters;
}
