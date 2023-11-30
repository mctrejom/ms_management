package co.com.books.controllers;

import co.com.books.dto.LoanDto;
import co.com.books.models.Loan;
import co.com.books.services.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "PrestamosController", description = "Gestión de prestamos de libros")
public class LoanController {
    private final LoanService loanService;

    @PostMapping
    @Operation(summary = "Crear prestamo de libro", description = "Permite prestar un libro")
    @Parameter(name = "Prestamo", description = "Prestamo a crear",
            content = @Content(schema = @Schema(implementation = LoanDto.class)))
    @ApiResponse(responseCode = "200", description = "Prestamo Creado",
            content = @Content(schema = @Schema(implementation = Loan.class)))
    public Mono<ResponseEntity<Loan>> lendBook(@RequestBody LoanDto loanDto){
        return loanService.lendBook(loanDto)
                .map(loan -> new ResponseEntity<>(loan, HttpStatus.CREATED));
    }
}
