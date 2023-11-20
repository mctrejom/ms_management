package co.com.books.services;

import co.com.books.dto.LoanDto;
import co.com.books.models.Loan;
import co.com.books.repositories.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class LoanService {
    private final LoanRepository loanRepository;

    public Mono<Loan> lendBook(LoanDto loanDto){
        Loan loan = new Loan();
        loan.setBookId(loanDto.getBookId());
        loan.setUserId(loanDto.getUserId());
        loan.setCreated_at(LocalDate.now());
        loan.setReturn_date(LocalDate.now().plusDays(loanDto.getQuantityDays()));
        loan.setReturned(false);

        return loanRepository.save(loan);
    }
}
