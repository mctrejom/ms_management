package co.com.books.controllers;

import co.com.books.dto.LoanDto;
import co.com.books.models.Loan;
import co.com.books.services.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;

    @PostMapping
    public Mono<ResponseEntity<Loan>> lendBook(@RequestBody LoanDto loanDto){
        return loanService.lendBook(loanDto)
                .map(loan -> new ResponseEntity<>(loan, HttpStatus.CREATED));
    }
}
