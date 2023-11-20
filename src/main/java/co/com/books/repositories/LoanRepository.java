package co.com.books.repositories;

import co.com.books.models.Loan;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends R2dbcRepository<Loan, Long> {

}
