package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entities.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {}
