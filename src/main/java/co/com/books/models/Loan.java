package co.com.books.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("loan")
@Schema(description = "Schema de prestamo")
public class Loan {
    @Id
    @Schema(description = "Id unico del prestamo", example = "1")
    private Long id;
    @Schema(description = "Id unico del usuario", example = "1")
    private Long userId;
    @Schema(description = "Id unico del libro", example = "1")
    private Long bookId;
    @Schema(description = "Fecha del prestamo", example = "2023-11-30")
    private LocalDate created_at;
    @Schema(description = "Fecha de retorno", example = "2023-12-10")
    private LocalDate return_date;
    @Schema(description = "Flag para identificar si fue devuelto", example = "false")
    private Boolean returned;
}
