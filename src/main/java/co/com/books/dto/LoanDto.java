package co.com.books.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Schema de parametros de entrada")
public class LoanDto {
    @Schema(description = "Id unico del usuario", example = "1")
    private Long userId;
    @Schema(description = "Id unico del libro", example = "1")
    private Long bookId;
    @Schema(description = "Cantidad de dias a prestar", example = "11")
    private Long quantityDays;
}
