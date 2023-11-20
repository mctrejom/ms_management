package co.com.books.controllers;

import co.com.books.dto.LoanDto;
import co.com.books.models.Loan;
import co.com.books.services.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LoanControllerTest {
    @Mock
    LoanService loanService;

    @InjectMocks
    LoanController loanController;

    LoanDto loanDto;
    Loan loan;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        loanDto = new LoanDto();
        loanDto.setBookId(1L);
        loanDto.setUserId(1L);
        loanDto.setQuantityDays(2L);

        loan = new Loan();
        loan.setUserId(loanDto.getUserId());
        loan.setBookId(loanDto.getBookId());
        loan.setReturned(false);
    }

    @Test
    void lendBookTest() {
        when(loanService.lendBook(any())).thenReturn(Mono.just(loan));

        loanController.lendBook(loanDto)
                .as(StepVerifier::create)
                .expectNextMatches(responseEntity -> responseEntity.getStatusCode() == HttpStatus.CREATED &&
                        responseEntity.getBody() == loan)
                .verifyComplete();
    }
}