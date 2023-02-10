package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.entities.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long>
{
    @Query(value = "SELECT * FROM quote ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public Quote getRandomQuote();
}
